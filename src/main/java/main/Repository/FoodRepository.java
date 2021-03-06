package main.Repository;

import main.Hibernate.HibernateUtils;


import main.Model.Food;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FoodRepository implements RepositoryInterface<Food> {

    @Override
    public void create(Food food) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for add()");

        Transaction transaction = session.beginTransaction();

        // actual save into DB
        session.save(food);

        // end transaction
        transaction.commit();

        session.close();
    }

    @Override
    public void update(Food food) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for update()");

        if (objectExists(food)) {
            Transaction transaction = session.beginTransaction();

            // actual save into DB
            session.update(food);

            // end transaction
            transaction.commit();

            session.close();
        } else {
            System.out.println("Food was not found:" + food);
        }
    }

    @Override
    public void delete(Food food) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for delete()");

        if (objectExists(food)) {
            Transaction transaction = session.beginTransaction();

            // actual save into DB
            session.delete(food);

            // end transaction
            transaction.commit();

            session.close();
        } else {
            System.out.println("Food was not found:" + food);
        }
    }

    @Override
    public List<Food> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findAll()");

        Query findAllQuery = session.createQuery("FROM Food");
        List<Food> foodList = findAllQuery.list();

        session.close();

        System.out.println("Number of food: " + foodList.size());
        return foodList;
    }

    @Override
    public Food findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findById()");

        Food food = session.find(Food.class, id);

        session.close();

        System.out.println("Return " + food);
        return food;
    }

    @Override
    public Boolean objectExists(Food food) {
        return findById(food.getFoodId()) != null;
    }

}
