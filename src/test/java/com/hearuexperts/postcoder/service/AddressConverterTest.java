package com.hearuexperts.postcoder.service;

import com.hearuexperts.postcoder.client.AddressDto;
import com.hearuexperts.postcoder.domain.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
public class AddressConverterTest {

  @Test
  public void nonNullValuesInDomainObjectShouldMatchTheValuesInTheDto(){
    // Given
    AddressDto dto = new AddressDto();
    dto.line1 = "line1";
    dto.line1 = "line2";
    dto.line1 = "line3";
    dto.postcode = "postcode";

    // When
    Address domain = AddressConverter.dtoToDomain(dto);

    // Then
    assertEquals(dto.line1, domain.getLine1());
    assertEquals(dto.line2, domain.getLine2());
    assertEquals(dto.line3, domain.getLine3());
    assertEquals(dto.postcode, domain.getPostcode());
  }

  @Test
  public void nullValuesInDomainObjectShouldMatchTheValuesInTheDto(){
    // Given
    AddressDto dto = new AddressDto();

    // When
    Address domain = AddressConverter.dtoToDomain(dto);

    // Then
    assertEquals(dto.line1, domain.getLine1());
    assertEquals(dto.line2, domain.getLine2());
    assertEquals(dto.line3, domain.getLine3());
    assertEquals(dto.postcode, domain.getPostcode());
  }
}
