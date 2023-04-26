package org.invoice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private LocalDateTime dateTime;
    private double total;
    private double quantityLitSale;
    private double intoMoney;

    public Invoice() {
    }

    public Invoice(LocalDateTime dateTime, double total, double quantityLitSale, double intoMoney) {
        this.dateTime = dateTime;
        this.total = total;
        this.quantityLitSale = quantityLitSale;
        this.intoMoney = intoMoney;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getQuantityLitSale() {
        return quantityLitSale;
    }

    public void setQuantityLitSale(double quantityLitSale) {
        this.quantityLitSale = quantityLitSale;
    }

    public double getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(double intoMoney) {
        this.intoMoney = intoMoney;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "dateTime=" + dateTime +
                ", total=" + total +
                ", quantityLitSale=" + quantityLitSale +
                ", intoMoney=" + intoMoney +
                '}';
    }

    public double calIntoMoneyGas(int number, double lit, List<Gasoline> gasolines){
        double mountIntoMoney = 0;
        for (int vt=0; vt<gasolines.size(); vt++){
            if(vt==number){
                mountIntoMoney= lit * gasolines.get(vt).getUnitPrice();
            }
        }
        return mountIntoMoney;
    }

}
