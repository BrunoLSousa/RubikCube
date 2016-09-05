/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikcube;

import structure.Generation;

/**
 *
 * @author bruno
 */
public class RubikCube {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        Generation generation = new Generation(10, 50);
        generation.creatingInitialPopulation();
        generation.showGeneration();
        System.out.println("\n");
        generation.calculateFitness();
    }

}
