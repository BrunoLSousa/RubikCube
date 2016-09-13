/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.composite;

import structure.cube.movements.EnumCompositeMovement;
import rotation.Back;
import rotation.Front;
import rotation.Up;
import structure.cube.movements.PrimaryMovement;

/**
 *
 * @author bruno
 */
public class ThreeCornerSwapCW extends CompositeMovement{

    public ThreeCornerSwapCW(EnumCompositeMovement id) {
        super(id);
        createCompositeMoviment();
    }

    //cria um movimento composto a partir dos movimentos primários.
    @Override
    protected void createCompositeMoviment() {
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.F1, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.U, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.B, new Back()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.U1, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.F, new Front()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.U, new Up()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.B1, new Back()));
        this.addMovementPrimary(new PrimaryMovement(EnumCompositeMovement.U1, new Up()));
    }
    
}
