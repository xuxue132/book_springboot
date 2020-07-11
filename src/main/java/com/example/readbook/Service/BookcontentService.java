package com.example.readbook.Service;

import com.example.readbook.Dao.BookcontentMapper;
import com.example.readbook.Model.Bookcontent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookcontentService implements Bookcontentinterface{
    @Resource
    BookcontentMapper bookcontentMapper;
    @Override
    public List<Bookcontent> catalogebook(int id) {
        return bookcontentMapper.selectcataoge(id);
    }

    @Override
    public Bookcontent contentbook(int id, int bookid) {
        return bookcontentMapper.selectcontent(id,bookid);
    }

    @Override
    public List<Bookcontent> findfinst(int idbook) {
        return bookcontentMapper.selectcataoge(idbook);
    }
}
