package com.ringnull.hibernate;

import javax.persistence.*;
import java.lang.*;

@Entity // объект класс является сущностью, могу гонять её между БД и приложением
@Table(name = "items") // храним в таблице с именем items
public class Item {

    @Id // является первичным ключем
    @GeneratedValue(strategy = GenerationType.IDENTITY) // он должен генерироваться БД, в скобках - стратегия генерации
    @Column(name = "id") // указываю, что id должен жить в столбце id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // когда работа идет с сущностями должен быть конструктор по умолчанию (пустой), потому что
    // он будет вызван не помню чем, то ли JPA, толи чем то еще и будет ошибка

    // первый конструктор
    public Item() {}

    // мне нужен еще конструктор, для заполнения при инициализации объекта
    public Item(String title, int price) {
        this.title = title;
        this.price = price;
    }

    // переопределю toString для удобства
    @Override
    public String toString(){
        return String.format("Item [id = %d, title = '%s', price = '%d']", this.id, this.title, this.price);
    }


}
