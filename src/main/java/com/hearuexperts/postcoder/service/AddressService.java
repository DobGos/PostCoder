package com.hearuexperts.postcoder.service;

import com.hearuexperts.postcoder.client.AddressRestClient;
import com.hearuexperts.postcoder.domain.Address;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */

@Component
public class AddressService {

  AddressRestClient addressRestClient;

  @Autowired
  public AddressService(AddressRestClient addressRestClient) {
    this.addressRestClient = addressRestClient;
  }

  public List<Address> getAddressesFor(String postcode) {
    return addressRestClient.findAddressesFor(postcode).stream().map(AddressConverter::dtoToDomain).collect(Collectors.toList());
  }

  public Map<String, List<Address>> getAddressesForMultiple(String... postcodes) {
    return Arrays.stream(postcodes).map(postcode ->
      new SimpleEntry<>(postcode, getAddressesFor(postcode))
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }


}
