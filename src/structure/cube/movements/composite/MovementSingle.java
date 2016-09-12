/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.composite;

import rotation.RotationFace;
import structure.cube.movements.primary.EnumPrimaryMovement;
import structure.cube.movements.primary.PrimaryMovement;

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

    @Override
    protected void createCompositeMoviment() {
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.valueOf(this.id.toString()), rotationFace));
    }
    
}
