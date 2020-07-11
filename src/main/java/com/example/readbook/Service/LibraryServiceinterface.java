package com.example.readbook.Service;

import com.example.readbook.Model.Library;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LibraryServiceinterface {
    List<Library> Allbook();

    List<Library> selectbookpage(int i);

    Library selectbook(int i);

    List<Library> fibo(String name);
}
