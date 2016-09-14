/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.Random;
import structure.cube.Cube;
import structure.cube.movements.MediatorBuilder;
import structure.cube.movements.EnumCompositeMovement;

/**
 *
 * @author bruno
 */
public class Chromosome implements Comparable<Chromosome> {

    protected EnumCompositeMovement[] genotype;
    private Cube phenotype;
    private MediatorBuilder mediatorBuilder;
    private int valueFitness;

    public Chromosome(int lengthGenotype, Cube cube) {
        this.phenotype = new Cube(cube);
        this.genotype = new EnumCompositeMovement[lengthGenotype];
        this.mediatorBuilder = new MediatorBuilder();
        this.mediatorBuilder.createMediator();
        this.valueFitness = -1;
    }

    public Chromosome(EnumCompositeMovement[] genotype, Cube cube) {
        this.phenotype = new Cube(cube);
        this.genotype = genotype;
        this.mediatorBuilder = new MediatorBuilder();
        this.mediatorBuilder.createMediator();
        this.valueFitness = -1;
    }

    //método responsável por iniciar o genótipo de um cromossomo de forma aleatória
    public void initializeGenotype() {
        for (int index = 0; index < this.genotype.length; index++) {
            int indexMovement = new Random().nextInt(EnumCompositeMovement.values().length);
            this.genotype[index] = EnumCompositeMovement.values()[indexMovement];
        }
    }

    public Cube getPhenotype() {
        return this.phenotype;
    }

    protected void showChromosome() {
        for (int index = 0; index < this.genotype.length; index++) {
            System.out.print(this.genotype[index] + " ");
        }
    }

    public int getValueFitness() {
        return this.valueFitness;
    }

    //método responsável por aplicar no fenótipo a sequência de movimentos armazenada no genótipo. 
    //Além disso esse método calcula a fitness assim que acaba de aplicar os movimentos.
    protected void applyMovement() {
        int i = 0;
        for (EnumCompositeMovement gene : this.genotype) {
            this.phenotype = this.mediatorBuilder.getMediator().doMoviment(gene, this.phenotype);
        }
        Fitness fitness = new Fitness(this);
        this.valueFitness = fitness.calculateFitness();
    }

    @Override
    public int compareTo(Chromosome c) {
        if (valueFitness > c.getValueFitness()) {
            return -1;
        }
        if (valueFitness < c.getValueFitness()) {
            return 1;
        }
        return 0;
    }

    public void printInformation() {
        System.out.println("Sequence of movements:");
        for (int index = 0; index < this.genotype.length; index++) {
            System.out.print(this.genotype[index].toString() + " ");
        }
        System.out.println("\n");

        System.out.println("Cube's Configuration :");
        this.phenotype.printCube();
    }

    public void printGenotype() {
        System.out.println("Chromosome:");
        for (int index = 0; index < this.genotype.length; index++) {
            System.out.print(this.genotype[index].toString() + " ");
        }
    }

    public void printFitness(int generation) {
        System.out.println("Geração " + (generation + 1) + " - Fitness: " + this.valueFitness + "\n");
    }

}
