/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.Random;
import structure.cube.Cube;
import structure.cube.movements.EnumMovement;
import structure.cube.movements.MediatorBuilder;

/**
 *
 * @author bruno
 */
public class Chromosome implements Comparable<Chromosome> {

    protected EnumMovement[] genotype;
    private Cube phenotype;
    private MediatorBuilder mediatorBuilder;
    private int valueFitness;

    public Chromosome(int lengthGenotype) {
        this.phenotype = new Cube();
        this.genotype = new EnumMovement[lengthGenotype];
        this.mediatorBuilder = new MediatorBuilder();
        this.mediatorBuilder.createMediator();
        this.valueFitness = -1;
    }

    public Chromosome(EnumMovement[] genotype) {
        this.phenotype = new Cube();
        this.genotype = genotype;
        this.mediatorBuilder = new MediatorBuilder();
        this.mediatorBuilder.createMediator();
        this.valueFitness = -1;
    }

    public void initializeGenotype() {
        for (int index = 0; index < this.genotype.length; index++) {
            int indexMovement = new Random().nextInt(EnumMovement.values().length);
            this.genotype[index] = EnumMovement.values()[indexMovement];
        }
    }

    public Cube getPhenotype() {
        return this.phenotype;
    }
    
    public void resetPhenotype() {
        this.phenotype = new Cube();
    }

    protected void showChromosome() {
        for (int index = 0; index < this.genotype.length; index++) {
            System.out.print(this.genotype[index] + " ");
        }
    }

    public int getValueFitness() {
        return this.valueFitness;
    }

    protected void applyMovement() {
        for (EnumMovement gene : this.genotype) {
            this.phenotype = this.mediatorBuilder.getMediator().doMoviment(gene, this.phenotype);
            Fitness fitness = new Fitness(this);
            this.valueFitness = fitness.calculateFitness();
        }
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

}
