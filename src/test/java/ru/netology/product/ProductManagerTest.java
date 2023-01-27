package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Smartphone smartphone1 = new Smartphone(1, "Iphone 13 Pro", 85000, "Apple");
    Smartphone smartphone2 = new Smartphone(2, "Mi 8 Pro", 25000, "Xiaomi");
    Smartphone smartphone3 = new Smartphone(3, "P40 Pro", 50000, "Huawei");
    Book book4 = new Book(4, "the Master and Margarita", 1000, "Mikhail Bulgakov");
    Book book5 = new Book(5, "Lord of the Rings", 5000, "John Tolkien");
    Book book6 = new Book(6, "Idiot", 3000, "Fyodor Dostoevsky");
    Book book7 = new Book(7, "A dog's heart", 3500, "Mikhail Bulgakov");

    @BeforeEach
    public void setup() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
        manager.add(book7);
    }

    @Test

    public void findABookOfProducts() {

        Product[] expected = {book5};
        Product[] actual = manager.searchBy("Rings");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void findSomeBooksFromTheProducts() {

        Product[] expected = {book4, book5};
        Product[] actual = manager.searchBy("the");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void findASmartphoneOfProducts() {

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Iphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void findsNothingWhenEnteringIncorrectValues() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("love");

        Assertions.assertArrayEquals(expected, actual);
    }

}






