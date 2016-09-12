/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.Random;
import structure.cube.Cube;
import structure.cube.Face;
import structure.cube.movements.MediatorBuilder;
import structure.cube.movements.composite.EnumCompositeMovement;
import structure.cube.movements.primary.EnumPrimaryMovement;

/**
 *
 * @author bruno
 */
public class Chromosome implements Comparable<Chromosome> {

    protected EnumCompositeMovement[] genotype;
//    protected EnumPrimaryMovement[] genotype;
    private Cube phenotype;
    private MediatorBuilder mediatorBuilder;
//    private structure.cube.movements.tests.MediatorBuilder mediatorBuilder;
    private int valueFitness;
    private int index = -1;
    private Cube cube;

    public Chromosome(int lengthGenotype) {
        this.phenotype = new Cube();
        this.genotype = new EnumCompositeMovement[lengthGenotype];
//        this.genotype = new EnumPrimaryMovement[lengthGenotype];
        this.mediatorBuilder = new MediatorBuilder();
//        this.mediatorBuilder = new structure.cube.movements.tests.MediatorBuilder();
        this.mediatorBuilder.createMediator();
        this.valueFitness = -1;
        this.cube = new Cube();
    }

    public Chromosome(EnumCompositeMovement[] genotype) {
//    public Chromosome(EnumPrimaryMovement[] genotype) {
        this.phenotype = new Cube();
        this.genotype = genotype;
        this.mediatorBuilder = new MediatorBuilder();
//        this.mediatorBuilder = new structure.cube.movements.tests.MediatorBuilder();
        this.mediatorBuilder.createMediator();
        this.valueFitness = -1;
        this.cube = new Cube();
    }

    public void initializeGenotype() {
        for (int index = 0; index < this.genotype.length; index++) {
            int indexMovement = new Random().nextInt(EnumCompositeMovement.values().length);
            this.genotype[index] = EnumCompositeMovement.values()[indexMovement];
//            int indexMovement = new Random().nextInt(EnumPrimaryMovement.values().length);
//            this.genotype[index] = EnumPrimaryMovement.values()[indexMovement];
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
        int i = 0;
        for (EnumCompositeMovement gene : this.genotype) {
//        for (EnumPrimaryMovement gene : this.genotype) {
            this.phenotype = this.mediatorBuilder.getMediator().doMoviment(gene, this.phenotype);
//            Fitness fitness = new Fitness(this);
//        Fitness fitness = new Fitness(this.phenotype);
//            int value = fitness.calculateFitness();
//            if (this.valueFitness == -1 || value < this.valueFitness) {
//                this.valueFitness = value;
//                this.index = i;
//                cloneCune();
//            }
//            i++;
        }
        Fitness fitness = new Fitness(this);
        this.valueFitness = fitness.calculateFitness();
        this.index = i;
        this.cube = this.phenotype;
    }

    public void cloneCune() {
        this.cube = new Cube();
        for (Face f : Face.values()) {
            String[][] newValues = new String[3][3];
            String[][] values = this.phenotype.getViewFace(f);
            for (int line = 0; line < 3; line++) {
                for (int column = 0; column < 3; column++) {
                    newValues[line][column] = this.phenotype.getViewFace(f)[line][column];
                }
            }
            this.cube.updateFace(f, newValues);
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

    public void printInformation() {
        System.out.println("Chromosome:");
        for (int index = 0; index < this.genotype.length; index++) {
            System.out.print(this.genotype[index].toString() + " ");
        }
        System.out.println("\n");

        System.out.println("Fitness: " + this.valueFitness + "\n");

        System.out.println("Phenotype:");
        this.cube.printCube();
//        this.phenotype.printCube();
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
