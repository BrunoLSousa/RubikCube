/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements;

import rotation.RotationFace;
import structure.cube.Cube;

/**
 *
 * @author bruno
 */
public abstract class MovementColleague {
    
    protected  EnumMovement id;
    protected  RotationFace rotationFace;
    
    public MovementColleague(EnumMovement id, RotationFace rotationFace) {
        this.id = id;
        this.rotationFace = rotationFace;
    }
    
    protected abstract Cube doMoviment(Cube cube, EnumMovement id);
    
}
