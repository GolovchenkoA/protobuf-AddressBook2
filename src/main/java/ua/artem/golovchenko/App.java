package ua.artem.golovchenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        System.out.println( "Input number");
        System.out.println( "1. List People");
        System.out.println( "2. Create new contact");
        System.out.println( "0. Exit");

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int  num = (Integer.valueOf(stdin.readLine()));

        System.out.println("Input absolute path to file with data");

        String pathToFile = (stdin.readLine());

        switch (num) {
            case 1: ListPeople.main(new String[]{pathToFile}); break;
            case 2: AddPerson.main(new String[]{pathToFile}); break;
            default: System.exit(0); break;
        }
    }
}
