/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default_package;

import geometry.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santosh
 */
public class Tester {
////////////////////////////////////// class that implements comparator
    public static class Sorting implements Comparator<Geom> {

        @Override
        public int compare(Geom geom1, Geom geom2) {
            if (geom1.computeVolume() < geom2.computeVolume()) {
                return 1;
            } else if (geom1.computeVolume() == geom2.computeVolume()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
////////////////////////////////////// initializing objects and calling read method
        ArrayList<Geom> geomList = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim();
                if (word.equalsIgnoreCase("Sphere")) {
                    Geom geom = new Sphere(0.0);
                    geom.read(br);
                    geomList.add(geom);
                } else if (word.equalsIgnoreCase("Cylinder")) {
                    Geom geom = new Cylinder(0.0, 0.0);
                    geom.read(br);
                    geomList.add(geom);
                } else if (word.equalsIgnoreCase("Cube")) {
                    Geom geom = new Cube(0.0);
                    geom.read(br);
                    geomList.add(geom);
                } else if (word.equalsIgnoreCase("Square")) {
                    Geom geom = new Square(0.0, 0.0);
                    geom.read(br);
                    geomList.add(geom);
                } else if (word.equalsIgnoreCase("Rectangle")) {
                    Geom geom = new Rectangle(0.0, 0.0, 0.0);
                    geom.read(br);
                    geomList.add(geom);
                } else if (word.equalsIgnoreCase("Circle")) {
                    Geom geom = new Circle(0.0, 0.0);
                    geom.read(br);
                    geomList.add(geom);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error message" + ex.getMessage());
        }
        
        System.out.println("The list of geometries as read from sample.txt file" + "\n");

///////////////////////////////////////////// converting arraylist to array
        Geom[] geomArray = new Geom[geomList.size()];
        for (int i = 0; i < geomList.size(); i++) {
            geomArray[i] = geomList.get(i);
            System.out.println(geomList.get(i) + "\n");

        }

//////////////////////////////////////// using Arrays.sort() to sort geomArray
        Arrays.sort(geomArray, new Sorting());
        System.out.println("After sorting the geometry array in descending order of their volume"+ "\n");

/////////////////////////////////////////////////////// calling toString method
        for (int i = 0; i < geomArray.length; i++) {
            System.out.println("Current object: geomArray[" + i + "]");
            geomArray[i].printDescription();
            System.out.println(geomArray[i].toString() + "\n");
        }

        try {
            try (PrintWriter printer = new PrintWriter(new FileWriter("SortedGeoms.txt"))) {
                for (Geom geomArray1 : geomArray) {
                    printer.print(geomArray1 + "\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
            /////////////////////////////////////////calling equals and isLargerThan method
            for (Geom geomArray1 : geomArray) {
            for (Geom geomArray2 : geomArray) {
            if (geomArray1.equals(geomArray2)) {
            System.out.println("the objects " + geomArray1.getClass() + " and " + geomArray2.getClass() + " are same");
            } else {
            System.out.println("the objects " + geomArray1.getClass() + " and " + geomArray2.getClass() + " are different");
            }
            switch (geomArray1.isLargerThan(geomArray2)) {
            case 1:
            System.out.println(geomArray1.getClass() + " with volume " + geomArray1.computeVolume() + " is larger than " + geomArray2.getClass() + " with volume " + geomArray2.computeVolume() + "\n");
            break;
            case -1:
            System.out.println(geomArray1.getClass() + " with volume " + geomArray1.computeVolume() + " is smaller than " + geomArray2.getClass() + " with volume " + geomArray2.computeVolume() + "\n");
            break;
            case 0:
            System.out.println(geomArray1.getClass() + " with volume " + geomArray1.computeVolume() + " is equal to " + geomArray2.getClass() + " with volume " + geomArray2.computeVolume() + "\n");
            break;
            default:
            break;
            }
            }
            }  */

    }
}
