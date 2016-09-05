/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotation;

import structure.cube.Cube;
import structure.cube.Face;

/**
 *
 * @author bruno
 */
public abstract class RotationFace {
    
    private Cube cube;
    protected String[] cachePosition;
    
    public RotationFace(Cube cube){
        this.cube = cube;
    }
    
    public abstract Cube rotateQuarterClockwise();
    
    public Cube rotateQuarterCounterClockWise(){
        rotateHalfClockwise();
        rotateQuarterClockwise();
        return getCube();
    }
    
    public Cube rotateHalfClockwise(){
        rotateQuarterClockwise();
        rotateQuarterClockwise();
        return getCube();
    }
    
    protected Cube getCube(){
        return this.cube;
    }
    
    public void printCube(){
        for(Face face : Face.values()){
            String[][] f = cube.getViewFace(face);
            System.out.println(face.toString());
            for(int line = 0; line < 3; line++){
                for(int column = 0; column < 3; column++){
                    System.out.print(f[line][column] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}