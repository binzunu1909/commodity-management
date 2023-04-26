package org.invoice;

public class Gasoline {
    private String nameGas;
    private double unitPrice;
    private double litAvailable;

    public Gasoline(String nameGas, double unitPrice, double litAvailable) {
        this.nameGas = nameGas;
        this.unitPrice = unitPrice;
        this.litAvailable = litAvailable;
    }

    public String getNameGas() {
        return nameGas;
    }

    public void setNameGas(String nameGas) {
        this.nameGas = nameGas;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getLitAvailable() {
        return litAvailable;
    }

    public void setLitAvailable(double litAvailable) {
        this.litAvailable = litAvailable;
    }

    @Override
    public String toString() {
        return nameGas  +
                ", price is " + unitPrice + " VND/lit";
    }
}
