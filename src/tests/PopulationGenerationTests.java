/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import report.ConvergenceGraphic;
import report.ReportValues;
import structure.Chromosome;
import structure.Generation;
import structure.GeneticAlgorithm;
import structure.cube.movements.EnumCompositeMovement;

/**
 *
 * @author bruno
 */
public class PopulationGenerationTests {

    private List<double[][]> historic;

//    variação da população de 500 até 2500.
//    variação da geração de 500 até 2500.
//    10 repetições para os testes
    public PopulationGenerationTests(int lengthGeneration) {
        this.historic = new ArrayList<>();
    }

    public void addHistoric(double[][] dataSet) {
        this.historic.add(dataSet);
    }

    public double[][] createMeanGeneral(int generation) {
        double[][] dataSet = new double[generation][4];
        for (double[][] value : this.historic) {
            for (int i = 0; i < generation; i++) {
                dataSet[i][0] += value[i][0];
                dataSet[i][1] += value[i][1];
                dataSet[i][2] += value[i][2];
                dataSet[i][3] += value[i][3];
            }
        }

        for (int i = 0; i < generation; i++) {
            dataSet[i][0] = dataSet[i][0] / 5;
            dataSet[i][1] = dataSet[i][1] / 5;
            dataSet[i][2] = dataSet[i][2] / 5;
            dataSet[i][3] = dataSet[i][3] / 5;
        }
        return dataSet;
    }

    public static void main(String[] args) {
        BufferedReader buffRead = null;
        try {
//            buffRead = new BufferedReader(new FileReader("semente.txt"));
            String line = "";
            int index = 0;
            List<double[][]> historic = new ArrayList<>();
            double[][] dataSet = new double[1000][4];
            for (int i = 1; i <= 5; i++) {
                buffRead = new BufferedReader(new FileReader("/home/bruno/NetBeansProjects/RubikCube/experiments/population_generation/report/Valores p2000 g1000 - " + i + ".txt"));
                while (index < 1000) {
                    if (line != null && !line.equals("")) {
                        String[] split = line.split(";");
                        dataSet[index][0] = Double.parseDouble(split[0]);
                        dataSet[index][1] = Double.parseDouble(split[1]);
                        dataSet[index][2] = Double.parseDouble(split[2]);
                        dataSet[index][3] = Double.parseDouble(split[2]);
                        index++;
                    }
                    line = buffRead.readLine();
                }
                historic.add(dataSet);
            }
            ConvergenceGraphic graphic = new ConvergenceGraphic();
            ReportValues report = new ReportValues();
//            String nameGraphic = "experiments/population_generation/grafic/Gráfico p" + 1500 + " g" + 1000 + " - " + (4 + 1);
//            String nameGraphic = "experiments/population_generation/grafic/Gráfico p" + 2000 + " g" + 1000 + " - media final";
//            graphic.generate(nameGraphic, 1000, dataSet);
            String nameReport = "experiments/population_generation/report/Valores p" + 2000 + " g" + 1000 + " - media final";
            report.generate(nameReport, 1000, dataSet);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffRead.close();
            } catch (IOException ex) {
                Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void teste(String[] args) throws IOException {
        ConvergenceGraphic graphic = new ConvergenceGraphic();
        ReportValues report = new ReportValues();
        int population = 2000;
        while (population <= 2000) {
            int generation = 500;
            PopulationGenerationTests tests = new PopulationGenerationTests(generation);
            while (generation <= 1000) {
                int repetition = 0;
                while (repetition < 5) {
                    GeneticAlgorithm genetic = new GeneticAlgorithm(population, generation, null);
//                    genetic.LENGTH_POPULATION = population;
//                    genetic.GENERATION = generation;
                    genetic.evolve();
                    tests.addHistoric(genetic.getDataSet());
                    String nameGraphic = "experiments/population_generation/grafic/Gráfico p" + population + " g" + generation + " - " + (repetition + 1);
                    graphic.generate(nameGraphic, generation, genetic.getDataSet());
                    String nameReport = "experiments/population_generation/report/Valores p" + population + " g" + generation + " - " + (repetition + 1);
                    report.generate(nameReport, generation, genetic.getDataSet());
                    repetition++;
                }
                double[][] dataSet = tests.createMeanGeneral(generation);
                String nameGraphic = "experiments/population_generation/grafic/Gráfico p" + population + " g" + generation + " - media final";
                graphic.generate(nameGraphic, generation, dataSet);
                String nameReport = "experiments/population_generation/report/Valores p" + population + " g" + generation + " - media final";
                report.generate(nameReport, generation, dataSet);
                generation += 500;
            }
            //gerar relatório final com a média dos melhores, a média do piores, a média total e a solução ótima.
            population += 500;
        }
    }

}
