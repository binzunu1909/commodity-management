package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadCSV re = new ReadCSV("/Users/admin/IdeaProjects/commodity-management/Gasoline.csv");
        re.readFile();
//        Commodity cm = new Commodity();
//        System.out.println(cm.ReadFileCSV());
    }
}
