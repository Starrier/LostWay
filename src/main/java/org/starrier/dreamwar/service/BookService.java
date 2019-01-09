package org.starrier.dreamwar.service;


import org.starrier.dreamwar.entity.Book;
import org.starrier.dreamwar.entity.BookWithBookStore;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiaoyue Xiao
 */
public interface BookService {

    Optional<Book> getBookById(Long id);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByPage(Integer page, Integer perPage);

    List<String> getAllBookNames();

    Optional<BookWithBookStore> getBookWithBookStoreById(Long id);

    Integer getTotalPage(Integer perPage);

    boolean saveBook(Book book);

    boolean modifyBookOnNameById(Book book);

    boolean deleteBookById(Long id);

}
