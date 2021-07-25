package czbank.jiangjian.mapper;


import czbank.jiangjian.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {


     User loginByTelephone(String telephone);

     User loginByIdCard(String idCard);

}
