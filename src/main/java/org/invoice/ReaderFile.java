package org.invoice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ReaderFile implements DataReader{
    private String pathFile;
    private FileReader reader = null;
    private CSVParser parser = null;
    private ObjectMapper objectMapper = null;

    public ReaderFile() {
    }
    public ReaderFile(String csvFile) {
        this.pathFile = csvFile;
    }
    public String getCsvFile() {
        return pathFile;
    }
    public void setCsvFile(String csvFile) {
        this.pathFile = csvFile;
    }

    @Override
    public List<?> readFile(String pathFile){
        List<?> resultList = null;
        Pattern pattern = Pattern.compile("^.*\\.csv$");
        boolean checkTypeFileCSV = pattern.matcher(pathFile).matches();
        this.pathFile = pathFile;
        if (checkTypeFileCSV == true) {
            resultList = readFileCommodityCSV();
        } else {
            resultList = readFileCommodityJSON();
        }
        return resultList;
    }



    public List<?> readFromJSON(String nameObject, String pathFile) {
        List<?> resultList = null;
        this.pathFile = pathFile;
        switch (nameObject) {
            case "Commodity":
                resultList = readFileCommodityJSON();
                break;
            case "Gasoline":
                resultList = readFileGasolineJSON();
                break;
            case "Petroleum":
                resultList = readFilePetroleumJSON();
                break;
            default:
                System.out.println("No found file");

        }
        return resultList;
    }
    public List<Commodity> readFileCommodityCSV(){
        List<Commodity> commodityList = new ArrayList<>();
        try {
            String fileReader = this.pathFile;
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

    public List<Gasoline> readFileGasolineCSV(){
        List<Gasoline> gasolineList = new ArrayList<>();
        try {
            String fileReader = this.pathFile;
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

    public List<Petroleum> readFilePetroleumCSV(){
        List<Petroleum> petroleumList = new ArrayList<>();
        try {
            String fileReader = this.pathFile;
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
    public List<Commodity> readFileCommodityJSON(){
        List<Commodity> commodities = null;
        try {
            objectMapper = new ObjectMapper();
            // convert JSON array to list of objects
            commodities = Arrays.asList(objectMapper.readValue(Paths.get(this.pathFile).toFile(), Commodity[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commodities;
    }
    public List<Gasoline> readFileGasolineJSON(){
        List<Gasoline> gasolines = null;
        try {
            objectMapper = new ObjectMapper();
            // convert JSON array to list of objects
            gasolines = Arrays.asList(objectMapper.readValue(Paths.get(this.pathFile).toFile(), Gasoline[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gasolines;
    }
    public List<Petroleum> readFilePetroleumJSON(){
        List<Petroleum> petroleums = null;
        try {
            objectMapper = new ObjectMapper();
            // convert JSON array to list of objects
            petroleums = Arrays.asList(objectMapper.readValue(Paths.get(this.pathFile).toFile(), Petroleum[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return petroleums;
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
