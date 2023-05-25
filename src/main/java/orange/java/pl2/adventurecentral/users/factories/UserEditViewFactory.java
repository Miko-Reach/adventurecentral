package orange.java.pl2.adventurecentral.users.factories;

import org.apache.catalina.User;
import org.hibernate.annotations.Parent;

import java.io.IOException;

public class UserEditViewFactory extends AbstractPrepareViewFactory {

    private User signerAllegro;

    public UserEditViewFactory(User signerAllegro) {
        this.signerAllegro = signerAllegro;
    }

    public Parent create() throws FxerException {
        try {
            FxViewFactory fxViewFactory = new FxViewFactory("/patron/users/guis/edit/UserEditView.fxml",
                    "patron/users/guis/edit/translations/UserEdit", new UserEditController(this.signerAllegro), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css");

            FxView fxView = fxViewFactory.create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }
}
