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
public class Left extends RotationFace {

    public Left() {
        
    }

    //método responsável por rotacionar a face left do cubo em 90º sentido horário.
    @Override
    public Cube rotateQuarterClockwise() {
        rotateFrontToDown();
        rotateDownToBack();
        rotateBackToUp();
        rotateUpToFront();
        rotateLeft();
        return this.getCube();
    }

    private void rotateFrontToDown() {
        String[][] front = this.getCube().getViewFace(Face.Front);
        String[][] down = this.getCube().getViewFace(Face.Down);
        int column = front.length;
        this.cachePosition = new String[column];
        for (int line = 0; line < column; line++) {
            this.cachePosition[line] = down[line][0];
            down[line][0] = front[line][0];
        }
        this.getCube().updateFace(Face.Down, down);
    }

    private void rotateDownToBack() {
        String[][] back = this.getCube().getViewFace(Face.Back);
        int column = back.length;
        String[] newCachePosition = new String[column];
        int index = column - 1;
        for (int line = 0; line < column; line++) {
            newCachePosition[line] = back[line][column - 1];
            back[line][column - 1] = this.cachePosition[index];
            index--;
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Back, back);
    }

    private void rotateBackToUp() {
        String[][] up = this.getCube().getViewFace(Face.Up);
        int column = up.length;
        String[] newCachePosition = new String[column];
        int index = column - 1;
        for (int line = 0; line < column; line++) {
            newCachePosition[line] = up[line][0];
            up[line][0] = this.cachePosition[index];
            index--;
        }
        this.cachePosition = newCachePosition;
        this.getCube().updateFace(Face.Up, up);
    }

    private void rotateUpToFront() {
        String[][] front = this.getCube().getViewFace(Face.Front);
        int column = front.length;
        for (int line = 0; line < column; line++) {
            front[line][0] = this.cachePosition[line];
        }
        this.getCube().updateFace(Face.Front, front);
    }

    private void rotateLeft() {
        String[][] left = this.getCube().getViewFace(Face.Left);
        int size = left.length;
        String[][] rotateLeft = new String[size][size];
        int index = size - 1;
        for(int line = 0; line < size; line++){
            for(int column = 0; column < size; column++){
                rotateLeft[column][index] = left[line][column];
            }
            index--;
        }
        this.getCube().updateFace(Face.Left, rotateLeft);
    }

}
