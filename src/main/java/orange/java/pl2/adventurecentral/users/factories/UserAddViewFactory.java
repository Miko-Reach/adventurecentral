package orange.java.pl2.adventurecentral.users.factories;

import org.hibernate.annotations.Parent;

import java.io.IOException;

public class UserAddViewFactory extends AbstractPrepareViewFactory {
    public UserAddViewFactory() {
        }

        public Parent create() throws FxerException {
            try {
                FxViewFactory fxViewFactory = (new FxViewFactory("/patron/users/guis/add/UserAddView.fxml", "patron/users/guis/add/translations/UserAdd", new UserAddController(), this.fXStage)).addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css");
                FxView fxView = fxViewFactory.create();
                return fxView.createView();
            } catch (IOException var3) {
                throw new FxerException(var3);
            }
        }
}
