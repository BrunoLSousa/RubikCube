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
public class Tournament {

    private List<double[][]> historic;
//    private double crossover;
//    private double mutation;

//    variação da população de 500 até 2500.
//    variação da geração de 500 até 2500.
//    10 repetições para os testes
//    public CrossoverMutationTests(int lengthGeneration, double crossover, double mutation) {
    public Tournament(int lengthGeneration) {
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
        CrossoverMutationTests tests = new CrossoverMutationTests(GeneticAlgorithm.GENERATION);
        int tournament = 10;
//            while (mutation <= 0.51) {
        int repetition = 0;
        while (repetition < 5) {
            GeneticAlgorithm genetic = new GeneticAlgorithm(null);
//            genetic.LENGTH_TOURNAMENT = tournament;
            genetic.evolve();
            tests.addHistoric(genetic.getDataSet());
            String nameGraphic = "experiments/tournament/graphic/Gráfico t" + tournament + " - " + (repetition + 1);
            graphic.generate(nameGraphic, GeneticAlgorithm.GENERATION, genetic.getDataSet());
            String nameReport = "experiments/tournament/report/Valores t" + tournament + " - " + (repetition + 1);
            report.generate(nameReport, GeneticAlgorithm.GENERATION, genetic.getDataSet());
            repetition++;
        }
        double[][] dataSet = tests.createMeanGeneral(GeneticAlgorithm.GENERATION);
        String nameGraphic = "experiments/tournament/graphic/Gráfico t" + tournament + " - media final";
        graphic.generate(nameGraphic, GeneticAlgorithm.GENERATION, dataSet);
        String nameReport = "experiments/tournament/report/Valores t" + tournament + " - media final";
        report.generate(nameReport, GeneticAlgorithm.GENERATION, dataSet);
//                mutation += 0.1;
//            }
        //gerar relatório final com a média dos melhores, a média do piores, a média total e a solução ótima.
//            crossover -= 0.2;

    }
}
