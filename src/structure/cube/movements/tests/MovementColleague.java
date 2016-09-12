/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.tests;

import rotation.RotationFace;
import structure.cube.Cube;
import structure.cube.movements.primary.EnumPrimaryMovement;

/**
 *
 * @author bruno
 */
public abstract class MovementColleague {

    protected EnumPrimaryMovement id;
    protected RotationFace rotationFace;

    public MovementColleague(EnumPrimaryMovement id, RotationFace rotationFace) {
        this.id = id;
        this.rotationFace = rotationFace;
    }

    protected abstract Cube doMoviment(Cube cube, EnumPrimaryMovement id);

}
