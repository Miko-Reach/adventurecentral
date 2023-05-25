package orange.java.pl2.adventurecentral.users.guis.edit.controllerExtend;

import orange.java.pl2.adventurecentral.users.factories.UserFormViewFactory;
import orange.java.pl2.adventurecentral.users.guis.add.controllerExtend.NewUserControllerExtend;

public class PanesControllerExtend extends NewUserControllerExtend {
    @FXML
    protected StackPane formPane;

    protected PanesControllerExtend() {
        this.addOnInitializeWithSneakyThrow(() -> {
            PaneViewSwitcher contentPane = new PaneViewSwitcher(this.formPane);
            contentPane.switchTo((new UserFormViewFactory(this.user)).create());
        });
    }
}
