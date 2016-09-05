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

    public Cube() {
        this.cube = new HashMap<>();
        initializeCube();
    }
    
    private void initializeCube(){
        //fazer aqui o upload do arquivo de teste.
        
        String[][] front = {{"G", "B", "B"}, {"G", "O", "O"}, {"G", "W", "W"}};
        String[][] left = {{"B", "O", "R"}, {"G", "G", "Y"}, {"B", "B", "R"}};
        String[][] right = {{"R", "O", "B"}, {"W", "B", "W"}, {"G", "R", "Y"}};
        String[][] back = {{"O", "B", "R"}, {"B", "R", "R"}, {"O", "W", "Y"}};
        String[][] up = {{"W", "Y", "W"}, {"Y", "Y", "G"}, {"Y", "R", "Y"}};
        String[][] down = {{"W", "G", "O"}, {"O", "W", "Y"}, {"O", "R", "G"}};
        
        this.cube.put(Face.Front, front);
        this.cube.put(Face.Left, left);
        this.cube.put(Face.Right, right);
        this.cube.put(Face.Back, back);
        this.cube.put(Face.Up, up);
        this.cube.put(Face.Down, down);
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
