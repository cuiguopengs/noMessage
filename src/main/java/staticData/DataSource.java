package staticData;

import java.util.UUID;

public class DataSource {
    public static User getCurrentUser() {
        User user = new User();
        user.setName("Cuisine");
        user.setToken(UUID.randomUUID().toString());
        return user;
    }
}
