package com.example.readbook.Dao;

import com.example.readbook.Model.Bookcontent;
import com.example.readbook.Model.BookcontentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookcontentMapper {
    long countByExample(BookcontentExample example);

    int deleteByExample(BookcontentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bookcontent record);

    int insertSelective(Bookcontent record);

    List<Bookcontent> selectByExample(BookcontentExample example);

    Bookcontent selectByPrimaryKey(Integer id);

    List<Bookcontent> selectcataoge(Integer id);

    Bookcontent selectcontent(Integer id,Integer bookid);

    int updateByExampleSelective(@Param("record") Bookcontent record, @Param("example") BookcontentExample example);

    int updateByExample(@Param("record") Bookcontent record, @Param("example") BookcontentExample example);

    int updateByPrimaryKeySelective(Bookcontent record);

    int updateByPrimaryKey(Bookcontent record);
}