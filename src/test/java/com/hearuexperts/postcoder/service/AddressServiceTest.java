package com.hearuexperts.postcoder.service;

import com.hearuexperts.postcoder.client.AddressDto;
import com.hearuexperts.postcoder.client.AddressRestClient;
import com.hearuexperts.postcoder.domain.Address;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
public class AddressServiceTest {

  @Test
  public void getAddressesForShouldReturnListOfAddresses(){
    // Given
    String postcode = "POSTCODE";
    AddressDto dto1 = new AddressDto();
    dto1.postcode = postcode;
    dto1.line1 = "1: line1";
    dto1.line2 = "1: line2";
    dto1.line3 = "1: line3";

    AddressDto dto2 = new AddressDto();
    dto2.postcode = postcode;
    dto2.line1 = "2: line1";
    dto2.line2 = "2: line2";
    dto2.line3 = "2: line3";

    AddressRestClient addressRestClientMock = mock(AddressRestClient.class);
    when(addressRestClientMock.findAddressesFor(anyString())).thenReturn(Arrays.asList(dto1, dto2));
    AddressService service = new AddressService(addressRestClientMock);

    // When
    List<Address> result = service.getAddressesFor(postcode);

    // Then
    verify(addressRestClientMock).findAddressesFor(postcode);

    assertTrue(result.size() == 2);

    assertEquals(dto1.line1, result.get(0).getLine1());
    assertEquals(dto1.line2, result.get(0).getLine2());
    assertEquals(dto1.line3, result.get(0).getLine3());
    assertEquals(dto1.postcode, result.get(0).getPostcode());

    assertEquals(dto2.line1, result.get(1).getLine1());
    assertEquals(dto2.line2, result.get(1).getLine2());
    assertEquals(dto2.line3, result.get(1).getLine3());
    assertEquals(dto2.postcode, result.get(1).getPostcode());
  }

  public void getAddressesForMultipleShouldReturnListOfAddresses(){
    // Given
    String postcode1 = "POSTCODE_1";
    String postcode2 = "POSTCODE_2";
    AddressDto dto1 = new AddressDto();
    dto1.postcode = postcode1;
    dto1.line1 = "1: line1";
    dto1.line2 = "1: line2";
    dto1.line3 = "1: line3";

    AddressDto dto2 = new AddressDto();
    dto2.postcode = postcode2;
    dto2.line1 = "2: line1";
    dto2.line2 = "2: line2";
    dto2.line3 = "2: line3";

    AddressRestClient addressRestClientMock = mock(AddressRestClient.class);
    when(addressRestClientMock.findAddressesFor(eq(postcode1))).thenReturn(Arrays.asList(dto1));
    when(addressRestClientMock.findAddressesFor(eq(postcode2))).thenReturn(Arrays.asList(dto2));
    AddressService service = new AddressService(addressRestClientMock);

    // When
    Map<String, List<Address>> result = service.getAddressesForMultiple(postcode1, postcode2);

    // Then
    verify(addressRestClientMock).findAddressesFor(postcode1);
    verify(addressRestClientMock).findAddressesFor(postcode2);

    assertNotNull(result.get(postcode1));
    assertTrue(result.get(postcode1).size() == 1);
    assertEquals(dto1.line1, result.get(postcode1).get(0).getLine1());
    assertEquals(dto1.line2, result.get(postcode1).get(0).getLine2());
    assertEquals(dto1.line3, result.get(postcode1).get(0).getLine3());
    assertEquals(dto1.postcode, result.get(postcode1).get(0).getPostcode());

    assertNotNull(result.get(postcode2));
    assertTrue(result.get(postcode2).size() == 1);
    assertEquals(dto2.line1, result.get(postcode2).get(0).getLine1());
    assertEquals(dto2.line2, result.get(postcode2).get(0).getLine2());
    assertEquals(dto2.line3, result.get(postcode2).get(0).getLine3());
    assertEquals(dto2.postcode, result.get(postcode2).get(0).getPostcode());
  }
}
