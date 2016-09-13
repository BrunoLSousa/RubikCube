/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikcube;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import report.ConvergenceGraphic;
import report.ReportValues;
import structure.Chromosome;
import structure.GeneticAlgorithm;
import structure.cube.Face;

/**
 *
 * @author bruno
 */
public class RubikCube {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Scanner scanner = new Scanner();
            HashMap<Face, String[][]> cube = scanner.scan();
            GeneticAlgorithm genetic = new GeneticAlgorithm(cube);
            genetic.evolve();
            ConvergenceGraphic graphic = new ConvergenceGraphic();
            ReportValues report = new ReportValues();
            String nameGraphic = "Gráfico de Convergência da solução";
            graphic.generate(nameGraphic, GeneticAlgorithm.GENERATION, genetic.getDataSet());
            String nameReport = "Valores do melhor indivíduo em cada geração";
            report.generate(nameReport, GeneticAlgorithm.GENERATION, genetic.getDataSet());
            Chromosome chromosome = genetic.returnBestChromosome();

            chromosome.printInformation();
        } catch (IOException ex) {
            Logger.getLogger(RubikCube.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
