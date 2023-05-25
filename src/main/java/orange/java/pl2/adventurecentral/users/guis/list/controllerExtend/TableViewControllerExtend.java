package orange.java.pl2.adventurecentral.users.guis.list.controllerExtend;

import orange.java.pl2.adventurecentral.auth.globals.UserGlobal;
import orange.java.pl2.adventurecentral.tickets.guis.list.controllerExtend.FiltrControllerExtend;
import orange.java.pl2.adventurecentral.tickets.models.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.events.Event;

import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Iterator;

public class TableViewControllerExtend extends FiltrControllerExtend {
    private static final Logger logger = LogManager.getLogger(TableViewControllerExtend.class);
    @FXML
    protected TableView<Event> table;
    @FXML
    protected TableColumn<String, Event> columnTitle;
    @FXML
    protected TableColumn<Event, Node> columnGeneratedTicketCount;
    @FXML
    protected TableColumn<Event, Node> columnReservedTicketCount;
    @FXML
    protected TableColumn<Event, Node> columnButtonRemove;

    protected TableViewControllerExtend() {
        this.addOnInitializeWithSneakyThrow((resourceBundle) -> {
            this.table.setItems(this.filteredItems);
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnGeneratedTicketCount.getStyleClass().add("alignment-center");
            this.columnReservedTicketCount.getStyleClass().add("alignment-center");
            this.columnButtonRemove.getStyleClass().add("alignment-center");
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnTitle.setCellValueFactory(new PropertyValueFactory("title"));
            this.columnGeneratedTicketCount.setCellFactory((new UniversalTableCell()).forTableColumn((node, event) -> {
                return new Label(String.valueOf(event.getTickets().size()));
            }));
            this.columnReservedTicketCount.setCellFactory((new UniversalTableCell()).forTableColumn((node, event) -> {
                return new Label(String.valueOf(event.getTickets().stream().filter(Ticket::getReserved).count()));
            }));
            this.columnButtonRemove.setCellFactory((new UniversalTableCell()).forTableColumn((node, event) -> {
                Button generateButton = new Button("Usuń");
                generateButton.setOnAction((e) -> {
                    ExceptionDialogThrowSneaker.sneaky(() -> {
                        UserGlobal.getUser().getGeneratedEvents().remove(event);
                        DBOperator.save(UserGlobal.getUser());
                        Iterator var2 = event.getTickets().iterator();

                        while(var2.hasNext()) {
                            Ticket ticket = (Ticket)var2.next();
                            DBOperator.delete(ticket);
                        }

                        DBOperator.delete(event);
                        this.loadItems();
                    });
                });
                return generateButton;
            }));
        });
    }
}
