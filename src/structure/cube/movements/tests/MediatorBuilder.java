/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube.movements.tests;

import rotation.Back;
import rotation.Down;
import rotation.Front;
import rotation.Left;
import rotation.Right;
import rotation.Up;
import structure.cube.movements.primary.EnumPrimaryMovement;

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
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.B, new Back()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.D, new Down()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.F, new Front()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.L, new Left()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.R, new Right()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.U, new Up()));
    }
    
    private void buildMovementsQuarterCounterClockWise(){
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.B1, new Back()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.D1, new Down()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.F1, new Front()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.L1, new Left()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.R1, new Right()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.U1, new Up()));
    }
    
    private void buildMovementsHalfClockWise(){
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.B2, new Back()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.D2, new Down()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.F2, new Front()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.L2, new Left()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.R2, new Right()));
        this.mediator.adicionarColleague(new Movement(EnumPrimaryMovement.U2, new Up()));
    }
    
    public Mediator getMediator(){
        return this.mediator;
    }
    
}
