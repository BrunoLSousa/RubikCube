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
public class Right extends Rotation {

    public Right(Cube cube) {
        super(cube);
    }

    @Override
    public void rotateQuarterClockwise() {
        rotateFrontToUp();
        rotateUpToBack();
        rotateBackToDown();
        rotateDownToFront();
        rotateRight();
    }

    private void rotateFrontToUp() {
        String[][] front = this.getCube().getViewFace(Face.Front);
        String[][] up = this.getCube().getViewFace(Face.Up);
        int column = front.length;
        this.cachePosition = new String[column];
        for (int line = 0; line < column; line++) {
            this.cachePosition[line] = up[line][column - 1];
            up[line][column - 1] = front[line][column - 1];
        }
        this.getCube().updateFace(Face.Up, up);
    }

    private void rotateUpToBack() {
        String[][] back = this.getCube().getViewFace(Face.Back);
        int column = back.length;
        String[] newCachePosition = new String[column];
        int index = column - 1;
        for (int line = 0; line < column; line++) {
            newCachePosition[line] = back[line][0];
            back[line][0] = this.cachePosition[index];
            index--;
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Back, back);
    }

    private void rotateBackToDown() {
        String[][] down = this.getCube().getViewFace(Face.Down);
        int column = down.length;
        String[] newCachePosition = new String[column];
        int index = column - 1;
        for (int line = 0; line < column; line++) {
            newCachePosition[line] = down[line][column - 1];
            down[line][column - 1] = this.cachePosition[index];
            index--;
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Down, down);
    }

    private void rotateDownToFront() {
        String[][] front = this.getCube().getViewFace(Face.Front);
        int column = front.length;
        for (int line = 0; line < column; line++) {
            front[line][column - 1] = this.cachePosition[line];
        }
        this.getCube().updateFace(Face.Front, front);
    }

    private void rotateRight() {
        String[][] right = this.getCube().getViewFace(Face.Right);
        int size = right.length;
        String[][] rotateRight = new String[size][size];
        int index = size - 1;
        for(int line = 0; line < size; line++){
            for(int column = 0; column < size; column++){
                rotateRight[column][index] = right[line][column];
            }
            index--;
        }
        this.getCube().updateFace(Face.Right, rotateRight);
    }

}
