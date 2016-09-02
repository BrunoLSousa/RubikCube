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
public class Up extends Movement{

    public Up(Cube cube) {
        super(cube);
    }

    @Override
    public void rotateQuarterClockwise() {
        rotateFrontToLeft();
        rotateLeftToBack();
        rotateBackToRight();
        rotateRightToFront();
        rotateUp();
    }

    @Override
    public void rotateQuarterCounterclockwise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void rotateFrontToLeft(){
        String[][] front = this.getCube().getViewFace(Face.Front);
        String[][] left = this.getCube().getViewFace(Face.Left);
        int line = front.length;
        this.cachePosition = new String[line];
        for (int column = 0; column < line; column++) {
            this.cachePosition[column] = left[0][column];
            left[0][column] = front[0][column];
        }
        this.getCube().updateFace(Face.Left, left);
    }
    
    private void rotateLeftToBack(){
        String[][] back = this.getCube().getViewFace(Face.Back);
        int line = back.length;
        String[] newCachePosition = new String[line];
        for (int column = 0; column < line; column++) {
            newCachePosition[column] = back[0][column];
            back[0][column] = this.cachePosition[column];
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Back, back);
    }
    
    private void rotateBackToRight(){
        String[][] right = this.getCube().getViewFace(Face.Right);
        int line = right.length;
        String[] newCachePosition = new String[line];
        for (int column = 0; column < line; column++) {
            newCachePosition[column] = right[0][column];
            right[0][column] = this.cachePosition[column];
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Right, right);
    }
    
    private void rotateRightToFront(){
        String[][] front = this.getCube().getViewFace(Face.Front);
        int line = front.length;
        for (int column = 0; column < line; column++) {
            front[0][column] = this.cachePosition[column];
        }
        this.getCube().updateFace(Face.Front, front);
    }
    
    private void rotateUp(){
        String[][] up = this.getCube().getViewFace(Face.Up);
        int size = up.length;
        String[][] rotateUp = new String[size][size];
        int index = size - 1;
        for(int line = 0; line < size; line++){
            for(int column = 0; column < size; column++){
                rotateUp[column][index] = up[line][column];
            }
            index--;
        }
        this.getCube().updateFace(Face.Up, rotateUp);
    }
    
}
