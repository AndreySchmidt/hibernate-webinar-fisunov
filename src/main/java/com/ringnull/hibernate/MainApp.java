package com.ringnull.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        // создаю подключение к БД (сюда Configuration() при автоимпорте приходят настройки из hibernate.properties
        // для этого автоимпорт надо подключить, у меня видимо само подключилось)
        // следи за импортами org.hibernate.cfg.Configuration

        SessionFactory sessionFactory = new Configuration().buildSessionFactory();



        sessionFactory.close();

    }
}
