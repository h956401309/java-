package com.chao.service;

import com.chao.entity.Books;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BooksService {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    int queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();
}
