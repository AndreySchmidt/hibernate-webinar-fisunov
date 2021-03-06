package com.ringnull.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // создаю подключение к БД (сюда Configuration() при автоимпорте приходят настройки из hibernate.properties
        // для этого автоимпорт надо подключить, у меня видимо само подключилось)
        // следи за импортами org.hibernate.cfg.Configuration

        // sessionFactory работает с сеансами работы с БД
        SessionFactory sessionFactory = new Configuration()
                // org.hibernate.MappingException для того, чтобы обьяснить hibernate необходимость работы с сущностью, добавим ее в конфигурации .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetails.class)// в спринг авто сканирование будет, без него вручную добавляю используемые сущности
                .buildSessionFactory();

        Session session = null;

        // Create item
        // запрашиваем отдельную сессию (все мои операции будут выполняться в рамках отдельной сессии)
//        session = sessionFactory.getCurrentSession();
//
//        // любую операцию с БД буду выполнять в рамках транзакции
//        session.beginTransaction();
//
//        // создаю объект Item
//        Item item = new Item("Milk", 80);
//        System.out.println(item);
//
//        // записать item в БД
//        session.save(item);
//        System.out.println(item);
//        session.getTransaction().commit();

        // Read
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        // (Item.class, 1L) -- беру объект Item класса, с id = 1 (так как там Long, то L)
//        Item itemDB = session.get(Item.class, 1L);
//        System.out.println(itemDB);
//        session.getTransaction().commit();

        // Read 2 вариант
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        // Item можно делать запрос на языке HQL (это не опечатка) Item - имя класса, а не таблицы
//        Item itemDB = session.createQuery("SELECT i FROM Item i WHERE i.id = :id", Item.class)
//                .setParameter("id", 3L)
//                .getSingleResult();
//        System.out.println(itemDB);

        // list
//        List<Item> itemList = session.createQuery("SELECT i FROM Item i", Item.class).getResultList();
//        System.out.println(itemList);
//        session.getTransaction().commit();

        // Update
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//
//        Item itemDB = session.get(Item.class, 3L);// второй параметр id в БД
//
//        System.out.println(itemDB);
//        // изменяю объект в java, в БД его автоматически поменяет hibernate как только session.getTransaction().commit(); или session.flush(); (но commit все равно нужен потом)
//        itemDB.setPrice(200); // причем он меняет только если реально разные данные, если нет, то запроса на апдейт не будет
//        itemDB.setTitle("Bread");
//
//        session.getTransaction().commit();


        // Delete
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
////
//        Item itemDB = session.get(Item.class, 1L);
//        session.remove(itemDB);
//        session.getTransaction().commit();


        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        User user = session.get(User.class, 1L);
        System.out.println(user);
        System.out.println(user.getDetails());
        session.getTransaction().commit();

        sessionFactory.close();
    }
}
