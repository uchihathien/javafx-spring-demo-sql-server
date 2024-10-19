package cinema.backend.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author github: uchihathien
 * Created on 9/26/2024
 */

@Getter
@Setter
public class CurrentUser {
    private static CurrentUser  instance;
    private String username;
    private String fullName;

    private CurrentUser() {}

    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }
}
