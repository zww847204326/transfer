package czbank.jiangjian.controller;


import czbank.jiangjian.entity.Record;
import czbank.jiangjian.entity.User;
import czbank.jiangjian.service.AccountService;
import czbank.jiangjian.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;


    @RequestMapping("/transfer")
    public ResultBean<String> transfer(String fromCardNum,
                                       String toCardNum, String toName,
                                       String toBank, Integer money){
        ResultBean<String> res =
                accountService.transfer(fromCardNum, toCardNum,
                                        toName,toBank,money);
        return res;
    }


    @RequestMapping("/getMoney")
    public ResultBean<Integer> getMoney(String cardNum, HttpSession session) {
        User user = (User) session.getAttribute("user");
        ResultBean<Integer> res = accountService.getMoney(user.getIdCard(), cardNum);
        return res;
    }

    @RequestMapping("/queryCards")
    public ResultBean<List<String>> queryCards(HttpSession session) {
        User user = (User) session.getAttribute("user");
        ResultBean<List<String>> res = accountService.queryCards(user.getIdCard());
        return res;
    }



}
