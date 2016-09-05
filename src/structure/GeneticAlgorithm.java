/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import structure.cube.movements.EnumMovement;

/**
 *
 * @author bruno
 */
public class GeneticAlgorithm {

    public static final int LENGTH_POPULATION = 10;
    public static final int LENGTH_CHROMOSOME = 50;
    public static final double PERCENTAGE_CROSSOVER = 0.9;
    public static final double PERCENTAGE_MUTATION = 0.05;
    public static final double PERCENTAGE_ELITISM = 0.1;
    public static final int LENGTH_TOURNAMENT = 2;

    protected Generation generation;

    public GeneticAlgorithm() {
        this.generation = new Generation(LENGTH_POPULATION, LENGTH_CHROMOSOME);
        this.generation.creatingInitialPopulation();
        this.generation.calculateFitness();
    }

    public void createNewGeneration() {
        Generation newGeneration = elitism();
        newGeneration = applyOperators(newGeneration);
        this.generation = newGeneration;
    }

    private Generation elitism() {
        int index = 0;
        Generation newGeneration = new Generation(LENGTH_POPULATION, LENGTH_CHROMOSOME);
        while (index < (LENGTH_POPULATION * PERCENTAGE_ELITISM)) {
            newGeneration.addChromosome(index, this.generation.getChromosomeByIndex(index));
            index++;
        }
        return newGeneration;
    }

    public Generation applyOperators(Generation newGeneration) {
        newGeneration = crossover(newGeneration);
        newGeneration = mutation(newGeneration);
        return newGeneration;
    }

    private Generation crossover(Generation newGeneration) {
        int index = (int) (LENGTH_POPULATION - (LENGTH_POPULATION * PERCENTAGE_CROSSOVER));
        while (index < LENGTH_POPULATION) {
            Chromosome[] tournament = tournament();
            Chromosome father = tournament[0];
            tournament = tournament();
            Chromosome mother = tournament[0];
            int limit = (int) (Math.random() * LENGTH_CHROMOSOME);
            EnumMovement[] child1 = new EnumMovement[LENGTH_CHROMOSOME];
            EnumMovement[] child2 = new EnumMovement[LENGTH_CHROMOSOME];
            for (int i = 0; i < limit; i++) {
                child1[i] = father.genotype[i];
                child2[i] = mother.genotype[i];
            }
            for (int i = limit; i < LENGTH_CHROMOSOME; i++) {
                child1[i] = mother.genotype[i];
                child2[i] = father.genotype[i];
            }
            newGeneration.addChromosome(index, new Chromosome(child1));
            index++;
            newGeneration.addChromosome(index, new Chromosome(child2));
            index++;
        }
        return newGeneration;
    }

    private Generation mutation(Generation newGeneration) {
        int index = (int) (LENGTH_POPULATION - (LENGTH_POPULATION * PERCENTAGE_CROSSOVER));
        while (index < LENGTH_POPULATION) {
            int chance = 0;
            for (int i = 0; i < LENGTH_CHROMOSOME; i++) {
                chance = 1 + (int) (Math.random() * 100);
                if (chance <= (PERCENTAGE_MUTATION * 100)) {
                    int indexMovement = new Random().nextInt(EnumMovement.values().length);
                    newGeneration.getChromosomeByIndex(i).genotype[i] = EnumMovement.values()[indexMovement];
                }
            }
        }
        return newGeneration;
    }

    private Chromosome[] tournament() {
        Chromosome[] tournament = new Chromosome[LENGTH_TOURNAMENT];
        for (int i = 0; i < LENGTH_TOURNAMENT; i++) {
            int index = (int) (Math.random() * LENGTH_POPULATION);
            tournament[i] = generation.getChromosomeByIndex(index);
        }
        List<Chromosome> c = Arrays.asList(tournament);
        Collections.sort(c, Collections.reverseOrder());
        return (Chromosome[]) c.toArray();
    }

}
