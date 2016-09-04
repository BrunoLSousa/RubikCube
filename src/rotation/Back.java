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
public class Back extends Rotation {

    public Back(Cube cube) {
        super(cube);
    }

    @Override
    public void rotateQuarterClockwise() {
        rotateUpToLeft();
        rotateLeftToDown();
        rotateDownToRight();
        rotateRightToUp();
        rotateBack();
    }

    private void rotateUpToLeft() {
        String[][] up = this.getCube().getViewFace(Face.Up);
        String[][] left = this.getCube().getViewFace(Face.Left);
        int line = up.length;
        int column = line - 1;
        this.cachePosition = new String[line];
        for (int index = 0; index < line; index++) {
            this.cachePosition[index] = left[index][0];
            left[index][0] = up[0][column];
            column--;
        }
        this.getCube().updateFace(Face.Left, left);
    }

    private void rotateLeftToDown() {
        String[][] down = this.getCube().getViewFace(Face.Down);
        int line = down.length;
        String[] newCachePosition = new String[line];
        int column = line - 1;
        for (int index = 0; index < line; index++) {
            newCachePosition[index] = down[line - 1][index];
            down[line - 1][index] = this.cachePosition[column];
            column--;
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Down, down);
    }

    private void rotateDownToRight() {
        String[][] right = this.getCube().getViewFace(Face.Right);
        int column = right.length;
        String[] newCachePosition = new String[column];
        int line = column - 1;
        for (int index = 0; index < column; index++) {
            newCachePosition[index] = right[index][column - 1];
            right[index][column - 1] = this.cachePosition[line];
            line--;
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Right, right);
    }

    private void rotateRightToUp() {
        String[][] up = this.getCube().getViewFace(Face.Up);
        int line = up.length;
        for (int index = 0; index < line; index++) {
            up[0][index] = this.cachePosition[index];
        }
        this.getCube().updateFace(Face.Up, up);
    }

    private void rotateBack() {
        String[][] back = this.getCube().getViewFace(Face.Back);
        int size = back.length;
        String[][] rotateBack = new String[size][size];
        int index = size - 1;
        for (int line = 0; line < size; line++) {
            for (int column = 0; column < size; column++) {
                rotateBack[column][index] = back[line][column];
            }
            index--;
        }
        this.getCube().updateFace(Face.Back, rotateBack);
    }

}
