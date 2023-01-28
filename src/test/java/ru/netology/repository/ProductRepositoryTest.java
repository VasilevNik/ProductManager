package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.*;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();


    Smartphone smartphone1 = new Smartphone(1, "Iphone 13 Pro", 85000, "Apple");
    Smartphone smartphone2 = new Smartphone(2, "Mi 8 Pro", 25000, "Xiaomi");
    Smartphone smartphone3 = new Smartphone(3, "P40 Pro", 50000, "Huawei");
    Book book4 = new Book(4, "the Master and Margarita", 1000, "Mikhail Bulgakov");
    Book book5 = new Book(5, "Lord of the Rings", 5000, "John Tolkien");
    Book book6 = new Book(6, "Idiot", 3000, "Fyodor Dostoevsky");
    Book book7 = new Book(7, "A dog's heart", 3500, "Mikhail Bulgakov");


    @BeforeEach
    public void setup() {
        repository.saveProduct(smartphone1);
        repository.saveProduct(smartphone2);
        repository.saveProduct(smartphone3);
        repository.saveProduct(book4);
        repository.saveProduct(book5);
        repository.saveProduct(book6);
        repository.saveProduct(book7);

    }

    @Test
    public void getAllSavedProducts() {

        Product[] expected = {smartphone1, smartphone2, smartphone3, book4, book5, book6, book7};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeProductById() {

        repository.removeById(book5.getId());

        Product[] expected = {smartphone1, smartphone2, smartphone3, book4, book6, book7};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeProductByIncorrectId() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(9);
        });
    }

    @Test
    void shouldAddProduct() {
        Book book8 = new Book(8, "Mumu", 2000, "Ivan Turgenev");
        repository.saveProduct(book8);

        Product[] expected = {smartphone1, smartphone2, smartphone3, book4, book5, book6, book7, book8};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProductWithIdThatIsAlreadyInTheRepository() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.saveProduct(smartphone3);
        });
    }
}
