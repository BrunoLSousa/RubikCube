/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import rotation.Rotation;
import structure.cube.Cube;

/**
 *
 * @author bruno
 */
public class Chromosome {
    
    private Rotation[] genotype;
    private Cube phenotype;

    public Chromosome(Cube cubeInitialFormat) {
        this.genotype = new Rotation[50];
        this.phenotype = cubeInitialFormat;
    }
    
    public int addMoviment(Rotation moviment){
        if(isNotFull()){
            int indexNewMoviment = this.genotype.length;
            this.genotype[indexNewMoviment] = moviment;
            return 1;
        }
        return 0;
    }
    
    private boolean isNotFull(){
        return this.genotype.length < 50;
    }
    
    public Cube getPhenotype(){
        return this.phenotype;
    }
    
}
