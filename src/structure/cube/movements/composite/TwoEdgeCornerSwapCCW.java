/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.composite;

import rotation.Back;
import rotation.Front;
import rotation.Left;
import rotation.Up;
import structure.cube.movements.primary.EnumPrimaryMovement;
import structure.cube.movements.primary.PrimaryMovement;

/**
 *
 * @author bruno
 */
public class TwoEdgeCornerSwapCCW extends CompositeMovement{

    public TwoEdgeCornerSwapCCW(EnumCompositeMovement id) {
        super(id);
        createCompositeMoviment();
    }

    @Override
    protected void createCompositeMoviment() {
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U1, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L1, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U1, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.F1, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L1, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.B, new Back()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L1, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.B1, new Back()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L1, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.F, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L2, new Left()));
    }
    
}
