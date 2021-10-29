package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    ProductRepository repository;

    public ProductManager() {
        repository = new ProductRepository();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) { // в переменную product по очереди засунь все, что есть в items
            if (matches(product, text)) {  // если текст есть в product
                Product[] tmp = new Product[result.length + 1]; // создали массив tmp на 1 больше, чем массив result
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp:
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;      //в ппоследний элемент массива tmp положили  product, если совпал результат.
                result = tmp;                       // результат - массив всех продуктов, у кого совпал с text имя или автор
            }
        }
        return result;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public boolean matches(Product product, String search) {  // принимает на вход продукт конкретный? и search - строку Что ищем?
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {                    // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product;      // положем его в переменную типа Smartphone чтобы пользоваться методами класса Smartphone
            if (smartphone.getManufacturer().contains(search)) {   // проверим есть ли поисковое слово в данных о производителе
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
        }
        return false;


    }


}
