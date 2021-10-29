package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    @Test
    public void successSearchFromMany() {
        ProductManager manager = new ProductManager();
        Product first = new Book(1, "first", 10, "author1");
        Product second = new Book(2, "second", 10, "author2");
        Product third = new Smartphone(3, "third", 30, "manufacture1");
        manager.add(first);
        manager.add(second);
        manager.add(third);


        Product[] actual = manager.searchBy("fir");
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void successSearchFromOne() {
        ProductManager manager = new ProductManager();
        Product third = new Smartphone(3, "third", 30, "manufacture1");
        manager.add(third);


        Product[] actual = manager.searchBy("ir");
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void failSearchFromNothing() {
        ProductManager manager = new ProductManager();

        Product[] actual = manager.searchBy("fir");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void failSearchFromMany() {
        ProductManager manager = new ProductManager();
        Product first = new Book(1, "first", 10, "author1");
        Product second = new Book(2, "second", 10, "author2");
        Product third = new Smartphone(3, "third", 30, "manufacture1");
        manager.add(first);
        manager.add(second);
        manager.add(third);


        Product[] actual = manager.searchBy("aaa");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void failSearchFromOne() {
        ProductManager manager = new ProductManager();
        Product third = new Smartphone(3, "third", 30, "manufacture1");

        manager.add(third);


        Product[] actual = manager.searchBy("fir");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void successSearchAuthorFindTwo() {
        ProductManager manager = new ProductManager();
        Product first = new Book(1, "first", 10, "author1");
        Product second = new Book(2, "second", 10, "author2");
        Product third = new Smartphone(3, "third", 30, "manufacture1");

        manager.add(first);
        manager.add(second);
        manager.add(third);


        Product[] actual = manager.searchBy("au");
        Product[] expected = new Product[]{first, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void successSearchAManufacture() {
        ProductManager manager = new ProductManager();
        Product first = new Book(1, "first", 10, "author1");
        Product second = new Book(2, "second", 10, "author2");
        Product third = new Smartphone(3, "third", 30, "manufacture1");

        manager.add(first);
        manager.add(second);
        manager.add(third);


        Product[] actual = manager.searchBy("ma");
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

}
