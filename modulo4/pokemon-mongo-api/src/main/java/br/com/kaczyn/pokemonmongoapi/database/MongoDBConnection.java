package br.com.kaczyn.pokemonmongoapi.database;

import com.mongodb.MongoClientException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    private static final String URI = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";

    private MongoClient client;
    private MongoDatabase conn;

    public MongoDatabase connection() {
        try {
            client = MongoClients.create(URI);
            conn = client.getDatabase("poke");
        } catch (MongoClientException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void close() {
        this.client.close();
    }
}
