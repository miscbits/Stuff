package user_management;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import parsing_json.ElementCollection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class UserCollectionInitializer {
    public static UserCollection generate() throws IOException {
        try (Reader reader = new InputStreamReader(ElementCollection.class.getResourceAsStream("/users.json"), "UTF-8")) {
            Gson gson = new GsonBuilder().create();
            UserCollection users = gson.fromJson(reader, UserCollection.class);
            return users;
        }
    }
}
