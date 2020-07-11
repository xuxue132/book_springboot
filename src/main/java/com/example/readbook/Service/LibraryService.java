package com.example.readbook.Service;

import com.example.readbook.Dao.LibraryMapper;
import com.example.readbook.Model.Library;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LibraryService implements LibraryServiceinterface{
    @Resource
    LibraryMapper libraryMapper;
    @Override
    public List<Library> Allbook() {
        return libraryMapper.All();
    }


    @Override
    public List<Library> selectbookpage(int i) {
        return libraryMapper.page(i);
    }

    @Override
    public Library selectbook(int i) {
        return libraryMapper.selectByPrimaryKey(i);
    }

    @Override
    public List<Library> fibo(String name) {
        return libraryMapper.selectByname(name);
    }

}
