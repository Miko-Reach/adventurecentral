package orange.java.pl2.adventurecentral.tickets.guis.list.controllerExtend;

import orange.java.pl2.adventurecentral.tickets.repositories.TicketRepository;

import java.awt.*;

import static lombok.Lombok.sneakyThrow;

public class NavigationControllerExtend extends TypeTicketsControllerExtens {

    protected static final Integer ITEMS_PER_PAGE = 30;

    @FXML
    protected Label navigationFromLabel;

    @FXML
    protected ComboBox<NavigationPage> navigationPageCombobox;

    protected ObservableList<NavigationPage> navigationPages;


    protected NavigationControllerExtend(){
        this.addOnInitializeWithSneakyThrow(() -> {
            this.navigationPages = FXCollections.observableArrayList();
            this.navigationPageCombobox.setItems(this.navigationPages);
        });
        this.addOnInitializeWithSneakyThrow(()->{
            this.navigationPageCombobox.setCellFactory(new UniversalListCell<NavigationPage>().forCellFactory((NavigationPage navigationPage) -> {
                return new Label(navigationPage.getPage().toString());
            }));
            this.navigationPageCombobox.setButtonCell(new UniversalListCell<NavigationPage>().forButtonCell((NavigationPage navigationPage) -> {
                return new Label(navigationPage.getPage().toString());
            }));
        });
        this.addOnInitializeWithSneakyThrow(()->{
            loadNavigation();
        });
    }

    protected void loadNavigation(){
        sneakyThrow(()->{
            Long items = TicketRepository.count();
            Integer pages = new ItemsPageCounter().count(items, ITEMS_PER_PAGE);
            this.navigationFromLabel.setText(pages.toString());
            this.navigationPages.clear();
            for (Integer i = 1; i <= pages; i++) {
                this.navigationPages.add(new NavigationPage(i));
            }
            this.navigationPageCombobox.getSelectionModel().selectFirst();
        });
    }
}
