package orange.java.pl2.adventurecentral.users;

import orange.java.pl2.adventurecentral.users.models.Role;
import org.apache.catalina.User;

public class UserService {

    public static void addRole(User user, RoleName roleName){
        if (!hasRole(user, roleName)){
            user.getRoles().add(new Role(roleName));
        }
    }

    public static void removeRole(User user, RoleName roleName){
        if (hasRole(user, roleName)){
            user.getRoles().removeIf(role -> role.getRoleName().equals(roleName));
        }
    }

    public static boolean hasRole(User user, RoleName roleName){
        return user.getRoles().stream().
                filter(u -> u.getRoleName().equals(roleName)).count() >0;
    }

    public static boolean hasRole(User user, RoleName ... roleNames){
        for (RoleName roleName : roleNames) {
            if (hasRole(user, roleName)){
                return true;
            }
        }
        return false;
    }


}
