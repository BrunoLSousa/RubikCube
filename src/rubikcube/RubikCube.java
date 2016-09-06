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
//        Generation generation = new Generation(10, 50);
//        generation.creatingInitialPopulation();
//        generation.showGeneration();
//        System.out.println("\n");
//        generation.calculateFitness();
//        double rate = 0.05;
//        for (int i = 0; i < 20; i++) {
//            System.out.print("0 ");
//        }
//        System.out.println();
//        int chance = 0;
//        for (int i = 0; i < 20; i++) {
//            chance = 1 + (int) (Math.random() * 100);
//            if (chance <= (rate*100)) {
//                System.out.print("1 ");
//            } else {
//                System.out.print("0 ");
//            }
//        }
//        System.out.println(num);
//        GeneticAlgorithm genetic = new GeneticAlgorithm();
//        genetic.createNewGeneration();
        int totalGeneration = 1000;
        GeneticAlgorithm genetic = new GeneticAlgorithm();
        int generation = 0;
        while (generation < totalGeneration) {
            genetic.getGeneration().calculateFitness();
            Chromosome chromosome = genetic.returnBestChromosome();
            chromosome.printFitness(generation);
            genetic.createNewGeneration();
            generation++;
        }
        genetic.getGeneration().calculateFitness();
        Chromosome chromosome = genetic.returnBestChromosome();
        
        chromosome.printInformation();
    }

}
