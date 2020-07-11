package com.example.readbook.Controller.books;


import com.example.readbook.Model.Bookcontent;
import com.example.readbook.Model.Library;
import com.example.readbook.Service.BookcontentService;
import com.example.readbook.Service.LibraryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/vip")
public class vipbook {
    @Resource
    LibraryService libraryService;
    @Resource
    BookcontentService bookcontentService;

    @RequestMapping(value = "/book/{id}",method = RequestMethod.GET)
    public Library books(@PathVariable(value = "id") int id){
        Library library = libraryService.selectbook(id);
        return library;

    }

    @RequestMapping(value = "/catalog/{id}",method = RequestMethod.GET)
    public List<Bookcontent> bookscatalog(@PathVariable(value = "id") int id){
        List<Bookcontent> bookcontents = bookcontentService.catalogebook(id);
        return bookcontents;
    }

    @RequestMapping(value = "/content/{id}/{bookid}",method = RequestMethod.GET)
    public Bookcontent bookscatalog(@PathVariable(value = "id") int id,@PathVariable(value = "bookid") int bookid){
        Bookcontent contents = bookcontentService.contentbook(id,bookid);
        return contents;
    }

}
