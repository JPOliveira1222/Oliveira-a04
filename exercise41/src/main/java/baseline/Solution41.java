/*
 *  UCF COP3330 Fall 2021 Assignment 41 Solution
 *  Copyright 2021 Joao Pedro Oliveira
 */

package baseline;

import java.util.*;
import java.io.*;


public class Solution41 {
    
    //defining class sortName
public static class sortName{

    //defining readNames function to read data from scanner object
    public static void readNames(Scanner input, ArrayList<String> names){

        ////reading data until an empty line
        while(input.hasNextLine())
        {
            //adding the read line to the list of names
            names.add(input.nextLine());

        }
    }
}
    //defining function to print out names in the file
    public static void outputName(ArrayList<String> names) throws IOException{

        //creating file writer to output new list of names
        FileWriter output = new FileWriter("exercise41_output.txt");

        //writing header
        output.write("Total of " +names.size()+ "names\n");
        output.write("-----------------------------\n");

        //writing names after the header and separator
        for(String i: names){
            output.write(i+"\n");
        }
        //closing to avoid memory leak
        output.close();
    }

    public static void main(String[] args) throws FileNotFoundException{

        //creating scanner object to read from input file
        Scanner nameInput = new Scanner(new File("exercise41_input.txt"));

        //declaring array list to store the names
        ArrayList<String> names = new ArrayList<>();

        //reading the names from the input file by calling the name reading function
        sortName.readNames (nameInput, names);

        //sorting the names
        names.sort(String.CASE_INSENSITIVE_ORDER);

        //closing the scanner
        nameInput.close();

        //writing to the output file
        try{
            outputName(names);

        }

        //if there is an exception, write to the console while creating output file
        catch (Exception e)
        {
            System.out.println(e);
        }



    }




}

