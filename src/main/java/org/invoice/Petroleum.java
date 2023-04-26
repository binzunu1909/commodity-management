package org.invoice;

public class Petroleum {
    private String namePetro;
    private double unitPrice;
    private double litAvailable;

    public Petroleum(String namePetro, double unitPrice, double litAvailable) {
        this.namePetro = namePetro;
        this.unitPrice = unitPrice;
        this.litAvailable = litAvailable;
    }

    public String getNamePetro() {
        return namePetro;
    }

    public void setNamePetro(String namePetro) {
        this.namePetro = namePetro;
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
        return "Petroleum{" +
                "namePetro='" + namePetro + '\'' +
                ", unitPrice=" + unitPrice +
                ", litAvailable=" + litAvailable +
                '}';
    }
}
