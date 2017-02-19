package com.hearuexperts.postcoder.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
@Component
public class AddressRestClient {

  @Autowired
  Client restClient;

  @Autowired
  String postcodeApiHost;

  @Autowired
  String postcodeApiUrl;

  public List<AddressDto> findAddressesFor(String postcode) {
    return restClient.target(constructUrl(postcode))
            .request(MediaType.APPLICATION_JSON_TYPE)
            .get()
            .readEntity(PostcodeResponse.class).addresses;
  }

  private String constructUrl(String postcode) {
    return postcodeApiHost + postcodeApiUrl.replace("{postcode}", postcode);
  }
}
