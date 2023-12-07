package local.airsquatters.TicketSystem;

import java.util.LinkedList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private Integer cofcId;
    private int cofcNum;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LinkedList<Ticket> tickets;
    private boolean loggedIn;

    public Account(int cofcId, String firstName, String lastName, String password, String email) {
        this.cofcNum = cofcId;
        this.cofcId = Integer.valueOf(cofcId);
        this.password = password;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.tickets = new LinkedList<Ticket>();
        this.loggedIn = false;
    }

    public Integer getCofcId() {
        return Integer.valueOf(this.cofcId);
    }
    @Override
    public String toString() {
        return "Account \nName: " + this.getFirstName() + " " + this.getLastName() + "\nEmail: " + this.getEmail();
    }
}
