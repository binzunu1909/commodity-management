package org.invoice;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    private String csvFile;
    private FileReader reader = null;
    private CSVParser parser = null;

    public ReadCSV(String csvFile) {
        this.csvFile = csvFile;
    }
    public String getCsvFile() {
        return csvFile;
    }
    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }

    public List<Commodity> readFileCommodity(){
        List<Commodity> commodityList = new ArrayList<>();
        try {
            String fileReader = this.csvFile;
            reader = new FileReader(fileReader);
            parser = CSVFormat.DEFAULT.withHeader().parse(reader);

            for (CSVRecord record : parser) {
                String id = record.get("id");
                String typeCommodity = record.get("typeCommodity");

                Commodity commodityObject = new Commodity(id,typeCommodity);
                commodityList.add(commodityObject);

            }
//            for (Commodity commodity : commodityList) {
//                System.out.println(commodity);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReadFile();
        }
        return commodityList;
    }

    public List<Gasoline> readFileGasoline(){
        List<Gasoline> gasolineList = new ArrayList<>();
        try {
            String fileReader = this.csvFile;
            reader = new FileReader(fileReader);
            parser = CSVFormat.DEFAULT.withHeader().parse(reader);

            for (CSVRecord record : parser) {
                String nameGas = record.get("name");
                double unitPrice = Double.parseDouble(record.get("unit price"));
                double litAvailable = Double.parseDouble(record.get("lit available"));

                Gasoline gasolineObject = new Gasoline(nameGas,unitPrice,litAvailable);
                gasolineList.add(gasolineObject);

            }
//            for (Gasoline gasoline : gasolineList) {
//                System.out.println(gasoline);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReadFile();
        }
        return gasolineList;
    }

    public List<Petroleum> readFilePetroleum(){
        List<Petroleum> petroleumList = new ArrayList<>();
        try {
            String fileReader = this.csvFile;
            reader = new FileReader(fileReader);
            parser = CSVFormat.DEFAULT.withHeader().parse(reader);

            for (CSVRecord record : parser) {
                String namePetro = record.get("name");
                double unitPrice = Double.parseDouble(record.get("unit price"));
                double litAvailable = Double.parseDouble(record.get("lit available"));

                Petroleum petroleumObject = new Petroleum(namePetro,unitPrice,litAvailable);
                petroleumList.add(petroleumObject);

            }
//            for (Petroleum petroleum : petroleumList) {
//                System.out.println(petroleum);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReadFile();
        }
        return petroleumList;
    }
    public void closeReadFile(){
        try {
            if (reader != null) reader.close();
            if (parser != null) parser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
