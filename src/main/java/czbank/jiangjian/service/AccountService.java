package czbank.jiangjian.service;


import czbank.jiangjian.entity.Account;
import czbank.jiangjian.entity.Record;
import czbank.jiangjian.entity.User;
import czbank.jiangjian.mapper.AccountMapper;
import czbank.jiangjian.mapper.RecordMapper;
import czbank.jiangjian.util.ResultBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;


@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    RecordMapper recordMapper;


    @Transactional
    public ResultBean<String> transfer(String fromCardNum,
            String toCardNum, String toName, String toBank, Integer money) {

        ResultBean<String> res = new ResultBean<>();

        Account account = accountMapper.getAccountInf(fromCardNum);
        if(account == null){
            res.setMsg("付款卡号有误");
            res.setCode(3);
            return res;
        }

        if(money <= 0){
            res.setMsg("金额应大于0");
            res.setCode(4);
            return res;
        }
        if (account.getMoney() < money) {
            res.setMsg("余额不足，转账失败");
            res.setCode(5);
            return res;
        }
        Account toAccount = accountMapper.getAccountInf(toCardNum);
        if(toAccount == null){
            res.setMsg("收款卡号有误");
            res.setCode(6);
            return res;
        }
        if(!toAccount.getBankName().equals(toBank)){
            res.setMsg("收款银行不一致");
            res.setCode(7);
            return res;
        }
        if(!toAccount.getName().equals(toName)){
            res.setMsg("收款姓名不一致");
            res.setCode(8);
            return res;
        }

        String fromName = account.getName();
        String fromBank = account.getBankName();

        accountMapper.decreaseMoney(money, fromCardNum, fromName);

        accountMapper.increaseMoney(money, toCardNum, toName);

        //添加转账记录
        Record record = new Record();
        record.setDate(new Date());
        record.setSum(money);
        record.setFromBank(fromBank);
        record.setFromName(fromName);
        record.setFromCardNum(fromCardNum);
        record.setToBank(toBank);
        record.setToName(toName);
        record.setToCardNum(toCardNum);
        recordMapper.addRecord(record);

//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        res.setMsg("交易成功");

        return res;
    }

    public ResultBean<List<String>> queryCards(String idCard) {
        ResultBean<List<String>> res = new ResultBean<>();
        List<String> cards = accountMapper.queryCards(idCard);
        if (cards.size() == 0) {
            res.setCode(3);
            res.setMsg("该用户未开卡");
            return res;
        }
        res.setData(cards);
        return res;
    }


    public ResultBean<Integer> getMoney(String idCard, String cardNum) {
        ResultBean<Integer> res = new ResultBean<>();

        Integer money = accountMapper.getMoney(idCard, cardNum);
        if (money == null) {
            res.setCode(1);
            res.setMsg("查询余额错误");
            return res;
        }

        res.setData(money);
        return res;
    }

}
