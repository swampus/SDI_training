package sdi.training.service;

import org.bson.Document;
import sdi.training.dao.CatPassportDao;
import sdi.training.dao.CatPassportDaoImpl;
import sdi.training.dto.CatPassportContent;
import sdi.training.model.CatPassportHibernate;
import sdi.training.resource.MongoDBResource;
import sdi.training.resource.MySQLResource;
import sdi.training.model.CatPassport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sdi.training.sql.CatPassportSQL.GET_ALL_CAT_PASSPORTS_SQL;

public class CatPassportService {
    private MySQLResource mySQLResource;
    private MongoDBResource mongoDBResource;

    public CatPassportService() {
        this.mySQLResource = new MySQLResource();
        this.mongoDBResource = new MongoDBResource();
    }

    public List<CatPassport> getAllCatPassports() {
        Optional<ResultSet> resultSetOpt
                = mySQLResource.getResultSet(GET_ALL_CAT_PASSPORTS_SQL);

        List<CatPassport> catPassports = new ArrayList<>();
        if (resultSetOpt.isPresent()) {
            try {
                ResultSet resultSet = resultSetOpt.get();
                while (resultSet.next()) {
                    long id = resultSet.getLong("passport_id");
                    String content = resultSet.getString("passport_content");
                    catPassports.add(new CatPassport(id, content));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return catPassports;
    }

    /**
     * To show how not to do!
     * Ask about SQL Injection
     */
    public void addCatPassportBAD(CatPassport catPassport) {
        String addCatSql = "INSERT into cat_passport " +
                "(passport_id, passport_content)" +
                "VALUES ("+catPassport.getId()+" , '"+catPassport.getContent()+"')";
    }

    public void addCatPassport(CatPassport catPassport) {
        mySQLResource.addCatPassport(catPassport);
    }

    public void getCatPassportMongo(String passportId){
        Optional<Document> document
                = mongoDBResource.getCatPassportByPassportId(passportId);
        document.ifPresent(doc -> {
            System.out.println(document);
        });
    }

    public void addCatPassportContent(CatPassportContent catPassportContent){
        mongoDBResource.addCatPassportContent(catPassportContent);
    }


    public void deleteCatPassport(Long id) {

    }

    public List<CatPassportHibernate> getAllHIBERNATE_JPGL(){
        return mySQLResource.findAllStudentsWithJpql();
    }

    public List<CatPassportHibernate> getAllHIBERNATE_CRITERIA(){
        return mySQLResource.findAllStudentsWithCriteriaQuery();
    }

    public List<CatPassportHibernate> getAllHIBERNATE_DAO(){
        return new CatPassportDaoImpl().findAll();
    }

}
