package czbank.jiangjian.entity;

import java.util.Date;

public class Account {

    //自增主键
    private Integer id;

    //姓名
    private String name;

    //身份证号
    private String idCard;

    //卡号
    private String cardNum;

    //金额
    private Integer money;

    //开户行
    private  String bankName;

    //账户类型
    private  String accountType;

    //账户状态
    private  String state;

    //支付密码
    private  String payPassword;

    //上次操作时间
    private Date lastOptTime;

    //单笔操作金额上限
    private Integer limit;

    public Account() {

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", money=" + money +
                ", bankName='" + bankName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", state='" + state + '\'' +
                ", payPassword='" + payPassword + '\'' +
                ", lastOptTime=" + lastOptTime +
                ", limit=" + limit +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public Date getLastOptTime() {
        return lastOptTime;
    }

    public void setLastOptTime(Date lastOptTime) {
        this.lastOptTime = lastOptTime;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }


}
