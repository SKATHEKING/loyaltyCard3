import java.util.Scanner ;

import java.io.* ;

import java.io.PrintWriter ;

import java.io.IOException ;
/**
 * Write a description of class LoyaltyCardFiles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoyaltyCardFiles
{
    // instance variables - replace the example below with your own
    File inFile ;

    File outFile ;

    PrintWriter output;

    Scanner input ;

    /**
     * Constructor for objects of class LoyaltyCardFiles
     */
    public LoyaltyCardFiles(String inFilename, String outFilename)
    {
        input = new Scanner (System.in) ; 

        inFile = new File (inFilename ) ;

        if (!inFile.exists()) 
        {
            throw new IllegalStateException( inFilename + " does not exist exists");
        }

        outFile = new File (outFilename);

        if (outFile.exists()) 
        {
            throw new IllegalStateException( outFilename + " already exists");
        }

        makeLinks();
        processFiles();
        closeLinks();

    }

    public void makeLinks()
    {
        try {

            input = new Scanner(inFile) ;

            output = new PrintWriter(outFile) ;

        }
        catch(  Exception e)
        {
            System.out.println("FILE NOT FOUND");
            System.exit(0) ;

            System.out.println("Cant create that ");
            System.exit(0);  
        }

    }

    public void closeLinks()
    {

        try
        {
            input.close();
            
            output.close();
        }
        catch ( NullPointerException e)
        {
            System.err.println( " Scanner not assigned " );
        }

       

    }

    public void processFiles()
    {

        try
        {  
            if ( input.hasNext()) 
            {

                while(input.hasNext() || input.hasNextLine())
                {   
                    String title = input.next();
                    String name = input.next();
                    String surname = input.next();
                    String type = input.next();
                    int points = input.nextInt(); 
                    String lineStr = input.nextLine();

                     
                    input.nextLine();
                    System.out.print(title +"\t" + name + "\t" +surname+ "\t" +type+ "\t " + points + "\n"  );

                    
                    output.println(title +"\t" + name + "\t" +surname+ "\t" +type+ "\t " + points + "\n") ;
                }

            }
            else  
            {

                System.out.print(" \n no value found ");
            }

        }
        catch ( NullPointerException e)
        {
            System.err.println(" man cant read that still");

            System.err.println("I have not read or written something");
        }

       
    }
}
