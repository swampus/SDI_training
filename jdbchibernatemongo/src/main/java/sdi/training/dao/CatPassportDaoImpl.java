package sdi.training.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import sdi.training.config.MySQLConfigurationHibernateConfiguration;
import sdi.training.model.CatPassport;
import sdi.training.model.CatPassportHibernate;

import java.io.Serializable;
import java.util.List;

public class CatPassportDaoImpl<T, Id extends Serializable>
        implements CatPassportDao<CatPassportHibernate, Id> {
    private Session currentSession;

    private Transaction currentTransaction;

    public CatPassportDaoImpl() {
        currentSession
                = new MySQLConfigurationHibernateConfiguration()
                .createSessionFactory().getCurrentSession();
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        return
                new MySQLConfigurationHibernateConfiguration()
                        .createSessionFactory();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(CatPassportHibernate entity) {
        getCurrentSession().save(entity);
    }

    public List<CatPassportHibernate> findAll() {
        Session session = getCurrentSession();
        session.beginTransaction();
        List<CatPassportHibernate> books = (List<CatPassportHibernate>)
                getCurrentSession().createQuery("from CatPassportHibernate")
                        .list();
        return books;
    }

}
