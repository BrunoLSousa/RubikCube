/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikcube;

import rotation.Back;
import rotation.Down;
import rotation.Front;
import rotation.Left;
import rotation.Right;
import rotation.Up;
import structure.cube.movements.EnumMovement;
import structure.cube.movements.MovementMediator;
import structure.cube.Cube;
import structure.cube.movements.Movement;

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
        MovementMediator mediator = new MovementMediator();
        mediator.adicionarColleague(new Movement(EnumMovement.B, new Back(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.D, new Down(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.F, new Front(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.L, new Left(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.R, new Right(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.U, new Up(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.B1, new Back(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.D1, new Down(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.F1, new Front(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.L1, new Left(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.R1, new Right(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.U1, new Up(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.B2, new Back(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.D2, new Down(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.F2, new Front(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.L2, new Left(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.R2, new Right(cube)));
        mediator.adicionarColleague(new Movement(EnumMovement.U2, new Up(cube)));
        cube.printCube();
        cube = mediator.doMoviment(EnumMovement.B2, cube);
        cube = mediator.doMoviment(EnumMovement.B1, cube);
        cube = mediator.doMoviment(EnumMovement.R, cube);
        cube = mediator.doMoviment(EnumMovement.U, cube);
        cube = mediator.doMoviment(EnumMovement.F2, cube);
        cube = mediator.doMoviment(EnumMovement.D1, cube);
        cube.printCube();
    }

}
