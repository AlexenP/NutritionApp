package main.Repository;

import main.Hibernate.HibernateUtils;
import main.Model.Menu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MenuRepository implements RepositoryInterface<Menu> {
    @Override
    public List<Menu> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findAll()");

        Query findAllQuery = session.createQuery("FROM Menu");
        List<Menu> menuList = findAllQuery.list();

        session.close();

        System.out.println("Number of menu: " + menuList.size());
        return menuList;
    }

    @Override
    public Menu findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findById()");

        Menu menu = session.find(Menu.class, id);

        session.close();

        System.out.println("Return " + menu);
        return menu;
    }

    @Override
    public void create(Menu menu) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for add()");

        Transaction transaction = session.beginTransaction();

        // actual save into DB
        session.save(menu);

        // end transaction
        transaction.commit();

        session.close();
    }

    @Override
    public void update(Menu menu) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for update()");

        if (objectExists(menu)) {
            Transaction transaction = session.beginTransaction();

            // actual save into DB
            session.update(menu);

            // end transaction
            transaction.commit();

            session.close();
        } else {
            System.out.println("Menu was not found:" + menu);
        }
    }

    @Override
    public void delete(Menu menu) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for delete()");

        if (objectExists(menu)) {
            Transaction transaction = session.beginTransaction();

            // actual save into DB
            session.delete(menu);

            // end transaction
            transaction.commit();

            session.close();
        } else {
            System.out.println("Menu was not found:" + menu);
        }
    }

    @Override
    public Boolean objectExists(Menu menu) {
        return findById(menu.getMenuId()) != null;
    }


    public List<Menu> findBreakfastAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findBreakfastAll()");

        Query findAllQuery = session.createQuery("FROM Menu M Where M.meal = 1");
        List menuList = findAllQuery.list();

        session.close();

        System.out.println("Number of menu: " + menuList.size());
        return menuList;
    }

    public List<Menu> findLunchAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findLunchAll()");

        Query findAllQuery = session.createQuery("FROM Menu M Where M.meal = 2");
        List<Menu> menuList = findAllQuery.list();

        session.close();

        System.out.println("Number of menu: " + menuList.size());
        return menuList;
    }

    public List<Menu> findDinnerAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findDinnerAll()");

        Query findAllQuery = session.createQuery("FROM Menu M Where M.meal = 3");
        List menuList = findAllQuery.list();

        session.close();

        System.out.println("Number of menu: " + menuList.size());
        return menuList;
    }
}
