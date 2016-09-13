/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikcube;

import java.util.HashMap;
import structure.cube.Face;

/**
 *
 * @author bruno
 */
public class Scanner {

    private java.util.Scanner scanner = null;

    public Scanner() {
        this.scanner = new java.util.Scanner(System.in);
    }

    public HashMap<Face, String[][]> scan(){
        String configurationte = scanConfigurationCube();
        HashMap<Face, String[][]> cube = scanCube();
        return cube;
    }
    
    private String scanConfigurationCube() {
        String configuracaoGrafo = this.scanner.nextLine();
        return configuracaoGrafo;
    }

    private HashMap<Face, String[][]> scanCube() {
        HashMap<Face, String[][]> cube = new HashMap<>();
        int i = 0;
        while (i < 6) {
            String nameFace = this.scanner.nextLine();
            String[][] face = scanFace();
            Face key = Face.valueOf(nameFace);
            cube.put(key, face);
            i++;
        }
        return cube;
    }

    private String[][] scanFace() {
        String[][] face = new String[3][3];
        int i = 0;
        while(i < 3){
            String line = this.scanner.nextLine();
            String[] split = line.split(" ");
            face[i][0] = split[0];
            face[i][1] = split[1];
            face[i][2] = split[2];
            i++;
        }
        return face;
    }

}
