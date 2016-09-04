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
import moviment.Rotation;
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
        Rotation movement = new Front(cube);
//        Rotation movement = new Up(cube);
//        Rotation movement = new Down(cube);
//        Rotation movement = new Left(cube);
//        Rotation movement = new Right(cube);
//        Rotation movement = new Back(cube);
        movement.printCube();
        movement.rotateQuarterCounterclockwise();
        movement.printCube();
    }

}
