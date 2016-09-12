/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import structure.cube.Cube;
import structure.cube.Face;

/**
 *
 * @author bruno
 */
public class Fitness {

    private static final int PENALITY_Q1 = 1;
    private static final int PENALITY_Q2 = 4;
    private static final int PENALITY_Q3 = 6;
    private Chromosome chromosome;
    private Cube cube;
    private int penality;

    public Fitness(Chromosome chromosome) {
        this.chromosome = chromosome;
    }

//    public Fitness(Cube cube) {
//        this.cube = cube;
//        this.penality = 12;
//    }

    public int calculateFitness() {
        int penality = calculateQ1();
        penality += calculateQ2();
        penality += calculateQ3();
        return penality;
    }
    
//    public int calculateFitness() {
//        calculeBorder1();
//        calculeBorder2();
//        calculeBorder3();
//        calculeBorder4();
//        return 5 * (2*penality) + 7;
//    }

    private int calculateQ1() {
        int penalityQ1 = 0;
        for (Face f : Face.values()) {
            String[][] face = this.chromosome.getPhenotype().getViewFace(f);
            for (int line = 0; line < this.chromosome.getPhenotype().getConfiguration(); line++) {
                for (int column = 0; column < this.chromosome.getPhenotype().getConfiguration(); column++) {
                    penalityQ1 = (!face[line][column].equals(face[1][1])) ? penalityQ1 + PENALITY_Q1 : penalityQ1;
                }
            }
        }
        return penalityQ1;
    }

    private int calculateQ2() {
//        int penalityQ2 = 0;
        int penalityQ2 = calculeBorder1();
        penalityQ2 += calculeBorder2();
        penalityQ2 += calculeBorder3();
        penalityQ2 += calculeBorder4();
        
//        for (Face f : Face.values()) {
//            String[][] face = this.chromosome.getPhenotype().getViewFace(f);
//            if (!face[0][1].equals(face[1][1])) {
//                penalityQ2 += PENALITY_Q2;
//            }
//            if (!face[1][0].equals(face[1][1])) {
//                penalityQ2 += PENALITY_Q2;
//            }
//            if (!face[2][1].equals(face[1][1])) {
//                penalityQ2 += PENALITY_Q2;
//            }
//            if (!face[1][2].equals(face[1][1])) {
//                penalityQ2 += PENALITY_Q2;
//            }
//        }
        return penalityQ2 * PENALITY_Q2;
    }

    private int calculateQ3() {
//        int penalityQ3 = 0;
        int penalityQ3 = calculeCorner1();
        penalityQ3 += calculeCorner2();
//        for (Face f : Face.values()) {
//            String[][] face = this.chromosome.getPhenotype().getViewFace(f);
//            if ((!face[0][0].equals(face[0][1]) || (!face[0][1].equals(face[1][1]))) && (!face[0][0].equals(face[1][0]) || (!face[1][0].equals(face[1][1])))) {
//                penalityQ3 += PENALITY_Q3;
//            }
//            if ((!face[2][0].equals(face[1][0]) || (!face[1][0].equals(face[1][1]))) && (!face[2][0].equals(face[2][1]) || (!face[2][1].equals(face[1][1])))) {
//                penalityQ3 += PENALITY_Q3;
//            }
//            if ((!face[2][2].equals(face[2][1]) || (!face[2][1].equals(face[1][1]))) && (!face[2][2].equals(face[1][2]) || (!face[1][2].equals(face[1][1])))) {
//                penalityQ3 += PENALITY_Q3;
//            }
//            if ((!face[0][2].equals(face[0][1]) || (!face[0][1].equals(face[1][1]))) && (!face[0][2].equals(face[1][2]) || (!face[1][2].equals(face[1][1])))) {
//                penalityQ3 += PENALITY_Q3;
//            }
//        }
        return penalityQ3 * PENALITY_Q3;
    }
    
    private int calculeBorder1() {
        int penality = 0;
        String[][] up = this.chromosome.getPhenotype().getViewFace(Face.Up);
        String[][] front = this.chromosome.getPhenotype().getViewFace(Face.Front);
        String[][] right = this.chromosome.getPhenotype().getViewFace(Face.Right);
        String[][] back = this.chromosome.getPhenotype().getViewFace(Face.Back);
        String[][] left = this.chromosome.getPhenotype().getViewFace(Face.Left);
        if (!front[0][1].equals(front[1][1]) && !up[2][1].equals(up[1][1])) {
            penality++;
        }
        if (!right[0][1].equals(right[1][1]) && !up[1][2].equals(up[1][1])) {
            penality++;
        }
        if (!back[0][1].equals(back[1][1]) && !up[0][1].equals(up[1][1])) {
            penality++;
        }
        if (!left[0][1].equals(left[1][1]) && !up[1][0].equals(up[1][1])) {
            penality++;
        }
        return penality;
    }

    private int calculeBorder2() {
        int penality = 0;
        String[][] down = this.chromosome.getPhenotype().getViewFace(Face.Down);
        String[][] front = this.chromosome.getPhenotype().getViewFace(Face.Front);
        String[][] right = this.chromosome.getPhenotype().getViewFace(Face.Right);
        String[][] back = this.chromosome.getPhenotype().getViewFace(Face.Back);
        String[][] left = this.chromosome.getPhenotype().getViewFace(Face.Left);
        if (!front[2][1].equals(front[1][1]) && !down[0][1].equals(down[1][1])) {
            penality++;
        }
        if (!right[2][1].equals(right[1][1]) && !down[1][2].equals(down[1][1])) {
            penality++;
        }
        if (!back[2][1].equals(back[1][1]) && !down[2][1].equals(down[1][1])) {
            penality++;
        }
        if (!left[2][1].equals(left[1][1]) && !down[1][0].equals(down[1][1])) {
            penality++;
        }
        return penality;
    }

    private int calculeBorder3() {
        int penality = 0;
        String[][] left = this.chromosome.getPhenotype().getViewFace(Face.Left);
        String[][] front = this.chromosome.getPhenotype().getViewFace(Face.Front);
        String[][] back = this.chromosome.getPhenotype().getViewFace(Face.Back);
        if (!front[1][0].equals(front[1][1]) && !left[1][2].equals(left[1][1])) {
            penality++;
        }
        if (!back[1][2].equals(back[1][1]) && !left[1][0].equals(left[1][1])) {
            penality++;
        }
        return penality;
    }

    private int calculeBorder4() {
        int penality = 0;
        String[][] right = this.chromosome.getPhenotype().getViewFace(Face.Right);
        String[][] front = this.chromosome.getPhenotype().getViewFace(Face.Front);
        String[][] back = this.chromosome.getPhenotype().getViewFace(Face.Back);
        if (!front[1][2].equals(front[1][1]) && !right[1][0].equals(right[1][1])) {
            penality++;
        }
        if (!back[1][0].equals(back[1][1]) && !right[1][2].equals(right[1][1])) {
            penality++;
        }
        return penality;
    }
    
    private int calculeCorner1(){
        int penality = 0;
        String[][] up = this.chromosome.getPhenotype().getViewFace(Face.Up);
        String[][] front = this.chromosome.getPhenotype().getViewFace(Face.Front);
        String[][] right = this.chromosome.getPhenotype().getViewFace(Face.Right);
        String[][] back = this.chromosome.getPhenotype().getViewFace(Face.Back);
        String[][] left = this.chromosome.getPhenotype().getViewFace(Face.Left);
        if (!up[0][0].equals(up[1][1]) || !left[0][0].equals(left[1][1]) || !back[0][2].equals(back[1][1])) {
            penality++;
        }
        if (!up[0][2].equals(up[1][1]) || !right[0][2].equals(right[1][1]) || !back[0][0].equals(back[1][1])) {
            penality++;
        }
        if (!up[2][2].equals(up[1][1]) || !right[0][0].equals(right[1][1]) || !front[0][2].equals(front[1][1])) {
            penality++;
        }
        if (!up[2][0].equals(up[1][1]) || !left[0][2].equals(left[1][1]) || !front[0][0].equals(back[1][1])) {
            penality++;
        }
        return penality;
    }
    
    private int calculeCorner2(){
        int penality = 0;
        String[][] down = this.chromosome.getPhenotype().getViewFace(Face.Down);
        String[][] front = this.chromosome.getPhenotype().getViewFace(Face.Front);
        String[][] right = this.chromosome.getPhenotype().getViewFace(Face.Right);
        String[][] back = this.chromosome.getPhenotype().getViewFace(Face.Back);
        String[][] left = this.chromosome.getPhenotype().getViewFace(Face.Left);
        if (!down[0][0].equals(down[1][1]) || !left[2][2].equals(left[1][1]) || !front[2][0].equals(front[1][1])) {
            penality++;
        }
        if (!down[0][2].equals(down[1][1]) || !right[2][0].equals(right[1][1]) || !front[2][2].equals(front[1][1])) {
            penality++;
        }
        if (!down[2][2].equals(down[1][1]) || !right[2][2].equals(right[1][1]) || !back[2][0].equals(back[1][1])) {
            penality++;
        }
        if (!down[2][0].equals(down[1][1]) || !left[2][0].equals(left[1][1]) || !back[2][2].equals(back[1][1])) {
            penality++;
        }
        return penality;
    }

}
