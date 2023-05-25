package orange.java.pl2.adventurecentral.tickets.guis.list.controllerExtend;

import orange.java.pl2.adventurecentral.auth.globals.UserGlobal;
import orange.java.pl2.adventurecentral.tickets.models.Ticket;
import orange.java.pl2.adventurecentral.tickets.repositories.TicketRepository;

import java.util.List;

import static lombok.Lombok.sneakyThrow;

public class FiltrControllerExtend extends NavigationControllerExtend {

    protected ObservableList<Ticket> items;

    protected ObservableList<Ticket> filteredItems;

    protected FiltrControllerExtend() {
        this.addOnInitializeWithSneakyThrow(() -> {
            this.items = FXCollections.observableArrayList();
            this.filteredItems = FXCollections.observableArrayList();
        });

        this.addOnInitializeWithSneakyThrow(() -> {
            this.navigationPageCombobox.setOnAction((event) -> {
                filterItems();
            });
        });

        this.addOnInitializeWithSneakyThrow(() -> {
            loadItems();
        });
    }

    private void filterItems() {
        this.filteredItems.clear();
        NavigationPage navigationPage = this.navigationPageCombobox.getSelectionModel().getSelectedItem();
        if (navigationPage == null) {
            return;
        }
        int fromIndex = (navigationPage.getPage() - 1) * ITEMS_PER_PAGE;
        List<Ticket> filtered = this.items.subList(fromIndex, Math.min(fromIndex + ITEMS_PER_PAGE, this.items.size()));
        this.filteredItems.addAll(filtered);
    }

    protected void loadItems() {
        sneakyThrow(() -> {
            this.items.clear();
            List<Ticket> tickets = TicketRepository.getByType(this.ticketType);
            for (Ticket ticket : tickets) {
                if (ticket.getReservedBy() != null && ticket.getReserved()) {
                    boolean myTicket = ticket.getReservedBy().equals(UserGlobal.getUser());
                    if (myTicket) {
                        this.items.add(ticket);
                    }
                }
            }
            for (Ticket ticket : tickets) {
                if (!ticket.getReserved()) {
                    this.items.add(ticket);
                }
            }
        });
        filterItems();
    }
}
