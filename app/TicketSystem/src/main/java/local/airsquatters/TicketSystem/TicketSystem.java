package local.airsquatters.TicketSystem;

import org.apache.hadoop.fs.store.audit.AuditEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedList;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
public class TicketSystem {

    private LinkedList<Seat> cart;
    private Account activeAccount;
    private AccountService accountService;
    
    

    // TODO CREATE EVENT ARRAYLIST, NEED TO FILL THAT BITCH UP
    LinkedList<Event> eventLinkedList = new LinkedList<Event>();
    // NEW SHIT
    LinkedList<Account> accountLinkedList = new LinkedList<Account>();

    public void logIn(Integer cofcID, String password) {
        for (int i = 0; i < accountLinkedList.size(); i++) {
            if (cofcID == accountLinkedList.get(i).getCofcId() && password == accountLinkedList.get(i).getPassword()) {
                accountLinkedList.get(i).setLoggedIn(true);
            }
            else {
                System.out.println("Invalid username and or password");
            }
        }
    }

    public String purchaseTickets(Account account, Event event, int num) {
        PaymentVerification checker = new PaymentVerification();
        boolean bool = checker.checkPayment();
        Seat tempSeat = new Seat();
        Ticket tick = new Ticket(event, tempSeat);
        if (account.isLoggedIn() == true) {
            if (bool == true) {
                account.getTickets().add(tick);
                int temp = event.getInventory() - num;
                event.setInventory(temp);
                //TODO ADD SEND RECEIPT - DISPLAY ON THE SCREEN
                Reciept receipt = new Reciept(account, event, num);
                receipt.createReceipt();

                return "Payment Success";
            } else {
                return "Payment Failed, try again. BROKE BITCH";
            }
        }
        else {
            return "LOG IN YOU IDIOT";
        }
        
    public ArrayList<Event> searchForEvents(String string) {
            ArrayList<Event> eventArrayList = new ArrayList<Event>();
            for (int i = 0; i < eventLinkedList.size(); i++) {
                if eventLinkedList.get(i).toString.contains(string) {
                    eventArrayList.add(eventLinkedList.get(i));
                }
            }
            return eventArrayList;
        }
    }










    public static void main(String[] args) { SpringApplication.run(TicketSystem.class, args); }

    @GetMapping("/login")
	public String apiRoot() {
		return "Login page";
	}
   

    @GetMapping("/test")
    public String apiTest() {

        final AccountController controller = new AccountController();
        Account testAccount = new Account(123456, "John", "Smith", "abcdefg", "example@new.com");

        controller.createAccount(testAccount);
        try {
            return "SUCCESS";
        } catch(Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    // TODO SWITCH TO TRY CATCH
    public void checkUserPass(Integer cofcID, String password) {
        boolean userQuery;
        if (cofcID == accountservice.findSingleAccount(cofcID).getCofCId()) {
            logIn();
        }
        else {
            System.out.println("NO MATCH FOUND");
        }

    }

    private void setLoggedIn(boolean bool) {
        this.loggedIn = bool;
    }

    private void logIn() {
        setLoggedIn(true);
    }

    private void logOut() {
        setLoggedIn(false);
    }

    
}
