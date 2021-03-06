package main.Repository;

import main.Hibernate.HibernateUtils;
import main.Model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientRepository implements RepositoryInterface<Client> {

    @Override
    public void create(Client client) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for add()");

        Transaction transaction = session.beginTransaction();

        // actual save into DB
        session.save(client);

        // end transaction
        transaction.commit();

        session.close();

    }

    @Override
    public void update(Client client) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for update()");

        if (objectExists(client)) {
            Transaction transaction = session.beginTransaction();

            // actual save into DB
            session.update(client);

            // end transaction
            transaction.commit();

            session.close();
        } else {
            System.out.println("Client was not found:" + client);
        }
    }

    @Override
    public void delete(Client client) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for delete()");

        if (objectExists(client)) {
            Transaction transaction = session.beginTransaction();

            // actual save into DB
            session.delete(client);

            // end transaction
            transaction.commit();

            session.close();
        } else {
            System.out.println("Client was not found:" + client);
        }
    }

    @Override
    public List<Client> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findAll()");

        Query findAllQuery = session.createQuery("FROM Client");
        List<Client> clientsList = findAllQuery.list();

        session.close();

        System.out.println("Number of clients: " + clientsList.size());
        return clientsList;
    }

    @Override
    public Client findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("Hibernate session started for findById()");

        Client client = session.find(Client.class, id);

        session.close();

        System.out.println("Return " + client);
        return client;
    }

    @Override
    public Boolean objectExists(Client client) {
        return findById(client.getClientId()) != null;
    }

}
