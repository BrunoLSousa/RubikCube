/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import structure.cube.Cube;
import structure.cube.Face;
import structure.cube.movements.EnumCompositeMovement;

/**
 *
 * @author bruno
 */
public class GeneticAlgorithm {

    public static final int GENERATION = 1000;
    public static final int LENGTH_POPULATION = 1500;
    public static final int LENGTH_CHROMOSOME = 20;
    public static final double PERCENTAGE_CROSSOVER = 0.30;
    public static final double PERCENTAGE_MUTATION = 0.15;
    public static final double PERCENTAGE_UNIFORM_MUTATION = 0.15;
    public static final int ELITISM = 1;
    public static final int LENGTH_TOURNAMENT = 3;

    protected Generation generation;
    private double[][] dataSet;
    private Cube cube;

    public GeneticAlgorithm(HashMap<Face, String[][]> cube) {
        this.generation = new Generation(LENGTH_POPULATION, LENGTH_CHROMOSOME);
        this.cube = new Cube(cube);
        this.generation.creatingInitialPopulation(this.cube);
    }

    public GeneticAlgorithm(int lengthPopulation, int lengthGeracao, HashMap<Face, String[][]> cube) {
        this.generation = new Generation(LENGTH_POPULATION, LENGTH_CHROMOSOME);
        this.cube = new Cube(cube);
        this.generation.creatingInitialPopulation(this.cube);
    }

    //método responsável por criar uma nova população.
    public void createNewGeneration() {
        Generation newGeneration = elitism();
        newGeneration = applyOperators(newGeneration);
        this.generation = newGeneration;
    }

    public Generation getGeneration() {
        return this.generation;
    }

    //return o cromossomo de melhor fitness.
    public Chromosome returnBestChromosome() {
        return this.generation.getChromosomeByIndex(0);
    }

    public Chromosome returnInferiorChromosome() {
        return this.generation.getChromosomeByIndex(LENGTH_POPULATION - 1);
    }

    //método responsável por selecionar o melho indivíduo da população antiga para a nova população.
    private Generation elitism() {
        Generation newGeneration = new Generation(LENGTH_POPULATION, LENGTH_CHROMOSOME);
        newGeneration.addChromosome(0, new Chromosome(this.generation.getChromosomeByIndex(0).genotype, this.cube));
        return newGeneration;
    }

    //método responsável por aplicar mutação e cruzamento no indíviduos de uma população, a fim de criar uma nova.
    private Generation applyOperators(Generation newGeneration) {
        newGeneration = crossover(newGeneration);
        newGeneration = mutation(newGeneration);
        return newGeneration;
    }

    //método responsável por fazer o cruzamento de dois indivíduos.
    private Generation crossover(Generation newGeneration) {
        int index = ELITISM;
        while (index < LENGTH_POPULATION) {
            Chromosome[] tournament = tournament();
            Chromosome father = tournament[0];
            tournament = tournament();
            Chromosome mother = tournament[0];
            EnumCompositeMovement[][] children = exchange(father, mother);
            for (int i = 0; i < children.length; i++) {
                if (index < LENGTH_POPULATION) {
                    newGeneration.addChromosome(index, new Chromosome(children[1], this.cube));
                    index++;
                } else {
                    break;
                }
            }

        }
        return newGeneration;
    }

    private EnumCompositeMovement[][] exchange(Chromosome father, Chromosome mother) {
        EnumCompositeMovement[][] genotypes;
        int chance = (int) (Math.random() * 100);
        if (chance <= (PERCENTAGE_CROSSOVER * 100)) {
            genotypes = new EnumCompositeMovement[4][LENGTH_CHROMOSOME];
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
            for (int i = 0; i < LENGTH_CHROMOSOME; i++) {
                genotypes[0][i] = father.genotype[i];
                genotypes[1][i] = mother.genotype[i];
            }
        }
        return genotypes;
    }

    //método responsável por fazer a mutação em um indivíduo.
    private Generation mutation(Generation newGeneration) {
        int index = ELITISM;
        while (index < LENGTH_POPULATION) {
            int chance = 1 + (int) (Math.random() * 100);
            if (chance <= (PERCENTAGE_MUTATION * 100)) {
                for (int i = 0; i < LENGTH_CHROMOSOME; i++) {
                    chance = 1 + (int) (Math.random() * 100);
                    if (chance <= (PERCENTAGE_UNIFORM_MUTATION * 100)) {
                        int indexMovement = -1;
                        do {
                            indexMovement = new Random().nextInt(EnumCompositeMovement.values().length);
                        } while (EnumCompositeMovement.values()[indexMovement] == newGeneration.getChromosomeByIndex(index).genotype[i]);
                        newGeneration.getChromosomeByIndex(index).genotype[i] = EnumCompositeMovement.values()[indexMovement];
                    }

                }
            }
            index++;
        }
        return newGeneration;
    }

    //método responsável por fazer o torneio e selecionar indivíduos que poderão ser cruzados.
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

    //método responsável gerenciar os acontecimentos das gerações.
    public void evolve() {
        int generation = 0;
        this.dataSet = new double[GENERATION][4];
        while (generation < GENERATION) {
            this.generation.calculateFitness();
            Chromosome chromosome = returnBestChromosome();
            chromosome.printFitness(generation);
            dataSet[generation][0] = returnBestChromosome().getValueFitness();
            dataSet[generation][1] = returnInferiorChromosome().getValueFitness();
            dataSet[generation][2] = (dataSet[generation][0] + dataSet[generation][1]) / 2;
            createNewGeneration();
            generation++;
        }
        this.generation.calculateFitness();
    }

    public double[][] getDataSet() {
        return this.dataSet;
    }

}
