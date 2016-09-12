/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikcube;

import structure.Chromosome;
import structure.GeneticAlgorithm;

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
        int totalGeneration = 1000;
        GeneticAlgorithm genetic = new GeneticAlgorithm();
        int generation = 0;
        double[][] dataSet = new double[totalGeneration][4];
        while (generation < totalGeneration) {
            genetic.getGeneration().calculateFitness();
            Chromosome chromosome = genetic.returnBestChromosome();
//            System.out.println("Geração "+ generation);
//            chromosome.printInformation();
            chromosome.printFitness(generation);
//            chromosome.printGenotype();
            dataSet[generation][0] = genetic.returnBestChromosome().getValueFitness();
            dataSet[generation][1] = genetic.returnInferiorChromosome().getValueFitness();
            dataSet[generation][2] = (dataSet[generation][0] + dataSet[generation][1]) / 2;
//            dataSet[generation][3] = Math.sqrt(((dataSet[generation][0] - dataSet[generation][2]) * (dataSet[generation][0] - dataSet[generation][2])) + ((dataSet[generation][1] - dataSet[generation][2]) * (dataSet[generation][1] - dataSet[generation][2])));
            genetic.createNewGeneration();
            generation++;
        }
        LineChartDemo6 demo = new LineChartDemo6("Gráfico", dataSet, generation);
        demo.print(demo);
        genetic.getGeneration().calculateFitness();
        Chromosome chromosome = genetic.returnBestChromosome();

        chromosome.printInformation();

        System.out.println("Total de Gerações: " + generation);
    }

}
