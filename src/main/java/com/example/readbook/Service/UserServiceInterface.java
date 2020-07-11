package com.example.readbook.Service;

import com.example.readbook.Model.TblUser;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInterface {

    TblUser landSystem(String name, String password);
    TblUser addUser(String name);
    int insertUser(TblUser tblUser);
}
