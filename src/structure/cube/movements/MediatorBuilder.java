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
    }
    
    private void buildMovementsQuarterClockWise(){
        this.mediator.adicionarColleague(new Movement(EnumMovement.B, new Back()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.D, new Down()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.F, new Front()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.L, new Left()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.R, new Right()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.U, new Up()));
    }
    
    private void buildMovementsQuarterCounterClockWise(){
        this.mediator.adicionarColleague(new Movement(EnumMovement.B1, new Back()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.D1, new Down()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.F1, new Front()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.L1, new Left()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.R1, new Right()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.U1, new Up()));
    }
    
    private void buildMovementsHalfClockWise(){
        this.mediator.adicionarColleague(new Movement(EnumMovement.B2, new Back()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.D2, new Down()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.F2, new Front()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.L2, new Left()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.R2, new Right()));
        this.mediator.adicionarColleague(new Movement(EnumMovement.U2, new Up()));
    }
    
    public Mediator getMediator(){
        return this.mediator;
    }
    
}
