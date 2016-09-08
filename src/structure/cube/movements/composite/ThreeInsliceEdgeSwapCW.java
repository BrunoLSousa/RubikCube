/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.composite;

import rotation.Front;
import rotation.Left;
import rotation.Right;
import rotation.Up;
import structure.cube.movements.primary.EnumPrimaryMovement;
import structure.cube.movements.primary.PrimaryMovement;

/**
 *
 * @author bruno
 */
public class ThreeInsliceEdgeSwapCW extends CompositeMovement{

    public ThreeInsliceEdgeSwapCW(EnumCompositeMovement id) {
        super(id);
        createCompositeMoviment();
    }

    @Override
    protected void createCompositeMoviment() {
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.R, new Right()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L1, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U2, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.R1, new Right()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.F2, new Front()));
    }
    
}
