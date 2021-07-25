package czbank.jiangjian.controller;


import czbank.jiangjian.entity.User;
import czbank.jiangjian.service.UserService;
import czbank.jiangjian.util.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/loginByIdCard")
    public ResultBean<User> loginByIdCard(String idCard,String password
                                            , HttpSession session) {
        ResultBean<User> res = userService.loginByIdCard(idCard, password);
        if(res.getCode() == 0){
            session.setAttribute("user", res.getData());
        }
        return res;
    }

    @RequestMapping("/loginByTelephone")
    public ResultBean<User> loginByTelephone(String telephone) {
        return  userService.loginByTelephone(telephone);
    }


}
