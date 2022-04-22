package com.chao.repository;

import com.chao.entity.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksMapper {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    int queryBookById(@Param("bookID") int id);

    //查询全部的书
    List<Books> queryAllBook();

}
