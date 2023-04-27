package org.implementaion;

import org.invoice.DataReader;

public class Useing {
    public static void main(String[] args) {

        DataReader dataReader = new CSVReader();
        dataReader.readFile();

        //DataReader dataReader = new JSonReader();
        //dataReader.readFile();



    }
}
