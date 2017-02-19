# PostCoder

Demonstrates usage of:
* Java 8
* SpringBoot
* Core Spring
* Jersey Rest Client
* Jackson 
* Gradle
* Jetty

For unit and integration testing:
* JUnit 4
* WireMock

## To Run
- Execute `./run.sh`
- Open `http://localhost:8080` 

## The Problem

Small SpringBoot application which uses a 3rd party address API to retrieve the 3 lines of postal address for given UK postcodes.

-----------------------------------------------------------------------
## NOTE
This example uses https://api.ideal-postcodes.co.uk/v1/postcodes/{postcode}?api_key=iddqd to retrieve
post code addresses. At the moment there is a limit for only 15 postcodes to be retrieved per client ip per dey.
Once the limit is used no postcodes will get returned.


