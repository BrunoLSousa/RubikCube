/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikcube;

import moviment.Back;
import moviment.Down;
import moviment.Front;
import moviment.Left;
import moviment.Movement;
import moviment.Right;
import moviment.Up;
import structure.cube.Cube;

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
        Cube cube = new Cube();
//        Movement movement = new Front(cube);
//        Movement movement = new Up(cube);
//        Movement movement = new Down(cube);
//        Movement movement = new Left(cube);
//        Movement movement = new Right(cube);
        Movement movement = new Back(cube);
        movement.printCube();
        movement.rotateQuarterClockwise();
        movement.printCube();
    }

}
