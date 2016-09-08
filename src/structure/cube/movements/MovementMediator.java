/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements;

import java.util.ArrayList;
import structure.cube.Cube;
import structure.cube.movements.composite.CompositeMovement;
import structure.cube.movements.composite.EnumCompositeMovement;

/**
 *
 * @author bruno
 */
public class MovementMediator implements Mediator{
    
    protected ArrayList<CompositeMovement> movements;

    public MovementMediator() {
        this.movements = new ArrayList<>();
    }

    public void adicionarColleague(CompositeMovement colleague) {
        this.movements.add(colleague);
    }

    @Override
    public Cube doMoviment(EnumCompositeMovement movement, Cube cube) {
        for (CompositeMovement m : this.movements) {
            if (m.getId() == movement) {
                cube = m.doMoviment(cube);
                break;
            }
        }
        return cube;
    }

}
