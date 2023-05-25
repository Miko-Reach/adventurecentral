package orange.java.pl2.adventurecentral.tickets.generators;

import jdk.jfr.Event;
import orange.java.pl2.adventurecentral.auth.globals.UserGlobal;
import orange.java.pl2.adventurecentral.tickets.DocumentException;
import orange.java.pl2.adventurecentral.tickets.models.Ticket;
import orange.java.pl2.adventurecentral.users.enums.RoleName;
import orange.java.pl2.adventurecentral.users.services.UserService;

import javax.swing.text.Document;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.NumberFormat;

public class TicketGenerator {

    public static void generate(File toFile, Ticket ticket) throws DocumentException, FileNotFoundException {
        Event event = ticket.getEvent();
        Double price = ticket.getPrice();
        if (!UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN) && UserService.hasRole(UserGlobal.getUser(), RoleName.AGENT)) {
            price = ticket.getPrice() - (ticket.getPrice() * ( event.getAgentReduction() / 100));
        }
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(toFile));
        document.open();
        Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font bold16 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        document.add(new Paragraph("=============================================", normal));
        document.add(new Paragraph(getTitle(ticket), bold16));
        document.add(new Paragraph("", normal));
        document.add(new Paragraph(ticket.getTitle(), bold));
        document.add(new Paragraph("", normal));
        document.add(new Paragraph(ticket.getDescription(), normal));
        document.add(new Paragraph("", normal));
        document.add(new Paragraph("Cena: " + NumberFormat.getCurrencyInstance().format(price).replace("zł", "PLN"), bold));
        document.add(new Paragraph("", normal));
        document.add(new Paragraph("Organizator: " + ticket.getCreatedBy().getLogin(), normal));
        document.add(new Paragraph("Zarezerwowany dla: " + ticket.getReservedBy().getLogin(), normal));
        document.add(new Paragraph("=============================================", normal));
        document.close();
    }

    private static String getTitle(Ticket ticket){
        switch (ticket.getType()){
            case FLIGHT:
                return "Bilet na lot";
            case TOUR:
                return "Bilet na wycieczkę";
            case TURNUS:
                return "Bilet na turnus";
            default:
                return "Bilet";
        }
    }
}
