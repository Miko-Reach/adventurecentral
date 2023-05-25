package orange.java.pl2.adventurecentral.tickets.guis.list.controllerExtend;

public class OnActionsControllerExtend extends ButtonsControllerExtend {

    /**
     * Refresh.
     */
    @FXML
    public void refresh() {
        loadNavigation();
        loadItems();
    }
}
