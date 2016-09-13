/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import report.ConvergenceGraphic;
import report.ReportValues;
import structure.GeneticAlgorithm;

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

    public static void main(String[] args) throws IOException {
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
            population += 500;
        }
    }

}
