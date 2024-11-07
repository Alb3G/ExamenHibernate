package com.examen;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Alberto Guzman Moreno
 * Singleton de la conexión a la base de datos mediante Hibernate.
 */
public class HibSession {
    @Getter
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure()
                .setProperty("hibernate.connection.username", System.getenv("HIBERNATE_USER"))
                .setProperty("hibernate.connection.password", System.getenv("HIBERNATE_PASSWORD"))
                .buildSessionFactory();
    }
}
