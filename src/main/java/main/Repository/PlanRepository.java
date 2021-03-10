package main.Repository;

import main.Hibernate.HibernateUtils;
import main.Model.Plan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlanRepository implements RepositoryInterface<Plan> {


    @Override
    public Plan findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findById()");

        Plan plan = session.find(Plan.class, id);

        session.close();

        System.out.println("Return " + plan);
        return plan;
    }

    @Override
    public void create(Plan plan) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for add()");

        Transaction transaction = session.beginTransaction();

        // actual save into DB
        session.save(plan);

        // end transaction
        transaction.commit();

        session.close();
    }

    @Override
    public void update(Plan plan) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for update()");

        if (objectExists(plan)) {
            Transaction transaction = session.beginTransaction();

            // actual save into DB
            session.update(plan);

            // end transaction
            transaction.commit();

            session.close();
        } else {
            System.out.println("Plan was not found:" + plan);
        }
    }

    @Override
    public void delete(Plan plan) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for delete()");

        if (objectExists(plan)) {
            Transaction transaction = session.beginTransaction();

            // actual save into DB
            session.delete(plan);

            // end transaction
            transaction.commit();

            session.close();
        } else {
            System.out.println("Plan was not found:" + plan);
        }
    }

    @Override
    public Boolean objectExists(Plan plan) {
        return findById(plan.getPlanId()) != null;
    }

    @Override
    public List<Plan> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findAll()");

        Query findAllQuery = session.createQuery("FROM Plan");
        List<Plan> planList = findAllQuery.list();

        session.close();

        System.out.println("Number of plans: " + planList.size());
        return planList;
    }

    public List<Plan> findLoseWeightPlans(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findAll()");

        Query findAllQuery = session.createQuery("FROM Plan P where P.planType = 1");
        List<Plan> planList = findAllQuery.list();

        session.close();

        System.out.println("Number of plans: " + planList.size());
        return planList;

    }

    public List<Plan> findMaintenanceWeightPlans(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findAll()");

        Query findAllQuery = session.createQuery("FROM Plan P where P.planType = 2");
        List<Plan> planList = findAllQuery.list();

        session.close();

        System.out.println("Number of plans: " + planList.size());
        return planList;
    }

    public List<Plan> findGainWeightPlans(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findAll()");

        Query findAllQuery = session.createQuery("FROM Plan P where P.planType = 3");

        List<Plan> planList = findAllQuery.list();

        session.close();

        System.out.println("Number of plans: " + planList.size());
        return planList;
    }
}
