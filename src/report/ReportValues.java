/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author bruno
 */
public class ReportValues {

    public ReportValues() {
        
    }
    
    public void generate(String name, int generation, double[][] dataSet) throws IOException{
        generateReports(name, generation, dataSet);
    }    

    private void generateReports(String name, int generation, double[][] dataSet) throws IOException {
        FileWriter arq = new FileWriter(name + ".txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        for (int p = 0; p < generation; p++) {
            String line = String.valueOf(dataSet[p][0]) + ";" + String.valueOf(dataSet[p][1] + ";" + String.valueOf(dataSet[p][2]));
            gravarArq.printf("%s\n",line);
        }
        arq.close();
    }
    
}
