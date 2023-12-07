package local.airsquatters.TicketSystem;

public class PaymentVerification {
    double secret;
    double othernum;


    public PaymentVerification() {
        this.secret = Math.random();
        this.othernum = Math.random();
    }

    public boolean checkPayment() {
        return this.secret == this.othernum;
    }
}
