/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import structure.cube.movements.composite.EnumCompositeMovement;
import structure.cube.movements.primary.EnumPrimaryMovement;

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

//    public void creatingInitialPopulation() {
////        Chromosome chromosome = new Chromosome(this.lengthChromosome);
////        chromosome.genotype[0] = EnumPrimaryMovement.F1;
////        chromosome.genotype[1] = EnumPrimaryMovement.L2;
////        chromosome.genotype[2] = EnumPrimaryMovement.U1;
////        chromosome.genotype[3] = EnumPrimaryMovement.B;
////        chromosome.genotype[4] = EnumPrimaryMovement.U2;
////        chromosome.genotype[5] = EnumPrimaryMovement.R2;
////        chromosome.genotype[6] = EnumPrimaryMovement.F2;
////        chromosome.genotype[7] = EnumPrimaryMovement.D1;
////        chromosome.genotype[8] = EnumPrimaryMovement.F2;
////        chromosome.genotype[9] = EnumPrimaryMovement.U;
////        chromosome.genotype[10] = EnumPrimaryMovement.R;
////        chromosome.genotype[11] = EnumPrimaryMovement.B2;
////        chromosome.genotype[12] = EnumPrimaryMovement.U;
////        chromosome.genotype[13] = EnumPrimaryMovement.L2;
////        chromosome.genotype[14] = EnumPrimaryMovement.U1;
////        chromosome.genotype[15] = EnumPrimaryMovement.D;
////        chromosome.genotype[16] = EnumPrimaryMovement.R2;
////        chromosome.genotype[17] = EnumPrimaryMovement.F2;
////        chromosome.genotype[18] = EnumPrimaryMovement.U2;
////        chromosome.genotype[19] = EnumPrimaryMovement.D;
////        this.population[0] = chromosome;
//        for (int index = 0; index < this.population.length; index++) {
//            Chromosome chromosome = new Chromosome(this.lengthChromosome);
//            chromosome.initializeGenotype();
//            this.population[index] = chromosome;
//        }
//    }
    
    public void creatingInitialPopulation() {
        BufferedReader buffRead = null;
        try {
//            buffRead = new BufferedReader(new FileReader("semente.txt"));
            buffRead = new BufferedReader(new FileReader("semente3.txt"));
            String line = "";
            int index = 0;
            while (index < this.population.length) {
                if (line != null && !line.equals("")) {
                    String[] split = line.split("\\,");
                    Chromosome chromosome = new Chromosome(this.lengthChromosome);
                    for (int i = 0; i < this.lengthChromosome; i++) {
//                    int i = 0;
//                    int j = 0;
//                    while(i < this.lengthChromosome) {
//                        if (split[j].equals("B") || split[j].equals("D") || split[j].equals("F") || split[j].equals("L") || split[j].equals("R") || split[j].equals("U")) {
                            chromosome.genotype[i] = EnumCompositeMovement.valueOf(split[i]);
//                            chromosome.genotype[i] = EnumPrimaryMovement.valueOf(split[i]);
//                            i++;
//                        }
//                        j++;
                    }
                    this.population[index] = chromosome;
                    index++;
                }
                line = buffRead.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffRead.close();
            } catch (IOException ex) {
                Logger.getLogger(Generation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

//    public static void main(String[] args) throws IOException {
//        Generation generation = new Generation(10000, 500);
//        FileWriter arq = new FileWriter("semente3.txt");
//        PrintWriter gravarArq = new PrintWriter(arq);
//        generation.creatingInitialPopulation();
//        for (int p = 0; p < generation.population.length; p++) {
//            String line = generation.getChromosomeByIndex(p).genotype[0].toString();
//            for (int g = 1; g < generation.population[p].genotype.length; g++) {
//                line = line + "," + generation.getChromosomeByIndex(g).genotype[0].toString();
//            }
//            gravarArq.printf("%s\n",line);
//        }
//        arq.close();
//
//        System.out.printf("\nArquivo gravado com sucesso!!!\n");
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

    public void calculateFitness() {
        for (Chromosome chromosome : this.population) {
            chromosome.applyMovement();
        }
        List<Chromosome> c = Arrays.asList(this.population);
        Collections.sort(c, Collections.reverseOrder());
        this.population = (Chromosome[]) c.toArray();
//        System.out.println(this.population[0].getValueFitness());
    }

    public Chromosome getChromosomeByIndex(int index) {
        return this.population[index];
    }

    public Chromosome[] getChromosomes() {
        return this.population;
    }

//    public void avaiableChromossome(){
//        int sum = -1;
//        int indexBest = -1;
//        for(int indexChromosome = 0; indexChromosome < this.population.length; indexChromosome++){
//            this.population[indexChromosome].applyMovement();
//            if(sum == -1 || sum < this.population[indexChromosome].bestFitness){
//                sum = this.population[indexChromosome].bestFitness;
//                indexBest = indexChromosome;
//            }
//            this.population[indexChromosome].showChromosome();
//        }
//        System.out.println("\n\n\nMelhor Fitness: " + this.population[indexBest].bestFitness);
//        System.out.println("\n\n\nÍndice do Cromossomo: " + indexBest);
//        System.out.println("\n\n\nÍndice Final do Gene: " + this.population[indexBest].indexBestFitness);
//        this.population[indexBest].showChromosome();
//        this.population[indexBest].getPhenotype().printCube();
//    }
}
