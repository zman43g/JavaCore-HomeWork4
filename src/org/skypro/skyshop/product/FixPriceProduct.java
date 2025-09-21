package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private final int fixPrice;

    public FixPriceProduct(String productName, int fixPrice) {
        super(productName);
        this.fixPrice = fixPrice;
    }

    @Override
    public int getPrice() {
        return fixPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getDiscount() {
        return 0;
    }
}
