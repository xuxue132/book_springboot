package com.example.readbook.Dao;

import com.example.readbook.Model.Library;
import com.example.readbook.Model.LibraryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LibraryMapper {
    long countByExample(LibraryExample example);

    int deleteByExample(LibraryExample example);

    int deleteByPrimaryKey(Integer idBook);

    int insert(Library record);

    int insertSelective(Library record);

    List<Library> selectByExample(LibraryExample example);

    Library selectByPrimaryKey(Integer idBook);

    List<Library> selectByname(String name);

    List<Library> All();

    List<Library> page(int i);


    int updateByExampleSelective(@Param("record") Library record, @Param("example") LibraryExample example);

    int updateByExample(@Param("record") Library record, @Param("example") LibraryExample example);

    int updateByPrimaryKeySelective(Library record);

    int updateByPrimaryKey(Library record);
}