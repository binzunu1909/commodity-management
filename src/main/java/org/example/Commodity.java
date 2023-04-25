package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Commodity {
    private String typeCommodity;
    private double unitPrice;
    private double intoMoney;
    String csvFile = "/Users/admin/IdeaProjects/commodity-management/Commodity.csv";
    String line = "";
    String csvSplitBy = ",";
    public Commodity(String typeCommodity) {
        this.typeCommodity = typeCommodity;
    }

    public Commodity(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Commodity() {
    }

    public String getTypeCommodity() {
        return typeCommodity;
    }

    public void setTypeCommodity(String typeCommodity) {
        this.typeCommodity = typeCommodity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(double intoMoney) {
        this.intoMoney = intoMoney;
    }
    public List<Commodity> ReadFileCSV() throws IOException {
        String fileCSV = this.csvFile;
        List<Commodity> commodityList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileCSV))) {
            String[] values;
            while ((line = br.readLine()) != null) {
                values = line.split(csvSplitBy);
                for (String i : values) {
                    System.out.println(i);
                    Commodity cm = new Commodity(i);
                    commodityList.add(cm);
                }
            }
//                   System.out.println("Value 1: " + values[0] + " Value 2: " + values[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commodityList;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "typeCommodity='" + typeCommodity + '\'' +
                '}';
    }
}