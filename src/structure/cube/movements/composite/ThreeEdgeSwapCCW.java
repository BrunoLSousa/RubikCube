/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.composite;

import structure.cube.movements.EnumCompositeMovement;
import rotation.Down;
import rotation.Front;
import rotation.Left;
import rotation.Right;
import rotation.Up;
import structure.cube.movements.PrimaryMovement;

/**
 *
 * @author bruno
 */
public class ThreeEdgeSwapCCW extends CompositeMovement{

    public ThreeEdgeSwapCCW(EnumCompositeMovement id) {
        super(id);
        createCompositeMoviment();
    }

    //cria um movimento composto a partir dos movimentos primários.
    @Override
    protected void createCompositeMoviment() {
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.U1, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.F2, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.U, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.L, new Left()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.D, new Down()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.R, new Right()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.F2, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.R1, new Right()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.D1, new Down()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.L1, new Left()));
    }
    
}
