/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.tests;

import java.util.ArrayList;
import structure.cube.Cube;
import structure.cube.movements.primary.EnumPrimaryMovement;

/**
 *
 * @author bruno
 */
public class MovementMediator implements Mediator{
   
    protected ArrayList<MovementColleague> movements;

    public MovementMediator() {
        this.movements = new ArrayList<>();
    }

    public void adicionarColleague(MovementColleague colleague) {
        this.movements.add(colleague);
    }

    @Override
    public Cube doMoviment(EnumPrimaryMovement movement, Cube cube) {
        for (MovementColleague m : this.movements) {
            if (m.id == movement) {
                cube = m.doMoviment(cube, movement);
                break;
            }
        }
        return cube;
    }

}
