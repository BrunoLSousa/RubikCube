/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.composite;

import structure.cube.movements.EnumCompositeMovement;
import rotation.RotationFace;
import structure.cube.movements.PrimaryMovement;

/**
 *
 * @author bruno
 */
public class MovementSingle extends CompositeMovement{

    private RotationFace rotationFace;
    
    public MovementSingle(EnumCompositeMovement id, RotationFace rotationFace) {
        super(id);
        this.rotationFace = rotationFace;
        createCompositeMoviment();
    }

    //aplica movimento requerido ao cubo.
    @Override
    protected void createCompositeMoviment() {
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.valueOf(this.id.toString()), rotationFace));
    }
    
}
