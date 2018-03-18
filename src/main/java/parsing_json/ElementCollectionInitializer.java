package parsing_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ElementCollectionInitializer {
    public static ElementCollection generate() throws IOException {
        try (Reader reader = new InputStreamReader(ElementCollection.class.getResourceAsStream("/periodic_table.json"), "UTF-8")) {
            Gson gson = new GsonBuilder().create();
            ElementCollection elements = gson.fromJson(reader, ElementCollection.class);
            return elements;
        }
    }
}
