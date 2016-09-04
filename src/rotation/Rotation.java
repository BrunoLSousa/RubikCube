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
public abstract class Rotation {
    
    private Cube cube;
    protected String[] cachePosition;
    
    public Rotation(Cube cube){
        this.cube = cube;
    }
    
    public abstract void rotateQuarterClockwise();
    
    public void rotateQuarterCounterclockwise(){
        rotateHalfClockwise();
        rotateQuarterClockwise();
    }
    
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
