/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import structure.cube.movements.MediatorBuilder;

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
    
    public void showGeneration(){
        for(int index=0; index < this.population.length; index++){
            this.population[index].showChromosome();
            System.out.println();
        }
    }
    
    public void calculateFitness(){
        for(int indexChromosome = 0; indexChromosome < this.population.length; indexChromosome++){
            this.population[indexChromosome].applyMovement();
        }
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
