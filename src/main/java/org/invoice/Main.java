package org.invoice;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataReader reader = new ReaderFile();
        System.out.println(reader.readFile("./commodities.json"));
//        choiceFormatReadFile();
//        System.out.println("Hello!!! Have a good day!!!");
//        askCustormer();
    }
    static List<Commodity> readFileCommo(){
        ReadCSV readCSV1 = new ReadCSV("./Commodity.csv");
        return readCSV1.readFileCommodity();
    }
    static List<Gasoline> readFileGas(){
        ReadCSV readCSV2 = new ReadCSV("./Gasoline.csv");
        return readCSV2.readFileGasoline();
    }
    static List<Petroleum> readFilePe(){
        ReadCSV readCSV3 = new ReadCSV("./Petroleum.csv");
        return readCSV3.readFilePetroleum();
    }
    static void askCustormer(){
        Scanner sc = new Scanner(System.in);
        boolean result = true;
        while (result == true) {
            int numCommodity = 1;
            int numGasoline = 1;
            int numPetroleum = 1;
            List<Commodity> commodityList = readFileCommo();
            List<Gasoline> gasolineList = readFileGas();
            List<Petroleum> petroleumList = readFilePe();
            try {
                System.out.println("We have the products below:");
                for (Commodity commodity: commodityList){
                    System.out.println(numCommodity+". "+commodity);
                    numCommodity++;
                }
                System.out.println(0+". Exit");
                System.out.println("What do you need? (Please enter number you want)");
                int c = sc.nextInt();
                switch (c) {
                    case 1:
                        System.out.println("The number of liter of petroleum you want buy? (Please enter number)");
                        break;
                    case 2:
                        System.out.println("Gasoline having:");
                        for (Gasoline gasoline:gasolineList){
                            System.out.println(numGasoline+". "+gasoline);
                            numGasoline++;
                        }
//                        System.out.println(0+". Back");
                        System.out.println("The number of liter of gasoline you want buy? (Please enter number)");
                        double lit = sc.nextDouble();
                        Invoice invoice = new Invoice();
                        System.out.println("Total: " + (float) invoice.calIntoMoneyGas(2,lit,gasolineList) + " VND");
                        result = false;
                        break;
                    case 0:
                        result = false;
                        break;
                    default:
                        System.out.println("Please enter different numbers above");
                }
            } catch (Exception e){
                result = false;
                askCustormer();
            }
        }
    }
    static void showGasoline(List<Gasoline> gasolines){
        int numGasoline = 1;
        for (Gasoline gasoline: gasolines){
            System.out.println(numGasoline+". "+gasoline);
            numGasoline++;
        }
    }
    static void showPetroleum(List<Petroleum> petroleums){
        int numPetroleum = 1;
        for (Petroleum petroleum: petroleums){
            System.out.println(numPetroleum+". "+petroleum);
            numPetroleum++;
        }
    }
    public void showSwitchCaseGas(List<Gasoline> gasolines, int number){
        Invoice invoice = new Invoice();
        HashMap<Integer,Gasoline> gasolineHashMap = new HashMap<>();
        int numGasoline = 1;
        for (Gasoline gasoline: gasolines){
            System.out.println(numGasoline+". "+gasoline);
            gasolineHashMap.put(numGasoline,gasoline);
            numGasoline++;
        }
    }
    public void showSwitchCasePet(List<Petroleum> petroleums, int number){

    }
    static void choiceFormatReadFile(){
        Scanner sc = new Scanner(System.in);

        ReadCSV readCSV = new ReadCSV("./Commodity.csv");
        List<Commodity> commoditiesCSV = readCSV.readFileCommodity();

        ReadJson readJson = new ReadJson("./commodities.json");
        List<Commodity> commoditiesJSON = readJson.readFileCommodity();

        boolean result = true;
        while (result == true) {
            int numCommodity = 1;
            try {
                System.out.println("Format file:");
                System.out.println("1. .csv");
                System.out.println("2. .json");
                System.out.println("0. exit");
                System.out.println("What format do you want to use? Please enter number or name format (.csv or .json) you want!!!");
                String c = sc.nextLine();
                c = c.toLowerCase();
                switch (c) {
//                    case "1":
//                        solveReadFileCSV(numCommodity,commoditiesCSV);
//                        result = false;
//                        break;
//                    case "2":
//                        solveReadFileJSON(numCommodity,commoditiesJSON);
//                        result = false;
//                        break;
                    case ".csv":
                        solveReadFileCSV(numCommodity,commoditiesCSV);
                        result = false;
                        break;
                    case ".json":
                        solveReadFileJSON(numCommodity,commoditiesJSON);
                        result = false;
                        break;
                    case "0":
                        System.out.println("See you later!!!");
                        result = false;
                        break;
                    default:
                        System.out.println("Please enter number or name format (.csv or .json)!!!");
                }
            } catch (Exception e){
                result = false;
                choiceFormatReadFile();
            }
        }
    }
    static void solveReadFileCSV(int numCommodity,List<Commodity> commoditiesCSV){
        System.out.println("Result of read file .csv:");
        for(Commodity commodity: commoditiesCSV){
            System.out.println(numCommodity+". "+commodity);
            numCommodity++;
        }
        choiceContinue();
    }
    static void solveReadFileJSON(int numCommodity,List<Commodity> commoditiesJSON){
        System.out.println("Result of read file .json:");
        for(Commodity commodity: commoditiesJSON){
            System.out.println(numCommodity+". "+commodity);
            numCommodity++;
        }
        choiceContinue();
    }
    static void choiceContinue(){
        Scanner sc = new Scanner(System.in);
        boolean result = true;
        while (result == true) {
            try {
                System.out.println("You want to continue?");
                System.out.println("1. Continue");
                System.out.println("2. Exit");
                int c = sc.nextInt();
                switch (c) {
                    case 1:
                        choiceFormatReadFile();
                        result = false;
                        break;
                    case 2:
                        System.out.println("See you later!!!");
                        result = false;
                        break;
                    default:
                        System.out.println("Please enter one of numbers above!!!");
                }
            } catch (Exception e){
                result = false;
                choiceContinue();
            }
        }
    }

}
