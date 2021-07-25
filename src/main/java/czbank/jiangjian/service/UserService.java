package czbank.jiangjian.service;


import czbank.jiangjian.entity.User;
import czbank.jiangjian.mapper.UserMapper;
import czbank.jiangjian.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public ResultBean<User>  loginByIdCard(String idCard,String password){
        ResultBean<User> res = new ResultBean<>();

        User user = userMapper.loginByIdCard(idCard);
        if(user == null){
            res.setCode(1);
            res.setMsg("身份证号不存在");
            return res;
        }
        String pwd = user.getPassword();
        if( ! pwd.equals(password) ){
            res.setCode(2);
            res.setMsg("密码有误");
            return res;
        }
        String state = user.getState();
        if( ! state.equals("正常") ){
            res.setCode(3);
            res.setMsg("用户状态非正常");
            return res;
        }

        res.setData(user);
        return  res;
    }

    public ResultBean<User> loginByTelephone(String telephone){
        ResultBean<User> res = new ResultBean<>();
        userMapper.loginByTelephone(telephone);
        return  res;
    }



}
