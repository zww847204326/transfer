package czbank.jiangjian.controller;

import czbank.jiangjian.entity.Record;
import czbank.jiangjian.service.RecordService;
import czbank.jiangjian.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("record")
public class RecordController {

    @Autowired
    RecordService recordService;


    @RequestMapping("/queryRecords")
    public ResultBean<List<Record>> queryRecords(String cardNum, String beginDate,
                                                 String endDate) {

        ResultBean<List<Record>> res = recordService.queryRecords(cardNum,beginDate,endDate);
        return res;
    }

}
