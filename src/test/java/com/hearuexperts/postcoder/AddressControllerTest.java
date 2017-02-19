package com.hearuexperts.postcoder;

import com.hearuexperts.postcoder.resource.AddressController;
import com.hearuexperts.postcoder.service.AddressService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.anyVararg;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
public class AddressControllerTest {

  @Test
  public void findAddressesShouldUseAddressServiceToFindAddressesForThreePostCodes(){
    // Given
    String[] requiredPostCodes = {"W6 0LG", "SW1A 2AA", "BT48 6DQ"};

    AddressService addressServiceMock = mock(AddressService.class);
    AddressController addressController = new AddressController(addressServiceMock);
    Map map = new HashMap();
    when(addressServiceMock.getAddressesForMultiple(anyVararg())).thenReturn(map);

    // When
    Map result = addressController.findAddresses();

    // Then
    verify(addressServiceMock).getAddressesForMultiple(requiredPostCodes);

  }


}
