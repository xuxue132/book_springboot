package com.example.readbook.Service;

import com.example.readbook.Dao.TblUserMapper;
import com.example.readbook.Model.TblUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements UserServiceInterface {
    @Resource
    TblUserMapper tblUserMapper;

    @Override
    public TblUser landSystem(String name, String password) {
        return tblUserMapper.selectpeople(name,password);
    }

    @Override
    public TblUser addUser(String name) {
        return tblUserMapper.selectUsername(name);
    }

    @Override
    public int insertUser(TblUser tblUser) {
        return tblUserMapper.insert(tblUser);
    }
}
