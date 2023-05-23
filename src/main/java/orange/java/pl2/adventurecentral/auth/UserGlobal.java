package orange.java.pl2.adventurecentral.auth;

import org.apache.catalina.User;

public class UserGlobal {

    public static boolean isReAuth = false;

    private static User user;

    /**
     * Gets user.
     *
     * @return the user
     */
    public static User getUser() {
        if (user == null){
            throw new IllegalArgumentException("user is null");
        }
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public static void setUser(User user) {
        UserGlobal.user = user;
    }
}
