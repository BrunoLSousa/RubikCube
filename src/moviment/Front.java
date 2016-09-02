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
public class Front extends Movement {

    public Front(Cube cube) {
        super(cube);
    }

    @Override
    public void rotateQuarterClockwise() {
        rotateUpToRight();
        rotateRightToDown();
        rotateDownToLeft();
        rotateLeftToUp();
        rotateFront();
    }

    @Override
    public void rotateQuarterCounterclockwise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void rotateUpToRight() {
        String[][] up = this.getCube().getViewFace(Face.Up);
        String[][] right = this.getCube().getViewFace(Face.Right);
        int line = up.length;
        this.cachePosition = new String[line];
        for (int column = 0; column < line; column++) {
            this.cachePosition[column] = right[column][0];
            right[column][0] = up[line - 1][column];
        }
        this.getCube().updateFace(Face.Right, right);
    }

    private void rotateRightToDown() {
        String[][] down = this.getCube().getViewFace(Face.Down);
        int line = down.length;
        String[] newCachePosition = new String[line];
        int column = 0;
        for (int index = (line - 1); index >= 0; index--) {
            newCachePosition[column] = down[0][column];
            down[0][column] = this.cachePosition[index];
            column++;
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Down, down);
    }

    private void rotateDownToLeft() {
        String[][] left = this.getCube().getViewFace(Face.Left);
        int line = left.length;
        String[] newCachePosition = new String[line];
        for (int column = 0; column < line; column++) {
            newCachePosition[column] = left[column][line - 1];
            left[column][line - 1] = this.cachePosition[column];
        }
        this.cachePosition = newCachePosition; 
        this.getCube().updateFace(Face.Left, left);
    }

    private void rotateLeftToUp() {
        String[][] up = this.getCube().getViewFace(Face.Up);
        int line = up.length;
        int index = 0;
        for (int column = (line - 1); column >= 0; column--) {
            up[line - 1][column] = this.cachePosition[index];
            index++;
        }
        this.getCube().updateFace(Face.Up, up);
    }

    private void rotateFront() {
        String[][] front = this.getCube().getViewFace(Face.Front);
        int size = front.length;
        String[][] rotateFront = new String[size][size];
        int index = size - 1;
        for(int line = 0; line < size; line++){
            for(int column = 0; column < size; column++){
                rotateFront[column][index] = front[line][column];
            }
            index--;
        }
        this.getCube().updateFace(Face.Front, rotateFront);
    }

}
