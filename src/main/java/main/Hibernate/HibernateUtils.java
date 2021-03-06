package main.Hibernate;


import main.Model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

import static main.Hibernate.DatabaseUtils.*;

public class HibernateUtils {
    // singleton
    // heavy usage
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

            settings.put(Environment.URL, DB_URL);
            settings.put(Environment.USER, DB_USER);
            settings.put(Environment.PASS, DB_PASS);

            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.HBM2DDL_AUTO, "update");

            configuration.setProperties(settings);

            // TODO Add classes for hibernate to know what
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Food.class);
            configuration.addAnnotatedClass(Menu.class);
            configuration.addAnnotatedClass(Nutrition.class);
            configuration.addAnnotatedClass(Plan.class);


            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }
}
