package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book();
  private Book someBook = new Book();
  private Smartphone iPhone10 = new Smartphone() ;
  private Smartphone samsung = new Smartphone() ;

  @Test
  public void shouldSaveOneItem() {
    repository.save(coreJava);

    Product[] expected = new Product[]{coreJava};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldSaveAllItems() {
    repository.save(coreJava);
    repository.save(someBook);
    repository.save(iPhone10);
    repository.save(samsung);

    Product[] expected = new Product[]{coreJava, someBook, iPhone10, samsung};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  
}
