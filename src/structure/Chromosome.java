/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.HashMap;
import moviment.Movement;
import structure.cube.Cube;
import structure.cube.Face;

/**
 *
 * @author bruno
 */
public class Chromosome {
    
    private Movement[] genotype;
    private Cube phenotype;

    public Chromosome(Cube cubeInitialFormat) {
        this.genotype = new Movement[50];
        this.phenotype = cubeInitialFormat;
    }
    
    public int addMoviment(Movement moviment){
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
