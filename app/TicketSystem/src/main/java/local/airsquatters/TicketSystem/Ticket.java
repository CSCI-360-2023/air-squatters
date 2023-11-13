package local.airsquatters.TicketSystem;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Optional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    /**
     * int containing the ticket number of the ticket
     */
    private ObjectId ticketNumber;

    /**
     * Event containing the event
     */
    private Event event;

    
    /**
     * boolean indicating if the ticket is available
     */
    //TODO WHERE SHOULD THIS GO??
    private boolean available;

    /**
     * Account indicating the owner of the ticket
     */
    private Optional<Account> owner;

    private Seat seat;

    public Ticket(Event event, Seat seat) {
        this.ticketNumber = new ObjectId();
        this.event = event;
        this.owner = null;
        this.seat = seat;
    }

    public Ticket(Event event, Optional<Account> owner, Seat seat) {
        this.ticketNumber = new ObjectId();
        this.event = event;
        this.owner = owner;
        this.seat = seat;
    }

    public static BufferedImage generateEAN13BarcodeImage(ObjectId barcodeText) throws Exception {
        Barcode barcode = BarcodeFactory.createEAN13(barcodeText.toString());
        barcode.setFont(null);
    
        return BarcodeImageHandler.getImage(barcode);
    }
    
}
