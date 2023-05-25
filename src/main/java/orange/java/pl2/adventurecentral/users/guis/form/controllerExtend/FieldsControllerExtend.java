package orange.java.pl2.adventurecentral.users.guis.form.controllerExtend;

import java.awt.*;

public class FieldsControllerExtend extends UserControllerExtend {

    @FXML
    protected TextField loginField;

    @FXML
    protected PasswordField passwordField;

    protected  FieldsControllerExtend(){
        addOnInitializeWithSneakyThrow(()->{
            this.loginField.setText(this.user.getLogin());
            this.loginField.textProperty().addListener((args, oldVal, newVal)->{
                this.user.setLogin(newVal);
            });
            this.passwordField.setText(this.user.getPassword());
            this.passwordField.textProperty().addListener((args, oldVal, newVal)->{
                this.user.setPassword(newVal);
            });
        });
    }
}
