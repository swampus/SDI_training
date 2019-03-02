package sdi.training.resource;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import sdi.training.dto.CatPassportContent;

import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBResource {

    public static final String DATABASE_NAME = "sda";

    private MongoCollection<Document> getMongoCollection() {
        MongoClient mongoClient = new MongoClient("localhost");
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        return database.getCollection("cats");
    }

    public void addCatPassportContent(CatPassportContent catPassportContent) {
        Document doc = new Document(catPassportContent.getName(),
                catPassportContent.getName())
                .append("passport_id", catPassportContent.getPassportId())
                .append("age", catPassportContent.getAge())
                .append("vaccine", catPassportContent.getVaccine())
                .append("image", catPassportContent.getImage());

        MongoCollection<Document> mongoCollection = getMongoCollection();
        mongoCollection.insertOne(doc);
    }

    public Optional<Document> getCatPassportByPassportId(String passportId) {
        FindIterable<Document> doc = getMongoCollection()
                .find(eq("passport_id", passportId));
        return Optional.ofNullable(doc.first());
    }
}
