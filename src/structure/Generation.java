/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import structure.cube.Cube;
import structure.cube.Face;
import structure.cube.movements.EnumCompositeMovement;

/**
 *
 * @author bruno
 */
public class Generation {

    private Chromosome[] population;
    private int lengthChromosome;

    public Generation(int lengthPopulation, int lengthChromosome) {
        this.population = new Chromosome[lengthPopulation];
        this.lengthChromosome = lengthChromosome;
    }

    public void creatingInitialPopulation(Cube cube) {
        for (int index = 0; index < this.population.length; index++) {
            Chromosome chromosome = new Chromosome(this.lengthChromosome, cube);
            chromosome.initializeGenotype();
            this.population[index] = chromosome;
        }
    }
    
//    public void creatingInitialPopulation(Cube cube) {
//        BufferedReader buffRead = null;
//        try {
////            buffRead = new BufferedReader(new FileReader("semente.txt"));
//            buffRead = new BufferedReader(new FileReader("semente3.txt"));
//            String line = "";
//            int index = 0;
//            while (index < this.population.length) {
//                if (line != null && !line.equals("")) {
//                    String[] split = line.split("\\,");
//                    Chromosome chromosome = new Chromosome(this.lengthChromosome, cube);
//                    for (int i = 0; i < this.lengthChromosome; i++) {
////                    int i = 0;
////                    int j = 0;
////                    while(i < this.lengthChromosome) {
////                        if (split[j].equals("B") || split[j].equals("D") || split[j].equals("F") || split[j].equals("L") || split[j].equals("R") || split[j].equals("U")) {
//                            chromosome.genotype[i] = EnumCompositeMovement.valueOf(split[i]);
////                            chromosome.genotype[i] = EnumPrimaryMovement.valueOf(split[i]);
////                            i++;
////                        }
////                        j++;
//                    }
//                    this.population[index] = chromosome;
//                    index++;
//                }
//                line = buffRead.readLine();
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                buffRead.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//    }

    public void addChromosome(int index, Chromosome chromosome) {
        this.population[index] = chromosome;
    }

    public void showGeneration() {
        for (Chromosome chromosome : this.population) {
            chromosome.showChromosome();
            System.out.println();
        }
    }
    
    //método responsável por aplicar os movimentos no fenótipo.
    public void calculateFitness() {
        for (Chromosome chromosome : this.population) {
            chromosome.applyMovement();
        }
        List<Chromosome> c = Arrays.asList(this.population);
        Collections.sort(c, Collections.reverseOrder());
        this.population = (Chromosome[]) c.toArray();
    }

    public Chromosome getChromosomeByIndex(int index) {
        return this.population[index];
    }

    public Chromosome[] getChromosomes() {
        return this.population;
    }

}
