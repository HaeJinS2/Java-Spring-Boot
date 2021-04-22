package com.fastcampus.faststore.service;

import com.fastcampus.faststore.entity.Book;
import com.fastcampus.faststore.entity.BookSale;
import com.fastcampus.faststore.entity.DiscountPolicy;
import com.fastcampus.faststore.repository.BookRepository;
import com.fastcampus.faststore.repository.BookSaleRepository;
import com.fastcampus.faststore.repository.DiscountPolicyRepository;
import com.fastcampus.faststore.type.DiscountType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookSaleServiceTest {
    @Autowired
    private BookSaleRepository bookSaleRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DiscountPolicyRepository discountPolicyRepository;

    private BookSaleService bookSaleService;

    @BeforeEach
    public void setup() {
        BookService bookService = new BookService(bookRepository);
        DiscountPolicyService discountPolicyService = new DiscountPolicyService(discountPolicyRepository);
        bookSaleService = new BookSaleService(bookService, discountPolicyService, bookSaleRepository);
    }

    @AfterEach
    public void tearDown() {
        bookSaleRepository.deleteAll();
        bookRepository.deleteAll();
        discountPolicyRepository.deleteAll();
    }

    @Test
    @Transactional
    public void getOrThrow() {
        Book book = new Book("자바의 정석", "남궁성", 30000L);
        DiscountPolicy discountPolicy = new DiscountPolicy(DiscountType.PERCENT, 10L);
        bookRepository.save(book);
        discountPolicyRepository.save(discountPolicy);
        bookSaleRepository.save(new BookSale(book, discountPolicy));

        BookSale result = bookSaleService.getOrThrow(book);

        assertThat(result).isNotNull();
        assertThat(result.getBook().getTitle()).isEqualTo(book.getTitle());
        assertThat(result.getBook().getAuthor()).isEqualTo(book.getAuthor());
        assertThat(result.getBook().getPrice()).isEqualTo(book.getPrice());
        assertThat(result.getDiscountPolicy().getDiscountType()).isEqualTo(discountPolicy.getDiscountType());
        assertThat(result.getDiscountPolicy().getAmount()).isEqualTo(discountPolicy.getAmount());
    }

    // TODO: registerBookSale의 테스트 코드를 작성하세요.
    // comment: java.lang.RuntimeException: 해당 제목의 책이 존재하지 않습니다. 예외가 발생하고 있습니다.
    // registerBookSale을 테스트 하기 위해서는 먼저 book이 하나 들어가 있어야 합니다.
    // 그 준비 부분도 테스트 코드에 추가시켜줘야 정상적으로 동작합니다.
    @Test
    @Transactional
    public void registerBookSale() {
        Book book = new Book("자바의 정석", "남궁성", 30000L);
        bookRepository.save(book);

        bookSaleService.registerBookSale("자바의 정석", DiscountType.valueOf("PERCENT"), 3000L);
        assertThat(bookSaleRepository.findById(1L)).isNotNull();
    }

}
