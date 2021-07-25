package czbank.jiangjian.service;

import czbank.jiangjian.entity.Record;
import czbank.jiangjian.mapper.RecordMapper;
import czbank.jiangjian.util.ResultBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    RecordMapper recordMapper;

    public ResultBean<List<Record>> queryRecords(String cardNum,  String beginDate,
                                            String endDate){

        ResultBean<List<Record>> res = new ResultBean<>();
        List<Record> records = recordMapper.queryRecords(cardNum, beginDate, endDate);
        res.setData(records);
        if(records.size() == 0){
            res.setMsg("无交易记录");
        }
        for (Record record : records) {
            String fromCardNum = record.getFromCardNum();
            if(cardNum.equals(fromCardNum)){
                record.setDir("转出");
            }else
                record.setDir("转入");
        }

        return res;
    }




}
