package orange.java.pl2.adventurecentral.tickets.guis.list.controllerExtend;

import orange.java.pl2.adventurecentral.auth.globals.UserGlobal;
import orange.java.pl2.adventurecentral.tickets.generators.TicketGenerator;
import orange.java.pl2.adventurecentral.tickets.models.Ticket;
import orange.java.pl2.adventurecentral.users.enums.RoleName;
import orange.java.pl2.adventurecentral.users.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Node;

import javax.swing.text.TableView;
import java.awt.*;
import java.io.File;
import java.text.NumberFormat;

public class TableViewControllerExtend extends FiltrControllerExtend {

    private static final Logger logger = LogManager.getLogger(TableViewControllerExtend.class);

    @FXML
    protected TableView<Ticket> table;

    @FXML
    protected TableColumn<Ticket, Node> columnCompany;

    @FXML
    protected TableColumn<String, Ticket> columnTitle;

    @FXML
    protected TableColumn<String, Ticket> columnDescription;

    @FXML
    protected TableColumn<Ticket, Node> columnPrice;

    @FXML
    protected TableColumn<Ticket, Node> columnReserved;

    @FXML
    protected TableColumn<Ticket, Node> columnButtonReserve;

    @FXML
    protected TableColumn<Ticket, Node> columnButtonGenerate;

    protected TableViewControllerExtend() {


        this.addOnInitializeWithSneakyThrow(resourceBundle -> {
            this.table.setItems(this.filteredItems);
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnPrice.getStyleClass().add("alignment-center");
            this.columnReserved.getStyleClass().add("alignment-center");
            this.columnButtonReserve.getStyleClass().add("alignment-center");
            this.columnButtonGenerate.getStyleClass().add("alignment-center");
        });
        this.addOnInitializeWithSneakyThrow(() -> {
            this.columnCompany.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
                return new Label(ticket.getCreatedBy().getLogin());
            }));
            this.columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            this.columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            this.columnReserved.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
                CheckBox checkbox = new CheckBox();
                checkbox.setSelected(ticket.getReserved());
                checkbox.setDisable(true);
                return checkbox;
            }));
            this.columnPrice.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
                Double price = ticket.getPrice();
                Event event = ticket.getEvent();
                if (!UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN) && UserService.hasRole(UserGlobal.getUser(), RoleName.AGENT)) {
                    price = ticket.getPrice() - (ticket.getPrice() * ( event.getAgentReduction() / 100));
                }
                return new Label(NumberFormat.getCurrencyInstance().format(price));
            }));
            this.columnButtonGenerate.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
                if (ticket.getReserved() && ticket.getReservedBy().equals(UserGlobal.getUser())){
                    Button generateButton = new Button("Generuj bilet");
                    generateButton.setOnAction((event)->{
                        ExceptionDialogThrowSneaker.sneaky(() -> {
                            File file = FileChooserFactory.create("Zapisz wygenerowany bilet")
                                    .addExtensionFilter("Plik PDF (*.pdf)", "*.pdf")
                                    .build().showSaveDialog(null);
                            TicketGenerator.generate(file, ticket);
                        });
                    });
                    return generateButton;
                }
                return new Label();
            }));
            this.columnButtonReserve.setCellFactory(new UniversalTableCell<Ticket, Node>().forTableColumn((Node node, Ticket ticket) -> {
                if (ticket.getReserved()){
                    Button unreserve = new Button("Anuluj rezerwację");
                    unreserve.setOnAction(event -> {
                        ExceptionDialogThrowSneaker.sneaky(() -> {
                            ticket.setReserved(false);
                            ticket.setReservedBy(null);
                            DBOperator.save(ticket);
                            UserGlobal.getUser().getReservedTickets().remove(ticket);
                            DBOperator.save(UserGlobal.getUser());
                            table.getColumns().get(0).setVisible(false);
                            table.getColumns().get(0).setVisible(true);
                        });
                    });
                    return unreserve;
                } else {
                    Button reserve = new Button("Rezerwuj");
                    reserve.setOnAction(event -> {
                        ExceptionDialogThrowSneaker.sneaky(() -> {
                            ticket.setReserved(true);
                            ticket.setReservedBy(UserGlobal.getUser());
                            DBOperator.save(ticket);
                            UserGlobal.getUser().getReservedTickets().add(ticket);
                            DBOperator.save(UserGlobal.getUser());
                            table.getColumns().get(0).setVisible(false);
                            table.getColumns().get(0).setVisible(true);
                        });
                    });
                    return reserve;
                }
            }));
        });
    }
}
