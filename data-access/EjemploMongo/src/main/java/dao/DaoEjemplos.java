package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import common.LocalDateTimeTypeAdapter;
import common.LocalDateTypeAdapter;
import common.ObjectIdTypeAdapter;
import io.vavr.control.Either;
import model.EjemploObject;
import model.errors.ErrorObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DaoEjemplos {

    private Gson gson;

    public DaoEjemplos() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdapter())
                .create();
    }

    public Either<ErrorObject, String>ejemplo1(){
        Either<ErrorObject, String>res;
        try(MongoClient mongo = MongoClients.create("mongodb://informatica.iesquevedo.es:2323")){
            MongoDatabase db = mongo.getDatabase("luciasanmiguel_zipcodes");
            MongoCollection<Document> collection = db.getCollection("zipcodes");
            Document document = collection.find().first();
            if (document == null){
                res = Either.left(new ErrorObject("No se ha encontrado un objeto", 1));
            }else {
                EjemploObject ciudad = gson.fromJson(document.toJson(), EjemploObject.class);
                res = Either.right(ciudad.getCity());
            }

        }catch (Exception e) {
            res = Either.left(new ErrorObject(e.getMessage(), 0));
        }

        return res;
    }

}
