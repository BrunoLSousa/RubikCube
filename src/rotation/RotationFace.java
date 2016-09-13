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
    
    public RotationFace(){
        
    }
    
    public abstract Cube rotateQuarterClockwise();
    
    //método responsável por rotacionar a face do cubo em 90º sentido anti-horário.
    public Cube rotateQuarterCounterClockWise(){
        rotateHalfClockwise();
        rotateQuarterClockwise();
        return getCube();
    }
    
    //método responsável por rotacionar a face do cubo em 180º sentido horário.
    public Cube rotateHalfClockwise(){
        rotateQuarterClockwise();
        rotateQuarterClockwise();
        return getCube();
    }
    
    public void setCube(Cube cube){
        this.cube = cube;
    }
    
    protected Cube getCube(){
        return this.cube;
    }
    
    //escreve a composição das faces do cubo na tela.
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
