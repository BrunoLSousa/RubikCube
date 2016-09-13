/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import report.ConvergenceGraphic;
import report.ReportValues;
import structure.GeneticAlgorithm;

/**
 *
 * @author bruno
 */
public class CrossoverMutationTests{

    private List<double[][]> historic;
//    private double crossover;
//    private double mutation;

//    variação da população de 500 até 2500.
//    variação da geração de 500 até 2500.
//    10 repetições para os testes
//    public CrossoverMutationTests(int lengthGeneration, double crossover, double mutation) {
    public CrossoverMutationTests(int lengthGeneration) {
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

//    public void teste(String[] args) {
//        BufferedReader buffRead = null;
//        try {
////            buffRead = new BufferedReader(new FileReader("semente.txt"));
//            String line = "";
//            int index = 0;
//            List<double[][]> historic = new ArrayList<>();
//            double[][] dataSet = new double[1000][4];
//            for (int i = 1; i <= 5; i++) {
//                buffRead = new BufferedReader(new FileReader("/home/bruno/NetBeansProjects/RubikCube/experiments/population_generation/report/Valores p1500 g1000 - " + i + ".txt"));
//                while (index < 1000) {
//                    if (line != null && !line.equals("")) {
//                        String[] split = line.split(";");
//                        dataSet[index][0] = Double.parseDouble(split[0]);
//                        dataSet[index][1] = Double.parseDouble(split[1]);
//                        dataSet[index][2] = Double.parseDouble(split[2]);
//                        dataSet[index][3] = Double.parseDouble(split[2]);
//                        index++;
//                    }
//                    line = buffRead.readLine();
//                }
//                historic.add(dataSet);
//            }
//            ConvergenceGraphic graphic = new ConvergenceGraphic();
////            String nameGraphic = "experiments/population_generation/grafic/Gráfico p" + 1500 + " g" + 1000 + " - " + (4 + 1);
//            String nameGraphic = "experiments/population_generation/grafic/Gráfico p" + 1500 + " g" + 1000 + " - media final";
//            graphic.generate(nameGraphic, 1000, dataSet);
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                buffRead.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//    }
//    @Override
//    public void run() {
//        try {
//            ConvergenceGraphic graphic = new ConvergenceGraphic();
//            ReportValues report = new ReportValues();
//            int repetition = 0;
//            while (repetition < 5) {
//                GeneticAlgorithm genetic = new GeneticAlgorithm();
//                genetic.PERCENTAGE_CROSSOVER = this.crossover;
//                genetic.PERCENTAGE_MUTATION = this.mutation;
//                genetic.evolve();
//                addHistoric(genetic.getDataSet());
//                String nameGraphic = "experiments/crossover_mutation/grafic/Gráfico c" + crossover + " m" + mutation + " - " + (repetition + 1);
//                graphic.generate(nameGraphic, GeneticAlgorithm.GENERATION, genetic.getDataSet());
//                String nameReport = "experiments/crossover_mutation/report/Valores c" + crossover + " m" + mutation + " - " + (repetition + 1);
//                report.generate(nameReport, GeneticAlgorithm.GENERATION, genetic.getDataSet());
//                repetition++;
//            }
//            double[][] dataSet = createMeanGeneral(GeneticAlgorithm.GENERATION);
//            String nameGraphic = "experiments/crossover_mutation/grafic/Gráfico c" + crossover + " m" + mutation + " - media final";
//            graphic.generate(nameGraphic, GeneticAlgorithm.GENERATION, dataSet);
//            String nameReport = "experiments/crossover_mutation/report/Valores c" + crossover + " m" + mutation + " - media final";
//            report.generate(nameReport, GeneticAlgorithm.GENERATION, dataSet);
//        } catch (IOException ex) {
//            Logger.getLogger(CrossoverMutationTests.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public static void main(String[] args) throws IOException {
//        ConvergenceGraphic graphic = new ConvergenceGraphic();
//        ReportValues report = new ReportValues();
//        double crossover = 0.9;
//        while (crossover >= 0.1) {
//            double mutation = 0.01;
//            while (mutation <= 0.51) {
//                CrossoverMutationTests tests = new CrossoverMutationTests(GeneticAlgorithm.GENERATION, crossover, mutation);
//                tests.start();
//                mutation += 0.05;
//            }
//            //gerar relatório final com a média dos melhores, a média do piores, a média total e a solução ótima.
//            crossover -= 0.1;
//        }

        ConvergenceGraphic graphic = new ConvergenceGraphic();
        ReportValues report = new ReportValues();
        CrossoverMutationTests tests = new CrossoverMutationTests(GeneticAlgorithm.GENERATION);
        double crossover = 0.1;
//        while (crossover >= 0.1) {
            double mutation = 0.5;
//            while (mutation <= 0.51) {
                int repetition = 0;
                while (repetition < 5) {
                    GeneticAlgorithm genetic = new GeneticAlgorithm(null);
//                    genetic.PERCENTAGE_CROSSOVER = crossover;
//                    genetic.PERCENTAGE_MUTATION = mutation;
                    genetic.evolve();
                    tests.addHistoric(genetic.getDataSet());
                    String nameGraphic = "experiments/crossover_mutation/grafic/Gráfico c" + crossover + " m" + mutation + " - " + (repetition + 1);
                    graphic.generate(nameGraphic, GeneticAlgorithm.GENERATION, genetic.getDataSet());
                    String nameReport = "experiments/crossover_mutation/report/Valores c" + crossover + " m" + mutation + " - " + (repetition + 1);
                    report.generate(nameReport, GeneticAlgorithm.GENERATION, genetic.getDataSet());
                    repetition++;
                }
                double[][] dataSet = tests.createMeanGeneral(GeneticAlgorithm.GENERATION);
                String nameGraphic = "experiments/crossover_mutation/grafic/Gráfico c" + crossover + " m" + mutation + " - media final";
                graphic.generate(nameGraphic, GeneticAlgorithm.GENERATION, dataSet);
                String nameReport = "experiments/crossover_mutation/report/Valores c" + crossover + " m" + mutation + " - media final";
                report.generate(nameReport, GeneticAlgorithm.GENERATION, dataSet);
//                mutation += 0.1;
//            }
            //gerar relatório final com a média dos melhores, a média do piores, a média total e a solução ótima.
//            crossover -= 0.2;
//        }
    }
}
