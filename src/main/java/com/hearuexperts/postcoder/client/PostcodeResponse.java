package com.hearuexperts.postcoder.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodeResponse {
  @JsonProperty("result")
  public List<AddressDto> addresses;
}

