package com.hearuexperts.postcoder.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
  public String postcode;

  @JsonProperty("line_1")
  public String line1;
  @JsonProperty("line_2")
  public String line2;
  @JsonProperty("line_3")
  public String line3;


  @Override
  public String toString() {
    return "AddressDto{" +
            "postcode='" + postcode + '\'' +
            ", line1='" + line1 + '\'' +
            ", line2='" + line2 + '\'' +
            ", line3='" + line3 + '\'' +
            '}';
  }
}
