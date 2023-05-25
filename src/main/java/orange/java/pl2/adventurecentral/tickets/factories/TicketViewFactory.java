package orange.java.pl2.adventurecentral.tickets.factories;

import orange.java.pl2.adventurecentral.tickets.TicketType;
import org.hibernate.annotations.Parent;

import java.io.IOException;

public class TicketViewFactory extends AbstractPrepareViewFactory {

    private TicketType ticketType;

    private String title;

    public TicketViewFactory(String title, TicketType ticketType) {
        this.ticketType = ticketType;
        this.title = title;
    }

    public Parent create() throws FxerException {
        try {
            FxView fxView = new FxViewFactory("/patron/tickets/guis/list/TicketListView.fxml",
                    "patron/tickets/guis/list/translations/TicketList", new TicketListController(this.title, this.ticketType), this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/TableView.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css")
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/ComboBox.css")
                    .create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }
}
