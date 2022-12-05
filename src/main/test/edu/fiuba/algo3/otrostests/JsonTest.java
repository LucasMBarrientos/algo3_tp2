package edu.fiuba.algo3.otrostests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import edu.fiuba.algo3.modelo.Json;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {

    @Test
    public void chequeoQueElJsonSeCreaCorrectamente() throws IOException {
        JsonNode node = Json.parse("{\"title\": aTitle, \"author\": anAuthor}");
        Assertions.assertEquals(node.get("title").asText(), "aTitle");
    }

    @Test
    void prueboSiElJsonSePuedeConvertirCorretamenteEnString() throws IOException {

        JsonNode node = Json.parse("{\"title\": \"aTitle\", \"author\": \"anAuthor\"}");

        System.out.println(Json.stringify(node));
        System.out.println(Json.prettyPrint(node));
    }
    @Test
    void prueboSiLosNodosPuedenFiltrarPorKeys() throws IOException {

        JsonNode node = Json.parse("{\"title\": \"aTitle\", \"author\": \"anAuthor\"}");

        Assertions.assertEquals(node.get("author").asText(), "anAuthor");
    }

    @Test
    void crearJsonConHashMap() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "John Deo");
        map.put("email", "john.doe@example.com");
        map.put("roles", new String[]{"Member", "Admin"});
        map.put("admin", true);

        JsonNode node = Json.toJson(map);

        System.out.println(Json.prettyPrint(node));
    }

    @Test
    void probarAlgo() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "John Deo");
        map.put("email", "john.doe@example.com");
        map.put("roles", new String[]{"Member", "Admin"});
        map.put("admin", true);

        JsonNode node = Json.toJson(map);


        System.out.println(Json.prettyPrint(Json.parse(node));
    }

}
