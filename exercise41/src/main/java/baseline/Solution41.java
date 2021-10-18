/*
 *  UCF COP3330 Fall 2021 Assignment 41 Solution
 *  Copyright 2021 Joao Pedro Oliveira
 */

package baseline;

import java.util.*;
import java.io.*;


public class Solution41 {

/*
        Define the name sorter
        read from a scanner and put into array list
        add the names scanned to the list of names

        print the names in the files
        Create a file writing function for output

        write out header and output how many names there are in the file

        write the name of the files after the header a separator
        close out the file writing function


        create a scanner object that will read from input file
        declare arraylist for storing names
        read names from the input file by calling the function that reads names
        using the sort function sort the list of names
        close the scanner object

        write out the names
        have an exception in case of an error.
     */
public static class sortName{
    public static void readNames(Scanner input, ArrayList<String> names){
        while(input.hasNextLine())
        {
            names.add(input.nextLine());

        }
    }
}

    public static void outputName(ArrayList<String> names) throws IOException{
        FileWriter output = new FileWriter("exercise41_output.txt");

        output.write("Total of " +names.size()+ "names\n");
        output.write("-----------------------------\n");

        for(String i: names){
            output.write(i+"\n");
        }
        output.close();
    }

    public static void main(String[] args) throws FileNotFoundException{

        Scanner nameInput = new Scanner(new File("exercise41_input.txt"));

        ArrayList<String> names = new ArrayList<>();
        sortName.readNames (nameInput, names);

        names.sort(String.CASE_INSENSITIVE_ORDER);

        nameInput.close();

        try{
            outputName(names);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }




}

