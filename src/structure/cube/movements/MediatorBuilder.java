/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements;

import rotation.Back;
import rotation.Down;
import rotation.Front;
import rotation.Left;
import rotation.Right;
import rotation.Up;
import structure.cube.movements.composite.EnumCompositeMovement;
import structure.cube.movements.composite.MovementSingle;
import structure.cube.movements.composite.ThreeCornerSwapCCW;
import structure.cube.movements.composite.ThreeCornerSwapCW;
import structure.cube.movements.composite.ThreeEdgeSwapCCW;
import structure.cube.movements.composite.ThreeEdgeSwapCW;
import structure.cube.movements.composite.ThreeInsliceEdgeSwapCCW;
import structure.cube.movements.composite.ThreeInsliceEdgeSwapCW;
import structure.cube.movements.composite.TwoCornerFlipCCW;
import structure.cube.movements.composite.TwoCornerFlipCW;
import structure.cube.movements.composite.TwoEdgeCornerSwapCCW;
import structure.cube.movements.composite.TwoEdgeCornerSwapCW;
import structure.cube.movements.composite.TwoEdgeFlipCCW;
import structure.cube.movements.composite.TwoEdgeFlipCW;

/**
 *
 * @author bruno
 */
public class MediatorBuilder {
    
    private MovementMediator mediator;
    
    public MediatorBuilder(){
        this.mediator = new MovementMediator();
    }
    
    public void createMediator(){
        buildMovementsQuarterClockWise();
        buildMovementsQuarterCounterClockWise();
        buildMovementsHalfClockWise();
        buildCompositeMovements();
    }
    
    private void buildCompositeMovements(){
        this.mediator.adicionarColleague(new TwoEdgeFlipCW(EnumCompositeMovement.TEFCW));
        this.mediator.adicionarColleague(new TwoEdgeFlipCCW(EnumCompositeMovement.TEFCCW));
        this.mediator.adicionarColleague(new TwoCornerFlipCW(EnumCompositeMovement.TCFCW));
        this.mediator.adicionarColleague(new TwoCornerFlipCCW(EnumCompositeMovement.TCFCCW));
        this.mediator.adicionarColleague(new ThreeEdgeSwapCW(EnumCompositeMovement.TESCW));
        this.mediator.adicionarColleague(new ThreeEdgeSwapCCW(EnumCompositeMovement.TESCCW));
        this.mediator.adicionarColleague(new TwoEdgeCornerSwapCW(EnumCompositeMovement.TECSCW));
        this.mediator.adicionarColleague(new TwoEdgeCornerSwapCCW(EnumCompositeMovement.TECSCCW));
        this.mediator.adicionarColleague(new ThreeCornerSwapCW(EnumCompositeMovement.TCSCW));
        this.mediator.adicionarColleague(new ThreeCornerSwapCCW(EnumCompositeMovement.TCSCCW));
        this.mediator.adicionarColleague(new ThreeInsliceEdgeSwapCW(EnumCompositeMovement.TIESCW));
        this.mediator.adicionarColleague(new ThreeInsliceEdgeSwapCCW(EnumCompositeMovement.TIESCCW));
    }
    
    private void buildMovementsQuarterClockWise(){
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.B, new Back()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.D, new Down()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.F, new Front()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.L, new Left()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.R, new Right()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.U, new Up()));
    }
    
    private void buildMovementsQuarterCounterClockWise(){
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.B1, new Back()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.D1, new Down()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.F1, new Front()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.L1, new Left()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.R1, new Right()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.U1, new Up()));
    }
    
    private void buildMovementsHalfClockWise(){
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.B2, new Back()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.D2, new Down()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.F2, new Front()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.L2, new Left()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.R2, new Right()));
        this.mediator.adicionarColleague(new MovementSingle(EnumCompositeMovement.U2, new Up()));
    }
    
    public Mediator getMediator(){
        return this.mediator;
    }
    
}
