package com.hearuexperts.postcoder.resource;

import com.hearuexperts.postcoder.domain.Address;
import com.hearuexperts.postcoder.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
@RestController
public class AddressController {

  AddressService addressService;

  @Autowired
  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  @RequestMapping("/")
  public Map<String, List<Address>> findAddresses(){
    return addressService.getAddressesForMultiple("W6 0LG", "SW1A 2AA", "BT48 6DQ");
  }
}
