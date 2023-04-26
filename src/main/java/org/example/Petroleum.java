package org.example;
public class Petroleum extends Commodity{

    private String namePetro;
    private double volumePetroAvailable;
    private double unitPrice;
    private double intoMoney;

    public Petroleum(String typeCommodity, String namePetro, double volumePetroAvailable) {
        super(typeCommodity);
        this.namePetro = namePetro;
        this.volumePetroAvailable = volumePetroAvailable;
    }

    public String getNamePetro() {
        return namePetro;
    }

    public void setNamePetro(String namePetro) {
        this.namePetro = namePetro;
    }

    public double getVolumePetroAvailable() {
        return volumePetroAvailable;
    }

    public void setVolumePetroAvailable(double volumePetroAvailable) {
        this.volumePetroAvailable = volumePetroAvailable;
    }

    @Override
    public String toString() {
        return "Petrolium{" +
                "namePetro='" + namePetro + '\'' +
                ", volumePetroAvailable=" + volumePetroAvailable +
                '}';
    }
}