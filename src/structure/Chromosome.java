/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.Random;
import structure.cube.Cube;
import structure.cube.movements.EnumMovement;

/**
 *
 * @author bruno
 */
public class Chromosome {
    
    private EnumMovement[] genotype;
    private Cube phenotype;

    public Chromosome(int lengthGenotype) {
        this.phenotype = new Cube();
        this.genotype = new EnumMovement[lengthGenotype];
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
    
}
