package local.airsquatters.TicketSystem;



public class Reciept {
    Account account;
    Event event;
    int num;


    public Reciept(Account account, Event event, int num) {
      this.account = account;
      this.event = event;
      this.num = num;
    }


    public String createReceipt() {
      return "You purchased " + num + " tickets to " + event.toString() + ", your total is: $" + num * 10;
    }

  // public static void main(String[] args) {
     
  //     // Recipient and sender email addresses
  //     String to = "demo@example.com";
  //     String from = "sender@example.com";

  //     // Mailtrap credentials for authentication
  //     final String username = "a1b2c3d4e5f6";
  //     final String password = "a1b2c3d4e5f6";
  //     String host = "smtp.mailtrap.io";

  //     // Setting up mail server properties
  //     Properties properties = new Properties();
  //     properties.put("mail.smtp.auth", "true");
  //     properties.put("mail.smtp.starttls.enable", "true");
  //     properties.put("mail.smtp.host", host);
  //     properties.put("mail.smtp.port", "2525");

  //     // Establishing a mail session with authentication details
  //     Session session = Session.getInstance(properties,
  //       new Authenticator() {
  //           protected PasswordAuthentication getPasswordAuthentication() {
  //             return new PasswordAuthentication(username, password);
  //           }
  //       });

  //     try {
  //       // Crafting the email message
  //       Message message = new MimeMessage(session);
  //       message.setFrom(new InternetAddress(from));
  //       message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
  //       message.setSubject("JavaMail Introductory Test");
  //       message.setText("Hello, this is a test email from JavaMail.");

  //       // Sending the email
  //       Transport.send(message);
  //       System.out.println("Email sent successfully....");
  //     } catch (MessagingException e) {
  //       // Handle any exceptions that arise during sending
  //       throw new RuntimeException(e);
  //     }
  // }
}

