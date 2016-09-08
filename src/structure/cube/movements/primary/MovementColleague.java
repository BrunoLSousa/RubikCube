/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.primary;

import structure.cube.Cube;
import structure.cube.movements.composite.CompositeMovement;
import structure.cube.movements.composite.EnumCompositeMovement;

/**
 *
 * @author bruno
 */
public abstract class MovementColleague {
    
    protected  EnumCompositeMovement id;
    protected  CompositeMovement compositeMovement;
    
    public MovementColleague(EnumCompositeMovement id, CompositeMovement compositeMovement) {
        this.id = id;
        this.compositeMovement = compositeMovement;
    }
    
    protected abstract Cube doMoviment(Cube cube, EnumCompositeMovement id);
    
}
