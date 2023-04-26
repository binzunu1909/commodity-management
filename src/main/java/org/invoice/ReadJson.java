package org.invoice;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadJson{
    private String jsonFile;
    private ObjectMapper objectMapper = null;
    private File input = null;

    public ReadJson(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    public String getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    public List<Commodity> readFileCommodity(){
        List<Commodity> commodities = null;
        try {
            objectMapper = new ObjectMapper();
            // convert JSON array to list of objects
            commodities = Arrays.asList(objectMapper.readValue(Paths.get(this.jsonFile).toFile(), Commodity[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commodities;
    }
}
