package org.example;

public class Gasoline extends Commodity{
    String csvFile = "/Users/admin/IdeaProjects/commodity-management/Commodity.csv";
    String line = "";
    String csvSplitBy = ",";
    private String nameGas;
    private double volumeGasAvailable;

    public Gasoline(String typeCommodity, String nameGas, double volumeGasAvailable) {
        super(typeCommodity);
        this.nameGas = nameGas;
        this.volumeGasAvailable = volumeGasAvailable;
    }

    public Gasoline(String nameGas, double unitPrice,  double volumeGasAvailable) {
        super(unitPrice);
        this.nameGas = nameGas;
        this.volumeGasAvailable = volumeGasAvailable;
    }

    public Gasoline(String nameGas, double volumeGasAvailable) {
        this.nameGas = nameGas;
        this.volumeGasAvailable = volumeGasAvailable;
    }

    public String getNameGas() {
        return nameGas;
    }

    public void setNameGas(String nameGas) {
        this.nameGas = nameGas;
    }

    public double getVolumeGasAvailable() {
        return volumeGasAvailable;
    }

    public void setVolumeGasAvailable(double volumeGasAvailable) {
        this.volumeGasAvailable = volumeGasAvailable;
    }
//    public List<Commodity> ReadFileCSV() throws IOException {
//        String fileCSV = this.csvFile;
//        List<Gasoline> gaoSoLine = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(fileCSV))) {
//            String[] values;
//            while ((line = br.readLine()) != null) {
//                values = line.split(csvSplitBy);
//                for (String i : values) {
//                    System.out.println(i);
//                    gaoSoLine cm = new gaoSoLine(i);
//                    gaoSoLine.add(cm);
//                }
//            }
////                   System.out.println("Value 1: " + values[0] + " Value 2: " + values[1]);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return gaoSoLine;
//    }
    @Override
    public String toString() {
        return "Gasoline{" +
                "nameGas='" + nameGas + '\'' +
                ", volumeGasAvailable=" + volumeGasAvailable +
                '}';
    }
}