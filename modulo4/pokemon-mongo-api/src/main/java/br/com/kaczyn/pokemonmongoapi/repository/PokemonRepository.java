package br.com.kaczyn.pokemonmongoapi.repository;

import br.com.kaczyn.pokemonmongoapi.database.MongoDBConnection;
import br.com.kaczyn.pokemonmongoapi.exceptions.BusinessRuleException;
import br.com.kaczyn.pokemonmongoapi.model.Pokemon;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.*;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.*;
import static org.springframework.boot.autoconfigure.condition.ConditionOutcome.match;

@Repository
public class PokemonRepository {

    private final MongoDBConnection conn = new MongoDBConnection();
    private MongoCollection<Document> collection;

    public Pokemon insert(Pokemon pokemon) throws BusinessRuleException {
        try {
            this.connect();

            Document newPokemon = new Document("name", pokemon.getName())
                    .append("number", pokemon.getNumber())
                    .append("level", pokemon.getLevel())
                    .append("types", pokemon.getTypes())
                    .append("race", pokemon.getRace());

            InsertOneResult created = this.collection.insertOne(newPokemon);

            String id = created.getInsertedId().toString();
            id = id.replace("BsonObjectId{value=", "").replace("}", "");

            pokemon.setId(id);

            this.close();

            return pokemon;
        } catch (Exception e) {
            throw new BusinessRuleException(e.getMessage());
        }
    }

    public Optional<Pokemon> findById(String id) throws BusinessRuleException {
        try {
            this.connect();

            Document searched = this.collection.find(new Document("_id", new ObjectId(id))).first();

            Pokemon pokemon = this.documentToPokemon(searched);

            this.close();

            return Optional.of(pokemon);
        } catch (Exception e) {
            throw new BusinessRuleException("Pokemon not found.");
        }
    }

    public List<Pokemon> findAll() throws Exception {
        List<Pokemon> list = new ArrayList<>();
        try {
            this.connect();

            FindIterable<Document> findIterable = this.collection.find();
            MongoCursor<Document> cursor = findIterable.iterator();

            while (cursor.hasNext()) {
                final Document document = cursor.next();
                list.add(this.documentToPokemon(document));
            }

            this.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Pokemon> findByType(String string) throws Exception {
        List<Pokemon> list = new ArrayList<>();
        try {
            this.connect();

            FindIterable<Document> findIterable = this.collection.find(new Document("types", string));
            MongoCursor<Document> cursor = findIterable.iterator();
            while (cursor.hasNext()) {
                final Document document = cursor.next();
                list.add(this.documentToPokemon(document));
            }

            this.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Pokemon updateById(String id, Pokemon pokemon) throws Exception {
        try {
            this.connect();

            Document query = new Document("_id", new ObjectId(id));

            Bson updates = Updates.combine(
                    Updates.set("number", pokemon.getNumber()),
                    Updates.set("race", pokemon.getRace()),
                    Updates.set("level", pokemon.getLevel()),
                    Updates.set("name", pokemon.getName()),
                    Updates.set("types", pokemon.getTypes())
            );

            UpdateOptions options = new UpdateOptions().upsert(true);

            UpdateResult searched = this.collection.updateOne(query, updates, options);

            this.close();

            pokemon.setId(id);
            return pokemon;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteById(String id) throws Exception {
        try {
            this.connect();

            Document query = new Document("_id", new ObjectId(id));

            this.collection.deleteOne(query);

            this.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Integer typesQuantity(String string) throws Exception {
        try {
            this.connect();

            AggregateIterable<Document> agg = this.collection.aggregate(
                    Arrays.asList(
                            match(Filters.eq("types", string)),
                            group("$types", Accumulators.sum("quantity", 1))
                    )
            );

            Integer number = 0;

            MongoCursor<Document> cursor = agg.iterator();
            while (cursor.hasNext()) {
                final Document document = cursor.next();
                number += Integer.parseInt(document.get("quantity").toString());
            }

            this.close();
            return number;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Pokemon documentToPokemon(Document document) {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(document.get("_id").toString());
        pokemon.setNumber(document.get("number").toString());
        pokemon.setRace(document.get("race").toString());
        pokemon.setLevel(Integer.parseInt(document.get("level").toString()));
        pokemon.setName(document.get("name").toString());

        List<String> types = (List<String>) document.get("types");

        pokemon.setTypes(types);
        return pokemon;
    }

    private void connect() {
        collection = conn.connection().getCollection("pokemon");
    }

    private void close() {
        conn.close();
    }
}
