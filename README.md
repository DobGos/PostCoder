# PostCoder


The Problem

There is a website called Programmable Web (http://www.programmableweb.com) that lists a set of Public
APIs that are free to use. Given this resource, find a suitable 3rd party address API and create a small Spring
Boot application to retrieve the street address (and name if available) for the following UK postcodes:

● W6 0LG
● SW1A 2AA
● BT48 6DQ

Problem Constraints

● It must be written using Java 8 and use Spring Boot and Gradle.
● You can use any 3rd party libraries to help achieve your task.
● You can use any IDE (or text editor) of your choice (spaces, not tabs please!)
● Please use JSON as the data format.

How we evaluate your code

● It must solve the stated problem :­)
● When we come to clone your project, it shouldn’t take an unreasonable amount of time (think 5 minutes) for us to get it to compile and run.
● Keep your solution simple ­ don’t make it too complicated
● We look for good programming practices
    ○ Nice layout and easy to read
    ○ Clear separation of concerns
    ○ Appropriate use of objects / interfaces
■ But don’t go AbstractFactoryFactoryFactory crazy!
● We like unit tests. We also recommend using a mocking framework for API calls.



-----------------------------------------------------------------------
NOTE: This example uses https://api.ideal-postcodes.co.uk/v1/postcodes/{postcode}?api_key=iddqd to retrieve
post code addresses. At the moment there is a limit for only 15 postcodes to be retrieved per client ip per dey.
Once the limit is used no postcodes will get returned.


