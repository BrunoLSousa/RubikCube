/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import structure.cube.Face;

/**
 *
 * @author bruno
 */
public class Fitness {

    private static final int PENALITY_Q1 = 1;
    private static final int PENALITY_Q2 = 4;
    private static final int PENALITY_Q3 = 5;
    private Chromosome chromosome;

    public Fitness(Chromosome chromosome) {
        this.chromosome = chromosome;
    }

    public int calculateFitness() {
        int penality = calculateQ1();
        penality += calculateQ2();
        penality += calculateQ3();
        return penality;
    }

    private int calculateQ1() {
        int penalityQ1 = 0;
        for (Face f : Face.values()) {
            String[][] face = this.chromosome.getPhenotype().getViewFace(f);
            for (int line = 0; line < this.chromosome.getPhenotype().getConfiguration(); line++) {
                for (int column = 0; column < this.chromosome.getPhenotype().getConfiguration(); column++) {
                    penalityQ1 = (!face[line][column].equals(face[1][1])) ? penalityQ1 + 1 : penalityQ1;
                }
            }
        }
        return penalityQ1;
    }

    private int calculateQ2() {
        int penalityQ2 = 0;
        for (Face f : Face.values()) {
            String[][] face = this.chromosome.getPhenotype().getViewFace(f);
            if(!face[0][1].equals(face[1][1])){
                penalityQ2 += penalityQ2;
            }
            if(!face[1][0].equals(face[1][1])){
                penalityQ2 += penalityQ2;
            }
            if(!face[2][1].equals(face[1][1])){
                penalityQ2 += penalityQ2;
            }
            if(!face[1][2].equals(face[1][1])){
                penalityQ2 += penalityQ2;
            }
        }
        return penalityQ2;
    }

    private int calculateQ3() {
        int penalityQ3 = 0;
        for (Face f : Face.values()) {
            String[][] face = this.chromosome.getPhenotype().getViewFace(f);
            if((!face[0][0].equals(face[0][1]) || (!face[0][1].equals(face[1][1]))) && (!face[0][0].equals(face[1][0]) || (!face[1][0].equals(face[1][1])))){
                penalityQ3 += penalityQ3;
            }
            if((!face[2][0].equals(face[1][0]) || (!face[1][0].equals(face[1][1]))) && (!face[2][0].equals(face[2][1]) || (!face[2][1].equals(face[1][1])))){
                penalityQ3 += penalityQ3;
            }
            if((!face[2][2].equals(face[2][1]) || (!face[2][1].equals(face[1][1]))) && (!face[2][2].equals(face[1][2]) || (!face[1][2].equals(face[1][1])))){
                penalityQ3 += penalityQ3;
            }
            if((!face[0][2].equals(face[0][1]) || (!face[0][1].equals(face[1][1]))) && (!face[0][2].equals(face[1][2]) || (!face[1][2].equals(face[1][1])))){
                penalityQ3 += penalityQ3;
            }
        }
        return penalityQ3;
    }

}
