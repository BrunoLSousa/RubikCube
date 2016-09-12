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
import structure.cube.movements.composite.EnumCompositeMovement;
import structure.cube.movements.primary.EnumPrimaryMovement;

/**
 *
 * @author bruno
 */
public class GeneticAlgorithm {

    public static final int LENGTH_POPULATION = 5000;
    public static final int LENGTH_CHROMOSOME = 30;
    public static final double PERCENTAGE_CROSSOVER = 0.90;
    public static final double PERCENTAGE_MUTATION = 0.15;
    //melhor crossover 0,3, mutação 0,5 e uniforme mutação 0,3. -> valor fitness = 170.
    public static final double PERCENTAGE_UNIFORM_MUTATION = 0.15;
    public static final int ELITISM = 1;
    public static final int LENGTH_TOURNAMENT = 10;

    protected Generation generation;

    public GeneticAlgorithm() {
        this.generation = new Generation(LENGTH_POPULATION, LENGTH_CHROMOSOME);
        this.generation.creatingInitialPopulation();
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

    public Chromosome returnInferiorChromosome() {
        return this.generation.getChromosomeByIndex(LENGTH_POPULATION - 1);
    }

    private Generation elitism() {
        Generation newGeneration = new Generation(LENGTH_POPULATION, LENGTH_CHROMOSOME);
        newGeneration.addChromosome(0, new Chromosome(this.generation.getChromosomeByIndex(0).genotype));
        return newGeneration;
    }

    private Generation applyOperators(Generation newGeneration) {
        newGeneration = crossover(newGeneration);
        newGeneration = mutation(newGeneration);
        return newGeneration;
    }

    private Generation crossover(Generation newGeneration) {
        int index = ELITISM;
        while (index < LENGTH_POPULATION) {
            Chromosome[] tournament = tournament();
            Chromosome father = tournament[0];
            tournament = tournament();
            Chromosome mother = tournament[0];
            EnumCompositeMovement[][] children = exchange(father, mother);
//            EnumPrimaryMovement[][] children = exchange(father, mother);
            for (int i = 0; i < children.length; i++) {
                if (index < LENGTH_POPULATION) {
                    newGeneration.addChromosome(index, new Chromosome(children[1]));
                    index++;
                }else{
                    break;
                }
            }
//            newGeneration.addChromosome(index, new Chromosome(children[0]));
//            index++;

        }
        return newGeneration;
    }

    private EnumCompositeMovement[][] exchange(Chromosome father, Chromosome mother) {
//    private EnumPrimaryMovement[][] exchange(Chromosome father, Chromosome mother) {
        EnumCompositeMovement[][] genotypes;
//        EnumPrimaryMovement[][] genotypes = new EnumPrimaryMovement[2][LENGTH_CHROMOSOME];
        int chance = (int) (Math.random() * 100);
        if (chance <= (PERCENTAGE_CROSSOVER * 100)) {
            genotypes = new EnumCompositeMovement[4][LENGTH_CHROMOSOME];
//            genotypes = new EnumPrimaryMovement[4][LENGTH_CHROMOSOME];
            int limit = (int) (Math.random() * LENGTH_CHROMOSOME);
            for (int i = 0; i < limit; i++) {
                genotypes[0][i] = father.genotype[i];
                genotypes[1][i] = mother.genotype[i];
                genotypes[2][i] = father.genotype[i];
                genotypes[3][i] = mother.genotype[i];
            }
            for (int i = limit; i < LENGTH_CHROMOSOME; i++) {
                genotypes[0][i] = father.genotype[i];
                genotypes[1][i] = mother.genotype[i];
                genotypes[3][i] = mother.genotype[i];
                genotypes[2][i] = father.genotype[i];
            }
        } else {
            genotypes = new EnumCompositeMovement[2][LENGTH_CHROMOSOME];
//            genotypes = new EnumPrimaryMovement[2][LENGTH_CHROMOSOME];
            for (int i = 0; i < LENGTH_CHROMOSOME; i++) {
                genotypes[0][i] = father.genotype[i];
                genotypes[1][i] = mother.genotype[i];
            }
        }
        return genotypes;
    }

    private Generation mutation(Generation newGeneration) {
        int index = ELITISM;
        while (index < LENGTH_POPULATION) {
            int chance = 1 + (int) (Math.random() * 100);
            if (chance <= (PERCENTAGE_MUTATION * 100)) {
                for (int i = 0; i < LENGTH_CHROMOSOME; i++) {
                    chance = 1 + (int) (Math.random() * 100);
                    if (chance <= (PERCENTAGE_UNIFORM_MUTATION * 100)) {
//                    if (chance <= (PERCENTAGE_MUTATION * 100)) {
//                        int indexMovement = new Random().nextInt(EnumCompositeMovement.values().length);
//                        newGeneration.getChromosomeByIndex(index).genotype[i] = EnumCompositeMovement.values()[indexMovement];
//                            int indexMovement = new Random().nextInt(EnumPrimaryMovement.values().length);
//                        newGeneration.getChromosomeByIndex(index).genotype[i] = EnumPrimaryMovement.values()[indexMovement];

                        int indexMovement = -1;
                        do {
                            indexMovement = new Random().nextInt(EnumCompositeMovement.values().length);
                        } while (EnumCompositeMovement.values()[indexMovement] == newGeneration.getChromosomeByIndex(index).genotype[i]);
                        newGeneration.getChromosomeByIndex(index).genotype[i] = EnumCompositeMovement.values()[indexMovement];
//                        } while (EnumPrimaryMovement.values()[indexMovement] == newGeneration.getChromosomeByIndex(index).genotype[i]);
//                        newGeneration.getChromosomeByIndex(index).genotype[i] = EnumPrimaryMovement.values()[indexMovement];
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
            if (index == 0) {
                int a = 0;
            }
            tournament[i] = generation.getChromosomeByIndex(index);
        }
        List<Chromosome> c = Arrays.asList(tournament);
        Collections.sort(c, Collections.reverseOrder());
        return (Chromosome[]) c.toArray();
    }

}
