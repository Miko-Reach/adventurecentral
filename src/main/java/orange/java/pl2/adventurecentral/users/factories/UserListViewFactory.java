package orange.java.pl2.adventurecentral.users.factories;

import org.hibernate.annotations.Parent;

import java.io.IOException;

public class UserListViewFactory extends AbstractPrepareViewFactory {

    public Parent create() throws FxerException {
        try {
            FxView fxView = new FxViewFactory("/patron/users/guis/list/UserListView.fxml",
                    "patron/users/guis/list/translations/UserList", new UserListController(), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TableView.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css")
                    .create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }
}
