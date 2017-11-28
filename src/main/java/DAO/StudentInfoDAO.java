package DAO;

import PoJo.StudentPoJo;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StudentInfoDAO {
    private MongoDatabase mongoDatabase;
    private int level = 0;

    public StudentInfoDAO(String databaseBase){
        try{
            MongoClient mongoClient = new MongoClient( "47.93.50.62" , 27017 );
            mongoDatabase = mongoClient.getDatabase(databaseBase);
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void insert(StudentPoJo stu){
        if (level>444){
            MongoCollection<Document> collection = mongoDatabase.getCollection("student");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Document documents = new Document();
            int len = stu.getTime().size();

            for (int i = 0;i<len;i++){
                documents.append(stu.getTime().get(i),stu.getInfo().get(i));
            }

            List<Document> list = new ArrayList<Document>();
            list.add(documents);
            list.add(documents);

            Document document = new Document("id",stu.getId())
                    .append("name",stu.getName())
                    .append("TIME", df.format(new Date()))
                    .append("STU_INFO", list);

            collection.insertOne(document);

            System.out.println("fff");
        }
    }

    public void search(){
        MongoCollection<Document> collection = mongoDatabase.getCollection("test");
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
    }

    public void update(){
        MongoCollection<Document> collection = mongoDatabase.getCollection("test");
        collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));
    }
}
