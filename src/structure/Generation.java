/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Generation {
    
    private Chromosome[] population;
    private int lengthChromosome;
    
    public Generation(int lengthPopulation, int lengthChromosome){
        this.population = new Chromosome[lengthPopulation];
        this.lengthChromosome = lengthChromosome;
    }
    
    public void creatingInitialPopulation(){
        for(int index=0; index < this.population.length; index++){
            Chromosome chromosome = new Chromosome(this.lengthChromosome);
            chromosome.initializeGenotype();
            this.population[index] = chromosome;
        }
    }
    
    public void addChromosome(int index, Chromosome chromosome){
        this.population[index] = chromosome;
    }
    
    public void showGeneration(){
        for (Chromosome chromosome : this.population) {
            chromosome.showChromosome();
            System.out.println();
        }
    }
    
    public void calculateFitness(){
        for (Chromosome chromosome : this.population) {
            chromosome.applyMovement();
        }
        List<Chromosome> c = Arrays.asList(this.population);
        Collections.sort(c, Collections.reverseOrder());
        this.population = (Chromosome[]) c.toArray();
    }
    
    public Chromosome getChromosomeByIndex(int index){
        return this.population[index];
    }
    
    public Chromosome[] getChromosomes(){
        return this.population;
    }
    
//    public void avaiableChromossome(){
//        int sum = -1;
//        int indexBest = -1;
//        for(int indexChromosome = 0; indexChromosome < this.population.length; indexChromosome++){
//            this.population[indexChromosome].applyMovement();
//            if(sum == -1 || sum < this.population[indexChromosome].bestFitness){
//                sum = this.population[indexChromosome].bestFitness;
//                indexBest = indexChromosome;
//            }
//            this.population[indexChromosome].showChromosome();
//        }
//        System.out.println("\n\n\nMelhor Fitness: " + this.population[indexBest].bestFitness);
//        System.out.println("\n\n\nÍndice do Cromossomo: " + indexBest);
//        System.out.println("\n\n\nÍndice Final do Gene: " + this.population[indexBest].indexBestFitness);
//        this.population[indexBest].showChromosome();
//        this.population[indexBest].getPhenotype().printCube();
//    }
    
}
