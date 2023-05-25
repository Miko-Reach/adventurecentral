package orange.java.pl2.adventurecentral.users.services;

import orange.java.pl2.adventurecentral.users.enums.RoleName;
import orange.java.pl2.adventurecentral.users.models.Role;
import org.apache.catalina.User;

public class UserService {
    public UserService() {
    }

    public static void addRole(User user, RoleName roleName) {
        if (!hasRole(user, roleName)) {
            user.getRoles().add(new Role(roleName));
        }
    }

    public static void removeRole(User user, RoleName roleName) {
        if (hasRole(user, roleName)) {
            user.getRoles().removeIf((role) -> {
                return role.getRoleName().equals(roleName);
            });
        }
    }

    public static boolean hasRole(User user, RoleName roleName) {
        return user.getRoles().stream().filter((u) -> {
            return u.getRoleName().equals(roleName);
        }).count() > 0L;
    }

    public static boolean hasRole(User user, RoleName... roleNames) {
        RoleName[] var2 = roleNames;
        int var3 = roleNames.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            RoleName roleName = var2[var4];
            if (hasRole(user, roleName)) {
                return true;
            }
        }

        return false;
    }
}
