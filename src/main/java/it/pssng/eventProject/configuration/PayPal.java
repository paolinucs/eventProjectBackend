package it.pssng.eventProject.configuration;
import com.paypal.core.PayPalEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.paypal.core.PayPalHttpClient;

@Configuration
public class PayPal {

    @Value("${paypal.clientId}")
    private String clientId;

    @Value("${paypal.clientSecret}")
    private String clientSecret;

    @Bean
    public PayPalHttpClient payPalHttpClient(){
        PayPalEnvironment env = new PayPalEnvironment.Sandbox(this.clientId,this.clientSecret);
        return new PayPalHttpClient(env);
    }
}
