package com.example.myspring.enums;

public enum MoneyType {
    FIFTY_EURO(5000,"fifty_euro"),
    TWENTY_EURO(2000,"twenty_euro"),
    TEN_EURO(1000,"ten_euro"),
    FIVE_EURO(500,"five_euro"),
    TWO_EURO(200,"two_euro"),
    ONE_EURO(100,"one_euro"),
    FIFTY_CENT(50,"fifty_cent"),
    TWENTY_CENT(20,"twenty_cent"),
    TEN_CENT(10,"ten_cent"),
    FIVE_CENT(5,"five_cent"),
    TWO_CENT(2,"two_cent"),
    ONE_CENT(1,"one_cent");
    private int currency;
    private final String code;


    MoneyType(int currency, String code) {
        this.currency = currency;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
}
