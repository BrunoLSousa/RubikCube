/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.composite;

import rotation.Back;
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
public class TwoEdgeFlipCW extends CompositeMovement{

    public TwoEdgeFlipCW(EnumCompositeMovement id){
        super(id);
        createCompositeMoviment();
    }
    
    @Override
    protected void createCompositeMoviment() {
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.F, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.R, new Right()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.B, new Back()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L1, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.B1, new Back()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.R1, new Right()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.F1, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L1, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U1, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.L, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumPrimaryMovement.U1, new Up()));
    }
    
}
