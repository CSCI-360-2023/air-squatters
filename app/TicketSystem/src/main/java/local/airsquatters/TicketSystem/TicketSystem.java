package local.airsquatters.TicketSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class TicketSystem {

    public AccountService service = new AccountService();
    public AccountController controller = new AccountController(service);

    private LinkedList<Seat> cart;
    private Account activeAccount;

    // TODO SHOULD loggedIn BE HERE OR IN ACCOUNT?
    private boolean loggedIn = false;

    public static void main(String[] args) { SpringApplication.run(TicketSystem.class, args); }

    @GetMapping("/login")
	public String apiRoot() {
		return "Login page";
	}
    
    @GetMapping("/test")
    public String apiTest() {
        
        Account testAccount = new Account(123456, "John", "Smith", "abcdefg", "example@new.com");

        service.createAccount(testAccount);
        try {
            return service.findSingleAccount(123456).toString();
        } catch(Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    // TODO SWITCH TO TRY CATCH
    public void checkUserPass(Integer cofcID, String password) {
        boolean userQuery;
        // query database and store result in variable userQuery
            // if (userQuery == true) {
                // logIn();
            // }

            // if (userQuery == false) {
                // System.out.println("ACCOUNT NOT FOUND");
            // }

    }

    // TODO FILL STUFF OUT
    public boolean Payment() {
        return true;
    }
    // TODO FILL STUFF OUT
    public void createReceipt() {

    }
    // TODO FILL STUFF OUT
    public void generateTickets() {
        
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
