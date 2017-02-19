package com.hearuexperts.postcoder.domain;

/**
 * @author Dobromir Gospodinov
 * @date 19/02/17
 */
public class Address {
    String postcode;
    String line1;
    String line2;
    String line3;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }
}
