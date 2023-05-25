package orange.java.pl2.adventurecentral.users.validators;

import orange.java.pl2.adventurecentral.users.models.User;
import orange.java.pl2.adventurecentral.users.repositories.UserRepository;

import java.util.ResourceBundle;

public class AddUserValidator public static Boolean isValid(User user) throws DatabaserException {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("patron/users/validators/translations/UserDialogValidator", new UTF8Control());
    if (user.getLogin() == null || user.getLogin().isEmpty()){
        AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), resourceBundle
                .getString("alert.warning.content.login_is_empty")).setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
        return false;
    }
    if (UserRepository.getByLogin(user.getLogin()) != null){
        AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), resourceBundle
                .getString("alert.warning.content.login_exist")).setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
        return false;
    }
    if (user.getRoles().size() == 0){
        AlertFactory.create(Alert.AlertType.WARNING, resourceBundle.getString("alert.warning.title"), resourceBundle
                .getString("alert.warning.content.not_roles")).setIconStageResource(AppManager.getResourceIcon()).build().showAndWait();
        return false;
    }
    return true;
}
}
