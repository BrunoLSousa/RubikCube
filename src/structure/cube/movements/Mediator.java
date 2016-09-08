/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements;

import structure.cube.Cube;
import structure.cube.movements.composite.EnumCompositeMovement;

/**
 *
 * @author bruno
 */
public interface Mediator {

    public Cube doMoviment(EnumCompositeMovement movement, Cube cube);

}
