package com.example.readbook.Controller.land;

import com.example.readbook.Controller.token.TokenUtil;
import com.example.readbook.Model.TblUser;
import com.example.readbook.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/land")
public class land {
    @Resource
    UserService userService;
//    @Resource
//    LibraryService libraryService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody TblUser user) throws JsonProcessingException {
        TblUser book = userService.landSystem(user.getName(),user.getPassword());
        if(book!=null){
            String token = TokenUtil.sign(book);
            System.out.println(token);
            HashMap<String,Object> hs = new HashMap<>();
            if(TokenUtil.verify(token)){
                hs.put("code",200);
            }else {
                hs.put("coe",500);
            }
            hs.put("token",token);
//            hs.put("username",)
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(hs);
        }
        return "密码错误";
    }

    @RequestMapping(value = "/login/{name}/{password}",method = RequestMethod.POST)
    public String login(@PathVariable("name") String name,@PathVariable("password") String password) throws JsonProcessingException {
        TblUser book = userService.landSystem(name,password);
        if(book!=null){
            String token = TokenUtil.sign(book);
            System.out.println(token);
            HashMap<String,Object> hs = new HashMap<>();
            if(TokenUtil.verify(token)){
                hs.put("code",200);
            }else {
                hs.put("code",500);
            }
            hs.put("token",token);
//            hs.put("username",)
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(hs);
        }
        return "密码错误";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String addUser1(@RequestBody TblUser user){
        TblUser book = userService.addUser(user.getName());
        if(book!=null)
            return "用户已存在";
        else {
            book=new TblUser();
            book.setName(user.getName());
            book.setPassword(user.getPassword());
            book.setRole("ROLE_user");
            int as=userService.insertUser(book);
            return "创建成功";
        }
    }


}
