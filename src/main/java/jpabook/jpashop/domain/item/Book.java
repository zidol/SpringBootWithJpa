package jpabook.jpashop.domain.item;

import jpabook.jpashop.controller.BookForm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item {

    private String author;
    private String isbn;

    //변걍감지(더티체킹) 변경
    public void changeBook(BookForm bookForm) {
        this.setName(bookForm.getName());
        this.setPrice(bookForm.getPrice());
        this.setStockQuantity(bookForm.getStockQuantity());
        this.setAuthor(bookForm.getAuthor());
        this.setIsbn(bookForm.getIsbn());
    }
}
