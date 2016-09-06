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

    public static final int LENGTH_POPULATION = 500;
    public static final int LENGTH_CHROMOSOME = 20;
    public static final double PERCENTAGE_CROSSOVER = 0.7;
    public static final double PERCENTAGE_MUTATION = 0.1;
    public static final double PERCENTAGE_UNIFORM_MUTATION = 0.3;
    public static final int LENGTH_TOURNAMENT = 2;

    protected Generation generation;

    public GeneticAlgorithm() {
        this.generation = new Generation(LENGTH_POPULATION, LENGTH_CHROMOSOME);
        this.generation.creatingInitialPopulation();
//        this.generation.calculateFitness();
    }

    public void createNewGeneration() {
        Generation newGeneration = elitism();
        newGeneration = applyOperators(newGeneration);
        this.generation = newGeneration;
    }

    public Generation getGeneration() {
        return this.generation;
    }

    public Chromosome returnBestChromosome() {
        return this.generation.getChromosomeByIndex(0);
    }

    private Generation elitism() {
        Generation newGeneration = new Generation(LENGTH_POPULATION, LENGTH_CHROMOSOME);
        newGeneration.addChromosome(0, this.generation.getChromosomeByIndex(0));
        newGeneration.getChromosomeByIndex(0).resetPhenotype();
        return newGeneration;
    }

    private Generation applyOperators(Generation newGeneration) {
        newGeneration = crossover(newGeneration);
        newGeneration = mutation(newGeneration);
        return newGeneration;
    }

    private Generation crossover(Generation newGeneration) {
        int index = 1;
        while (index < LENGTH_POPULATION) {
            Chromosome[] tournament = tournament();
            Chromosome father = tournament[0];
            tournament = tournament();
            Chromosome mother = tournament[0];
            EnumMovement[][] children = exchange(father, mother);
            newGeneration.addChromosome(index, new Chromosome(children[0]));
            index++;
            if (index < LENGTH_POPULATION) {
                newGeneration.addChromosome(index, new Chromosome(children[1]));
                index++;
            }
        }
        return newGeneration;
    }

    private EnumMovement[][] exchange(Chromosome father, Chromosome mother) {
        EnumMovement[][] genotypes = new EnumMovement[2][LENGTH_CHROMOSOME];
        int chance = (int) (Math.random() * 100);
        if (chance < (PERCENTAGE_CROSSOVER * 100)) {
            int limit = (int) (Math.random() * LENGTH_CHROMOSOME);
            for (int i = 0; i < limit; i++) {
                genotypes[0][i] = father.genotype[i];
                genotypes[1][i] = mother.genotype[i];
            }
            for (int i = limit; i < LENGTH_CHROMOSOME; i++) {
                genotypes[0][i] = mother.genotype[i];
                genotypes[1][i] = father.genotype[i];
            }
        } else {
            genotypes[0] = father.genotype;
            genotypes[1] = mother.genotype;
        }
        return genotypes;
    }

    private Generation mutation(Generation newGeneration) {
        int index = 1;
        while (index < LENGTH_POPULATION) {
            int chance = 1 + (int) (Math.random() * 100);
            if (chance < (PERCENTAGE_MUTATION * 100)) {
                for (int i = 0; i < LENGTH_CHROMOSOME; i++) {
                    chance = 1 + (int) (Math.random() * 100);
                    if (chance <= (PERCENTAGE_UNIFORM_MUTATION * 100)) {
                        int indexMovement = new Random().nextInt(EnumMovement.values().length);
                        newGeneration.getChromosomeByIndex(index).genotype[i] = EnumMovement.values()[indexMovement];
                    }
                }
            }
            index++;
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
