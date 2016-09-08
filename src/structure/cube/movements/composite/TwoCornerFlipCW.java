/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.composite;

import rotation.Down;
import rotation.Front;
import rotation.Left;
import rotation.Up;
import structure.cube.movements.primary.EnumPrimaryMovement;
import structure.cube.movements.primary.PrimaryMovement;

/**
 *
 * @author bruno
 */
public class TwoCornerFlipCW extends CompositeMovement{

    public TwoCornerFlipCW(EnumCompositeMovement id) {
        super(id);
        createCompositeMoviment();
    }

    @Override
    protected void createCompositeMoviment() {
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.D1, new Down()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L1, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.F1, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.D1, new Down()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.F, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.F1, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.D, new Down()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.F, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.D, new Down()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L1, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U1, new Up()));
    }
    
}
