/*
 *  UCF COP3330 Fall 2021 Assignment 43 Solution
 *  Copyright 2021 Joao Pedro Oliveira
 */
package baseline;

import java.io.*;
import java.util.Scanner;

public class Solution43 {

    /*

     create 2 variables for javascript and css
    js = N
    css = N

    Create a new scanner
    print "Site name: "
    siteName = user input

    print "Author: "
    author = user input

    print "Do you want a folder for JavaScript? "
    scan user input for js
    if user input matches variables, do not create folders

    scan user input for css
    if user input matches variables, do not create folders

    create a path using a directory = currentPath

    if a website is created, then print "Created " + currentPath

    if user input for creating a javascript and css folder = Y || y

    create file paths using the directory

    if not print "Js folder not created" || "CSS folder not created"

    use exception to catch errors.
    Print "Index.html not created as required"
    or "Website folder not created"

    close

     */

    public static void main(String[] args) {
        //creating scanner
        Scanner scan = new Scanner(System.in);

        //initializing strings
        String path;
        String author;
        String siteName;

        //initializing characters for JS and CSS prompts
        char JS;
        char CSS;

        //asking user for site name, author, and if they want a JS and CSS folder
        System.out.println("Site name: ");
        siteName = scan.nextLine();

        System.out.println("Author: ");
        author = scan.nextLine();

        System.out.println("Do you want a folder for JavaScript?");
        JS = scan.next().charAt(0);

        System.out.println("Do you want a folder for CSS?");
        CSS = scan.next().charAt(0);


        //Creating a path using the users directory
        path = System.getProperty("user.dir");
        path += "\\" +siteName;

        //creating website file
        File website = new File(path);

        //checking to see if website is created or not
        boolean websiteCreated = website.mkdir();


        //creating website using given author name and site names in the user directory
        if (websiteCreated){
            System.out.println("Created "+path);
            try{
                FileWriter skeletonWriter = new FileWriter(path+"\\index.html");
                skeletonWriter.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                skeletonWriter.write("\t<meta author=\""+author+"\">\n");
                skeletonWriter.write("\t<title>"+siteName+"</title>\n");
                skeletonWriter.write("</head>\n<body>\n\n</body>\n</html>");
                skeletonWriter.close();
                System.out.println("Created " + path+"\\index.html");

                //exception
            } catch (IOException e) {
                e.printStackTrace();
            }

            //depending on user answer for JS folder, create a path
            if(JS == 'Y' || JS == 'y'){
                File jsFolder = new File(path+ "\\JS");
                boolean jsMade = jsFolder.mkdir();
                if(jsMade){
                    System.out.println("Created " +jsFolder+"\\");
                }

                //otherwise print that a JS folder was not created
                else {
                    System.out.println("JS folder not created!");
                }
                }

            //depending on user answer for CSS folder, create a path
            if(CSS == 'y' || CSS == 'Y')
            {
                File cssFolder = new File(path+"\\css");
                boolean cssCreated = cssFolder.mkdir();
                if(cssCreated)
                {
                    System.out.println("Created " + cssFolder+"\\");
                }

                //otherwise print that a CSS folder was not created
                else
                {
                    System.out.println("CSS folder not created!");
                }
            }
        }


    }

}
