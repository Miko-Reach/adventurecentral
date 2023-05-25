package orange.java.pl2.adventurecentral.tickets.guis.list.controllerExtend;

import java.awt.*;

public class TitleControllerExtend extends TableViewControllerExtend {

    protected String title;

    @FXML
    protected Label titleLabel;

    public TitleControllerExtend(){
        addOnInitializeWithSneakyThrow(()->{
            this.titleLabel.setText(title);
        });
    }
}
