package czbank.jiangjian.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Record {

    //自增主键
    private Integer id;

    //金额
    private Integer sum;

    //转账日期
    @JsonFormat(pattern="yyyy年MM月dd日 HH时mm分ss秒",timezone="GMT+8")
    private Date date;

    //转出卡号
    private String fromCardNum;

    //转出账户姓名
    private String fromName;

    //转出账户银行
    private String  fromBank;

    //转入卡号
    private String toCardNum;

    //转入账户姓名
    private String toName;

    //转入账户银行
    private String  toBank;

    //付款或者收款
    private String dir;


    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", sum=" + sum +
                ", date=" + date +
                ", fromCardNum='" + fromCardNum + '\'' +
                ", fromName='" + fromName + '\'' +
                ", fromBank='" + fromBank + '\'' +
                ", toCardNum='" + toCardNum + '\'' +
                ", toName='" + toName + '\'' +
                ", toBank='" + toBank + '\'' +
                ", dir='" + dir + '\'' +
                '}';
    }

    public Record() {

    }


    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getFromCardNum() {
        return fromCardNum;
    }

    public void setFromCardNum(String fromCardNum) {
        this.fromCardNum = fromCardNum;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromBank() {
        return fromBank;
    }

    public void setFromBank(String fromBank) {
        this.fromBank = fromBank;
    }

    public String getToCardNum() {
        return toCardNum;
    }

    public void setToCardNum(String toCardNum) {
        this.toCardNum = toCardNum;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToBank() {
        return toBank;
    }

    public void setToBank(String toBank) {
        this.toBank = toBank;
    }

}
