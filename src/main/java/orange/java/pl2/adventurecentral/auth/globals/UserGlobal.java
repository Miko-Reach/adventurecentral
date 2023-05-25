package orange.java.pl2.adventurecentral.auth.globals;

import org.apache.catalina.User;

public class UserGlobal {

    public static boolean isReAuth = false;

    private static User user;

    public static User getUser() {
        if (user == null){
            throw new IllegalArgumentException("user is null");
        }
        return user;
    }

    public static void setUser(User user) {
        UserGlobal.user = user;
    }
}
