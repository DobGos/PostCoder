package com.hearuexperts.postcoder.client;


import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.hearuexperts.postcoder.config.ApplicationConfigurationTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ApplicationConfigurationTest.class})
public class AddressRestClientTest {

  @Autowired
  AddressRestClient addressRestClient;

  @Autowired
  String postcodeApiUrl;

  @Rule
  public WireMockRule wireMockRule = new WireMockRule(8089);

  @Test
  public void whenRestServiceIsAvailableRestCallAndJsonToDtoTransformationShouldSucceed() {
    // Given
    String postcode = "SOMEPOSTCODE";
    String url = postcodeApiUrl.replace("{postcode}", postcode);
    stubForPostcodeRequestCall(url);

    // When
    List<AddressDto> result = addressRestClient.findAddressesFor(postcode);

    // Then
    verify(getRequestedFor(urlEqualTo(url)));

    assertEquals(2, result.size());

    assertEquals("W6 0LG", result.get(0).postcode);
    assertEquals("Air New Zealand Ltd", result.get(0).line1);
    assertEquals("The Triangle", result.get(0).line2);
    assertEquals("5-17 Hammersmith Grove", result.get(0).line3);

    assertEquals("W6 0LG", result.get(1).postcode);
    assertEquals("Alma Consulting Group UK Ltd", result.get(1).line1);
    assertEquals("The Triangle", result.get(1).line2);
    assertEquals("5-17 Hammersmith Grove", result.get(1).line3);
  }

  private void stubForPostcodeRequestCall(String url) {
    stubFor(get(urlEqualTo(url))
            .withHeader("Accept", equalTo("application/json"))
            .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody(getJsonDoc())));
  }

  String getJsonDoc(){
    return "{\n" +
            "  \"result\": [\n" +
            "    {\n" +
            "      \"postcode\": \"W6 0LG\",\n" +
            "      \"postcode_inward\": \"0LG\",\n" +
            "      \"postcode_outward\": \"W6\",\n" +
            "      \"post_town\": \"LONDON\",\n" +
            "      \"dependant_locality\": \"\",\n" +
            "      \"double_dependant_locality\": \"\",\n" +
            "      \"thoroughfare\": \"Hammersmith Grove\",\n" +
            "      \"dependant_thoroughfare\": \"\",\n" +
            "      \"building_number\": \"\",\n" +
            "      \"building_name\": \"The Triangle 5-17\",\n" +
            "      \"sub_building_name\": \"\",\n" +
            "      \"po_box\": \"\",\n" +
            "      \"department_name\": \"\",\n" +
            "      \"organisation_name\": \"Air New Zealand Ltd\",\n" +
            "      \"udprn\": 53473265,\n" +
            "      \"umprn\": \"\",\n" +
            "      \"postcode_type\": \"S\",\n" +
            "      \"su_organisation_indicator\": \"Y\",\n" +
            "      \"delivery_point_suffix\": \"2J\",\n" +
            "      \"line_1\": \"Air New Zealand Ltd\",\n" +
            "      \"line_2\": \"The Triangle\",\n" +
            "      \"line_3\": \"5-17 Hammersmith Grove\",\n" +
            "      \"premise\": \"The Triangle, 5-17\",\n" +
            "      \"longitude\": -0.226432574102777,\n" +
            "      \"latitude\": 51.494068006057,\n" +
            "      \"eastings\": 523220,\n" +
            "      \"northings\": 178727,\n" +
            "      \"country\": \"England\",\n" +
            "      \"traditional_county\": \"Greater London\",\n" +
            "      \"administrative_county\": \"\",\n" +
            "      \"postal_county\": \"London\",\n" +
            "      \"county\": \"London\",\n" +
            "      \"district\": \"Hammersmith and Fulham\",\n" +
            "      \"ward\": \"Hammersmith Broadway\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"postcode\": \"W6 0LG\",\n" +
            "      \"postcode_inward\": \"0LG\",\n" +
            "      \"postcode_outward\": \"W6\",\n" +
            "      \"post_town\": \"LONDON\",\n" +
            "      \"dependant_locality\": \"\",\n" +
            "      \"double_dependant_locality\": \"\",\n" +
            "      \"thoroughfare\": \"Hammersmith Grove\",\n" +
            "      \"dependant_thoroughfare\": \"\",\n" +
            "      \"building_number\": \"\",\n" +
            "      \"building_name\": \"The Triangle 5-17\",\n" +
            "      \"sub_building_name\": \"\",\n" +
            "      \"po_box\": \"\",\n" +
            "      \"department_name\": \"\",\n" +
            "      \"organisation_name\": \"Alma Consulting Group UK Ltd\",\n" +
            "      \"udprn\": 27636549,\n" +
            "      \"umprn\": \"\",\n" +
            "      \"postcode_type\": \"S\",\n" +
            "      \"su_organisation_indicator\": \"Y\",\n" +
            "      \"delivery_point_suffix\": \"2N\",\n" +
            "      \"line_1\": \"Alma Consulting Group UK Ltd\",\n" +
            "      \"line_2\": \"The Triangle\",\n" +
            "      \"line_3\": \"5-17 Hammersmith Grove\",\n" +
            "      \"premise\": \"The Triangle, 5-17\",\n" +
            "      \"longitude\": -0.226432574102777,\n" +
            "      \"latitude\": 51.494068006057,\n" +
            "      \"eastings\": 523220,\n" +
            "      \"northings\": 178727,\n" +
            "      \"country\": \"England\",\n" +
            "      \"traditional_county\": \"Greater London\",\n" +
            "      \"administrative_county\": \"\",\n" +
            "      \"postal_county\": \"London\",\n" +
            "      \"county\": \"London\",\n" +
            "      \"district\": \"Hammersmith and Fulham\",\n" +
            "      \"ward\": \"Hammersmith Broadway\"\n" +
            "    }" +
            "  ],\n" +
            "  \"code\": 2000,\n" +
            "  \"message\": \"Success\"\n" +
            "}";
  }
}