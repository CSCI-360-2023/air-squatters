package local.airsquatters.TicketSystem;

import java.nio.file.Paths;

import static spark.Spark.post;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

public class Checkout {
  public static void main(String[] args) {
    port(4242);

    // This is your test secret API key.
    Stripe.apiKey = "sk_test_51OC6HpDS4hjVGXeWgmGwCK8jVVxKHEIKjiOTH3xc9o1LXVXfSgrf8VKWyBursH8JEVVVgjDlT8VCDu6IlNqLP1OK00cr9UJrPy";

    staticFiles.externalLocation(
        Paths.get("public").toAbsolutePath().toString());

    post("/create-checkout-session", (request, response) -> {
        String YOUR_DOMAIN = "http://localhost:4242";
        SessionCreateParams params =
          SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl(YOUR_DOMAIN + "?success=true")
            .setCancelUrl(YOUR_DOMAIN + "?canceled=true")
            .addLineItem(
              SessionCreateParams.LineItem.builder()
                .setQuantity(1L)
                // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                .setPrice("{{PRICE_ID}}")
                .build())
            .build();
      Session session = Session.create(params);

      response.redirect(session.getUrl(), 303);
      return "";
    });
  }
}
