package czbank.jiangjian.mapper;


import czbank.jiangjian.entity.Account;
import czbank.jiangjian.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AccountMapper {


    Account getAccountInf(String cardNum);


    Integer increaseMoney(@Param("delta") Integer delta,
                          @Param("cardNum") String cardNum,
                          @Param("name") String name);


//    @Update("update account set money = money - #{delta}" +
//            " where card_num = #{cardNum} and name = #{name}")
    Integer decreaseMoney(@Param("delta") Integer delta,
                          @Param("cardNum") String cardNum,
                          @Param("name") String name);


    Integer getMoney(@Param("idCard") String idCard,
                     @Param("cardNum") String cardNum);


    List<String> queryCards(String idCard);

}
