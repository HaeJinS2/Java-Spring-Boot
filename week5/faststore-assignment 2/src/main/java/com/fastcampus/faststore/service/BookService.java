package com.fastcampus.faststore.service;

import com.fastcampus.faststore.entity.Book;
import com.fastcampus.faststore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public Book getOrThrow(String title) {
        return bookRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("해당 제목의 책이 존재하지 않습니다."));
    }

    // TODO: 동일한 책의 제목이 존재하면 RunTimeException을 발생시키고, 그렇지 않으면 책을 저장하도록 구현하세요. 제목으로 책을 조회해오는 쿼리는 이미 BookRepository에 등록되어있습니다.
    @Transactional
    public void registerBook(String title, String author, Long price) {

        // bookrepository에 저장되어 있는 title과 등록할 title을 비교
        if(bookRepository.findByTitle(title).equals(title)){
            //RuntimeException
            throw new RuntimeException("동일한 책의 제목 존재"); // comment: throw를 붙여주어야 예외가 발생합니다.
        }
        else{
            Book book = new Book(title, author, price);
            bookRepository.save(book);
        }
    }

//        if(bookRepository.findByTitle(title).isPresent()) {
//            new RuntimeException ("동일한 책의 제목이 존재");
//        } else {
//            Book book = new Book(title, author, price);
//            bookRepository.save(book);
//        }

//           return bookRepository.findByTitle(title)
//            .orElseThrow(()-> new RuntimeException("동일한 제목의 책이 존재합니다."));
//

//            Optional<Book> optional = bookRepository.findByTitle(title);
//           return optional.map(book -> {
//                book.setTitle(book.getTitle())
//                        .setAuthor(book.getAuthor())
//                        .setPrice(book.getPrice());
//                return book;
//            })
//                   .orElseThrow(() -

    }


