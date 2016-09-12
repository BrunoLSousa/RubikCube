/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.composite;

import java.util.ArrayList;
import java.util.List;
import structure.cube.Cube;
import structure.cube.movements.primary.PrimaryMovement;

/**
 *
 * @author bruno
 */
public abstract class CompositeMovement {
    
    protected EnumCompositeMovement id;
    private List<PrimaryMovement> primaryMovements;
    
    public CompositeMovement(EnumCompositeMovement id){
        this.id = id;
        this.primaryMovements = new ArrayList<>();
    }
    
    public EnumCompositeMovement getId(){
        return this.id;
    }
    
    protected abstract void createCompositeMoviment();
    
    protected void addMovementPrimary(PrimaryMovement primaryMovement){
        this.primaryMovements.add(primaryMovement);
    }
    
    public Cube doMoviment(Cube cube){
        for(PrimaryMovement m : this.primaryMovements){
            cube = m.doMoviment(cube);
        }
        return cube;
    }
    
}
