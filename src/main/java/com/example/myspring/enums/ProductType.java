package com.example.myspring.enums;


public enum ProductType {
    COLA(130,"cola"),
    FANTA(120,"fanta"),
    SPRITE(125,"sprite"),
    WATER(119,"water"),
    TONIC_WATER(167,"tonic_water"),
    LAYS(80,"lays"),
    CHIPS(80,"chips"),

    PEANUTS(60,"peanuts"),

    SKITTLES(55,"skittles"),

    BAKE_ROLLS(268,"bake_rolls"),
    DORITOS(60,"doritos"),
    M_AND_M(55,"m_and_m"),
    MASK(200,"mask"),
    GUM(100,"gum"),
    CIGARS(300,"cigars"),
    MAGNET(1500,"magnet"),
    KEY_HOLDER(3200,"key_holder");
    private final String code;

    ProductType(int price, String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
