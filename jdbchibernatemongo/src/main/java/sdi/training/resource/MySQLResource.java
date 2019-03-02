package sdi.training.resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sdi.training.config.MySQLConfiguration;
import sdi.training.config.MySQLConfigurationHibernateConfiguration;
import sdi.training.dao.CatPassportDaoImpl;
import sdi.training.model.CatPassport;
import sdi.training.model.CatPassportHibernate;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.List;
import java.util.Optional;

import static sdi.training.sql.CatPassportSQL.INSERT_INTO_CAT_PASSPORT;

public class MySQLResource {

    private MySQLConfiguration mySQLConfiguration;
    private MySQLConfigurationHibernateConfiguration
            mySQLConfigurationHibernateConfiguration;

    public MySQLResource() {
        mySQLConfiguration = new MySQLConfiguration();
        mySQLConfigurationHibernateConfiguration
                = new MySQLConfigurationHibernateConfiguration();
    }

    public Optional<ResultSet> getResultSet(String sql) {


        try {
            Connection connection = createConnection(mySQLConfiguration);
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            return Optional.of(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * FOR BAD EXAMPLE
     */
    public void executeCommand(String sql) {
        MySQLConfiguration mySQLConfiguration = new MySQLConfiguration();
        try {
            Connection connection = createConnection(mySQLConfiguration);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCatPassport(CatPassport catPassport) {
        try (Connection conn = createConnection(mySQLConfiguration);
             PreparedStatement stmt = conn.prepareStatement(INSERT_INTO_CAT_PASSPORT)) {
            stmt.setString(1, catPassport.getContent());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection(MySQLConfiguration mySQLConfiguration)
            throws SQLException {
        return DriverManager.getConnection(
                mySQLConfiguration.getUrl(),
                mySQLConfiguration.getUser(),
                mySQLConfiguration.getPass());
    }

    private List<CatPassport> getAllCatPassportsWithDao() {
        return new CatPassportDaoImpl().findAll();
    }

    public List<CatPassportHibernate> findAllStudentsWithJpql() {
        Session currentSession =
                mySQLConfigurationHibernateConfiguration
                        .createSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        return currentSession
                .createQuery("SELECT a FROM CatPassportHibernate a",
                        CatPassportHibernate.class)
                .getResultList();
    }

    //Try to use not entity
    public List<CatPassportHibernate> findAllStudentsWithCriteriaQuery() {
        Session currentSession
                = mySQLConfigurationHibernateConfiguration
                .createSessionFactory().getCurrentSession();

        currentSession.beginTransaction();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<CatPassportHibernate> cq = cb.createQuery(CatPassportHibernate.class);
        Root<CatPassportHibernate> rootEntry = cq.from(CatPassportHibernate.class);
        CriteriaQuery<CatPassportHibernate> all = cq.select(rootEntry);

        TypedQuery<CatPassportHibernate> allQuery
                = currentSession.createQuery(all);
        return allQuery.getResultList();
    }

}
