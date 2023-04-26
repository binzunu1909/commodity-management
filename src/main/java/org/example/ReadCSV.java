package org.example;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReadCSV {
    String csvFile;
    String line = "";
    String csvSplitBy = ",";
    FileReader reader = null;
    CSVParser parser = null;

    public ReadCSV(String csvFile) {
        this.csvFile = csvFile;
    }
    public String getCsvFile() {
        return csvFile;
    }
    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }


    public void readFile(){
        try {
            String fileReader = this.csvFile;
            reader = new FileReader(fileReader);
            parser = CSVFormat.DEFAULT.withHeader().parse(reader);

            List<Gasoline> gasolines = new ArrayList<>();

            for (CSVRecord record : parser) {
                String name = record.get("name");
                double price = Double.parseDouble(record.get("price"));
                double lit = Double.parseDouble(record.get("lit"));

                Commodity gasolineObject = new Gasoline(name, price, lit);
                gasolines.add((Gasoline) gasolineObject);

            }
            for (Gasoline gas : gasolines) {
                System.out.println(gas);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
                if (parser != null) parser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public void ReadFileCSV(){
//        String fileCSV = this.csvFile;
//        HashSet<String> commodityList = new HashSet<>();
//        List<String> commodityList1 = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(fileCSV))) {
//            String[] values;
//            while ((line = br.readLine()) != null) {
//                values = line.split(csvSplitBy);
//                int vt=0;
//                for(String i : values){
//                    commodityList1.add(i);
//                }
////                   System.out.println("Value 1: " + values[0] + " Value 2: " + values[1]);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(commodityList1);
//    }

}
