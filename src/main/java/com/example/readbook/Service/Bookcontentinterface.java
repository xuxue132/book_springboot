package com.example.readbook.Service;

import com.example.readbook.Model.Bookcontent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Bookcontentinterface {
    List<Bookcontent> catalogebook(int id);

    Bookcontent contentbook(int id,int bookid);

    List<Bookcontent> findfinst(int idbook);
}
