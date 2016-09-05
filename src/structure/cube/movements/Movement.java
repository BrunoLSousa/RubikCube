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
public class Movement extends MovementColleague{

    public Movement(EnumMovement id, RotationFace rotationFace) {
        super(id, rotationFace);
    }

    @Override
    protected Cube doMoviment(Cube cube, EnumMovement id) {
        if(id.toString().contains("1")){
            this.rotationFace.setCube(cube);
            return this.rotationFace.rotateQuarterCounterClockWise();
        }else if(id.toString().contains("2")){
            this.rotationFace.setCube(cube);
            return this.rotationFace.rotateHalfClockwise();
        }else{
            this.rotationFace.setCube(cube);
            return this.rotationFace.rotateQuarterClockwise();
        }
    }
    
}
