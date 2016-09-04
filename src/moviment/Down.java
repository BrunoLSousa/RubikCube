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
public class Down extends Rotation{

    public Down(Cube cube) {
        super(cube);
    }

    @Override
    public void rotateQuarterClockwise() {
        rotateFrontToRight();
        rotateRightToBack();
        rotateBackToLeft();
        rotateLeftToFront();
        rotateDown();
    }
    
    private void rotateFrontToRight(){
        String[][] front = this.getCube().getViewFace(Face.Front);
        String[][] right = this.getCube().getViewFace(Face.Right);
        int line = front.length;
        this.cachePosition = new String[line];
        for (int column = 0; column < line; column++) {
            this.cachePosition[column] = right[line - 1][column];
            right[line - 1][column] = front[line - 1][column];
        }
        this.getCube().updateFace(Face.Right, right);
    }
    
    private void rotateRightToBack(){
        String[][] back = this.getCube().getViewFace(Face.Back);
        int line = back.length;
        String[] newCachePosition = new String[line];
        for (int column = 0; column < line; column++) {
            newCachePosition[column] = back[line - 1][column];
            back[line - 1][column] = this.cachePosition[column];
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Back, back);
    }
    
    private void rotateBackToLeft(){
        String[][] left = this.getCube().getViewFace(Face.Left);
        int line = left.length;
        String[] newCachePosition = new String[line];
        for (int column = 0; column < line; column++) {
            newCachePosition[column] = left[line - 1][column];
            left[line - 1][column] = this.cachePosition[column];
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Left, left);
    }
    
    private void rotateLeftToFront(){
        String[][] front = this.getCube().getViewFace(Face.Front);
        int line = front.length;
        for (int column = 0; column < line; column++) {
            front[line - 1][column] = this.cachePosition[column];
        }
        this.getCube().updateFace(Face.Front, front);
    }
    
    private void rotateDown(){
        String[][] down = this.getCube().getViewFace(Face.Down);
        int size = down.length;
        String[][] rotateDown = new String[size][size];
        int index = size - 1;
        for(int line = 0; line < size; line++){
            for(int column = 0; column < size; column++){
                rotateDown[column][index] = down[line][column];
            }
            index--;
        }
        this.getCube().updateFace(Face.Down, rotateDown);
    }
    
}
