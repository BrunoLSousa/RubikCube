/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviment;

import structure.cube.Cube;
import structure.cube.Face;

/**
 *
 * @author bruno
 */
public abstract class Movement {
    
    private Cube cube;
    protected String[] cachePosition;
    
    public Movement(Cube cube){
        this.cube = cube;
    }
    
    public abstract void rotateQuarterClockwise();
    
    public abstract void rotateQuarterCounterclockwise();
    
    public void rotateHalfClockwise(){
        rotateQuarterClockwise();
        rotateQuarterClockwise();
    }
    
    public Cube getCube(){
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
