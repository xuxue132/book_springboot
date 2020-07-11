package com.example.readbook.Controller.books;

import com.example.readbook.Controller.token.TokenUtil;
import com.example.readbook.Model.Bookcontent;
import com.example.readbook.Model.Library;
import com.example.readbook.Service.BookcontentService;
import com.example.readbook.Service.LibraryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/book")
public class books {
    @Resource
    LibraryService libraryService;
    @Resource
    BookcontentService bookcontentService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Library> all(){
        List<Library> books = libraryService.Allbook();
        return books;
    }

    @RequestMapping(value = "/page/{line}",method = RequestMethod.GET)
    public List<Library> selectpage(@PathVariable(value = "line") int line){
        List<Library> booksall = libraryService.selectbookpage(line);
        return booksall;
    }
    @RequestMapping(value = "/type/{line}",method = RequestMethod.GET)
    public String slecttype(@PathVariable(value = "line") int line){
        Library booksall1 = libraryService.selectbook(line);
        return booksall1.getType();
    }

    @RequestMapping(value = "/find/first/{idbook}",method = RequestMethod.GET)
    public int first(@PathVariable(value = "idbook") int idbook){
        List<Bookcontent> bookcontents= bookcontentService.catalogebook(idbook);
        return bookcontents.get(0).getId();
    }
    @RequestMapping(value = "/find/final/{idbook}",method = RequestMethod.GET)
    public int finalq(@PathVariable(value = "idbook") int idbook){
        List<Bookcontent> bookcontents= bookcontentService.catalogebook(idbook);
        return bookcontents.get(bookcontents.size()-1).getId();
    }

    @RequestMapping(value = "/token",method = RequestMethod.GET)
    public String toke(@RequestHeader(value = "Authorization") String token){
        return TokenUtil.getUsername(token);
    }

    @RequestMapping(value = "/token/vi",method = RequestMethod.GET)
    public String toke2(@RequestHeader(value = "Authorization") String token){
        return TokenUtil.getRole(token);
    }

    @RequestMapping(value = "/find/{name}",method = RequestMethod.GET)
    public List<Library> findbook(@PathVariable(value = "name") String name){
//        name= URLDecoder.decode(name,"utf-8");
        String newname = "《"+name+"》";
        return libraryService.fibo(newname);
    }

}


