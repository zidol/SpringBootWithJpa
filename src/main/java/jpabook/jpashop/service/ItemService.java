package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity, String author, String isbn) {
        Book findItem = (Book)itemRepository.findOne(itemId); //영속 상태 .@Transactional로 인해 commit 하고 jpa는 flush 함으로 변경감지(더티체킹)으로 update 됨
        findItem.setName(name);
        findItem.setPrice(price);            // setter 보단 findItem.change(param.getPrice(), param.getName())같은 로직으로
        findItem.setStockQuantity(stockQuantity);
        findItem.setAuthor(author);
        findItem.setIsbn(isbn);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
