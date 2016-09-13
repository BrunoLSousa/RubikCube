/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import structure.cube.Cube;

/**
 *
 * @author bruno
 */
public class Generation {

    private Chromosome[] population;
    private int lengthChromosome;

    public Generation(int lengthPopulation, int lengthChromosome) {
        this.population = new Chromosome[lengthPopulation];
        this.lengthChromosome = lengthChromosome;
    }

    public void creatingInitialPopulation(Cube cube) {
        for (int index = 0; index < this.population.length; index++) {
            Chromosome chromosome = new Chromosome(this.lengthChromosome, cube);
            chromosome.initializeGenotype();
            this.population[index] = chromosome;
        }
    }

    public void addChromosome(int index, Chromosome chromosome) {
        this.population[index] = chromosome;
    }

    public void showGeneration() {
        for (Chromosome chromosome : this.population) {
            chromosome.showChromosome();
            System.out.println();
        }
    }
    
    //método responsável por aplicar os movimentos no fenótipo.
    public void calculateFitness() {
        for (Chromosome chromosome : this.population) {
            chromosome.applyMovement();
        }
        List<Chromosome> c = Arrays.asList(this.population);
        Collections.sort(c, Collections.reverseOrder());
        this.population = (Chromosome[]) c.toArray();
    }

    public Chromosome getChromosomeByIndex(int index) {
        return this.population[index];
    }

    public Chromosome[] getChromosomes() {
        return this.population;
    }

}
