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
public class PrimaryMovement{

    private  EnumCompositeMovement id;
    private  RotationFace rotationFace;
    
    public PrimaryMovement(EnumCompositeMovement id, RotationFace rotationFace) {
        this.id = id;
        this.rotationFace = rotationFace;
    }

    //executa um movimento no cubo.
    public Cube doMoviment(Cube cube) {
        if(this.id.toString().contains("1")){
            this.rotationFace.setCube(cube);
            return this.rotationFace.rotateQuarterCounterClockWise();
        }else if(this.id.toString().contains("2")){
            this.rotationFace.setCube(cube);
            return this.rotationFace.rotateHalfClockwise();
        }else{
            this.rotationFace.setCube(cube);
            return this.rotationFace.rotateQuarterClockwise();
        }
    }
    
}
