package com.hearuexperts.postcoder.config;

import com.hearuexperts.postcoder.client.AddressRestClient;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Arrays;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
public class ApplicationConfigurationTest {

  @Bean
  public String postcodeApiHost() {
    return "http://localhost:8089";
  }

  @Bean
  public String postcodeApiUrl() {
    return "/v1/postcodes/{postcode}?api_key=iddqd";
  }

  @Bean
  public AddressRestClient addressRestClient() {
    return new AddressRestClient();
  }

  @Bean
  public Client restClient(){
    ClientConfig clientConfig = new ClientConfig();
    clientConfig.register(JacksonFeature.class);
    return ClientBuilder.newClient(clientConfig);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);
    };
  }

}
