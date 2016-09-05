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
public class Chromosome {
    
    private EnumMovement[] genotype;
    private Cube phenotype;
    private MediatorBuilder mediatorBuilder;
    private int valueFitness;
//    protected int bestFitness;
//    protected int indexBestFitness;

    public Chromosome(int lengthGenotype) {
        this.phenotype = new Cube();
        this.genotype = new EnumMovement[lengthGenotype];
        this.mediatorBuilder = new MediatorBuilder();
        this.mediatorBuilder.createMediator();
        this.valueFitness = -1;
//        this.bestFitness = -1;
//        this.indexBestFitness = -1;
    }
    
    public void initializeGenotype(){
        for(int index = 0; index < this.genotype.length; index++){
            int indexMovement = new Random().nextInt(EnumMovement.values().length);
            this.genotype[index] = EnumMovement.values()[indexMovement];
        }
    }
    
    public Cube getPhenotype(){
        return this.phenotype;
    }
    
    public void resetPhenotype(){
        this.phenotype = new Cube();
    }
    
    protected void showChromosome(){
        for(int index = 0; index < this.genotype.length; index++){
            System.out.print(this.genotype[index] + " ");
        }
    }
    
    public int getValueFitness(){
        return this.valueFitness;
    }
    
    protected void applyMovement(){
        for (EnumMovement gene : this.genotype) {
            this.phenotype = this.mediatorBuilder.getMediator().doMoviment(gene, this.phenotype);
            Fitness fitness = new Fitness(this);
            this.valueFitness = fitness.calculateFitness();
        }
    }
    
//    protected void applyMovement(){
//        int index = 0;
//        for (EnumMovement gene : this.genotype) {
//            this.phenotype = this.mediatorBuilder.getMediator().doMoviment(gene, this.phenotype);
//            Fitness fitness = new Fitness(this);
//            int sum = fitness.calculateFitness();
//            if(sum < this.bestFitness || this.bestFitness == -1){
//                this.bestFitness = sum;
//                this.indexBestFitness = index;
//            }
//            index++;
//        }
//    }
    
}
