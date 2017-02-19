package com.hearuexperts.postcoder.service;

import com.hearuexperts.postcoder.client.AddressDto;
import com.hearuexperts.postcoder.domain.Address;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
public class AddressConverter {

  public static Address dtoToDomain(AddressDto dto){
    Address domain = new Address();
    domain.setPostcode(dto.postcode);
    domain.setLine1(dto.line1);
    domain.setLine2(dto.line2);
    domain.setLine3(dto.line3);
    return domain;
  }

}
