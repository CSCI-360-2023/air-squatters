package local.airsquatters.TicketSystem;

public class PaymentVerification {
    
    public boolean paymentChecker() {
        double secret = Math.random();
        double othernum = Math.random();
        return secret == othernum;
    }
}
