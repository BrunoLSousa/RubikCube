/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.cube;

import java.util.HashMap;

/**
 *
 * @author bruno
 */
public class Cube {
    
    private HashMap<Face, String[][]> cube;

    public Cube(HashMap<Face, String[][]> cube) {
        this.cube = new HashMap<>();
        cloneCube(cube);
    }

    public Cube(Cube cube) {
        this.cube = new HashMap<>();
        cloneCube(cube);
    }
    
    private void cloneCube(HashMap<Face, String[][]> cube) {
        this.cube = new HashMap<>();
        for (Face f : Face.values()) {
            String[][] face = new String[3][3];
            String[][] faceConvertion = cube.get(f);
            for (int line = 0; line < 3; line++) {
                for (int column = 0; column < 3; column++) {
                    face[line][column] = faceConvertion[line][column];
                }
            }
            this.cube.put(f, face);
        }
    }
    
    private void cloneCube(Cube cube) {
        this.cube = new HashMap<>();
        for (Face f : Face.values()) {
            String[][] face = new String[3][3];
            String[][] faceConvertion = cube.getViewFace(f);
            for (int line = 0; line < 3; line++) {
                for (int column = 0; column < 3; column++) {
                    face[line][column] = faceConvertion[line][column];
                }
            }
            this.cube.put(f, face);
        }
    }
    
    public String[][] getViewFace(Face face){
        return this.cube.get(face);
    }
    
    public int getAmountFace(){
        return this.cube.size();
    }
    
    public int getConfiguration(){
        if(this.cube != null){
            return this.cube.get(Face.Front).length;
        }
        return 0;
    }
    
    //atualiza determinada face do cubo.
    public void updateFace(Face key, String[][] face){
        this.cube.remove(key);
        this.cube.put(key, face);
    }
    
    public void printCube(){
        for(Face face : Face.values()){
            String[][] f = cube.get(face);
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
