/*
 *  UCF COP3330 Fall 2021 Assignment 42 Solution
 *  Copyright 2021 Joao Pedro Oliveira
 */
package baseline;

import java.util.*;
import java.io.*;

public class Solution42 {
    
    public static void main(String[] args) {

        //prints out employee information from input file
        Employee emp = new Employee();
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary");
        System.out.println("----------------------------------------");
        emp.printDetails("exercise42_input.txt");
    }
}

    class Employee {

        //Method to print details
        public void printDetails(String filename) {
            try {

                File file = new File(filename);

                //scan file
                Scanner scan = new Scanner(file);

                //read out file details as long as file has next line
                while (scan.hasNext()) {
                    String s = scan.nextLine();
                    String[] temp = s.split(",");

                    //print out with spaces
                    System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]);
                }


                //exception in case file is not found
            } catch (FileNotFoundException ex) {
                System.out.println("Error: File Not Found!!");
            }
        }
    }





