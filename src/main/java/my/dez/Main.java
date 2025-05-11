package my.dez;

import java.util.Scanner;
import java.io.File;
import my.dez.FileCount;
import my.dez.issueCount;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String path;
        FileCount calculate;

        System.out.println("========= Files And Issues Calculator =========");

        boolean running = true;

        while (running)
        {
            System.out.println("Please Enter the Folder Path:");
            path = scan.nextLine();

            //declare the calculate to file count to check folder path
            calculate = new FileCount(path);

            //Check the file path is valid or not
            if (!calculate.ValidFol()) {
                System.out.println("Your Folder Path is incorrect! Please Enter a Valid Folder Path\n\n");
                continue;
            }

            boolean continueCounting = true;

            //Repeat Process and ask user to continue or not
            while (continueCounting)
            {
                File[] files = calculate.getFiles(); // Get all files
                issueCount counter = new issueCount(); //declare counter
                int issueCountResult = counter.countIss(files); // Count issues by compiling files
                int fileCount = files == null ? 0 : files.length; //Count number of Java files

                System.out.println("Number of Files (Java): " + fileCount);
                System.out.println("Number of Compilation Issues that has been solved(Java): " + issueCountResult);

                // Ask if the user wants to continue counting or not
                System.out.println("Would you like to continue counting? (Y/N): ");
                String choice = scan.nextLine().trim().toUpperCase();

                if (choice.equals("Y")) {
                    try {
                        Thread.sleep(5000); //Hold for 5 seconds before continuing
                    } catch (InterruptedException e) {
                        System.out.println("Process has been interrupted. Exiting...");
                        continueCounting = false;
                        break;
                    }
                } else {
                    continueCounting = false;
                }
            }

            // Ask if the user wants to enter another folder path or not
            System.out.println("Would you like to enter another folder path? (Y/N): ");
            String nextChoice = scan.nextLine().trim().toUpperCase();

            if (!nextChoice.equals("Y")) {
                running = false; // Exit the calculator
                System.out.println("Thank you for using the JAVA file and Issue calculator. Have a Nice Day, Goodbye!");
            }
        }
    }
}
