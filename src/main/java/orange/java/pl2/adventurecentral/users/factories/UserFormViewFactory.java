package orange.java.pl2.adventurecentral.users.factories;

import jakarta.annotation.Nonnull;
import org.apache.catalina.User;
import org.hibernate.annotations.Parent;

import java.io.IOException;

public class UserFormViewFactory extends AbstractPrepareViewFactory {
    private User signerAllegro;

    public UserFormViewFactory(@Nonnull User signerAllegro) {
        this.signerAllegro = signerAllegro;
    }

    public Parent create() throws FxerException {
        try {
            FxView fxView = (new FxViewFactory("/patron/users/guis/form/UserFormView.fxml", "patron/users/guis/form/translations/UserForm", new UserFormController(this.signerAllegro), this.fXStage)).addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TabPane.css").addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TitledPane.css").create();
            return fxView.createView();
        } catch (IOException var2) {
            throw new FxerException(var2);
        }
    }
}
