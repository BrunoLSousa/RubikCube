/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

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
    
}
