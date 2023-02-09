
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.Scanner;

public class Client {

    //Using aggregation here 
    //Using Stack data structure
    public static Stack<Baby> babies = new Stack<>();

    //Static method
    public static void main(String[] args) {
        writeDataInStackFromFile();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Here is the menu");
            System.out.println("1. Write Data in files");
            System.out.println("2. Search by Name");
            System.out.println("3. Show All babies data");
            System.out.println("4. Exit");
            System.out.print("Enter your Choice:> ");
            String choice = input.next();
            if (choice.equalsIgnoreCase("1")) {
                System.out.println("Writing Data in Files");
                sortByName();
                writeDataInSortFiles("SortByName.txt");
                sortByAge(babies, babies.size());
                writeDataInSortFiles("SortByAge.txt");
                System.out.println("Written in files");
            } else if (choice.equalsIgnoreCase("2")) {
                System.out.println("Searching...");
                System.out.print("Enter Name for search:> ");
                String name = input.next();
                //Linear Searching
                for (Baby baby : babies) {
                    if (baby.getName().equalsIgnoreCase(name)) {
                        System.out.println(baby.toString());
                    }
                }
            } else if (choice.equalsIgnoreCase("3")) {
                System.out.println("All Babies");
                for (Baby baby : babies) {
                    System.out.println(baby.toString());
                }
            } else if (choice.equalsIgnoreCase("4")) {
                System.out.println("Good Bye:)");
                System.exit(0);
            } else {                
                System.out.println("Enter valid choice...");
            }
        }

    }

    //Insertion Sort
    public static void sortByName() {
        int in, out;
        for (out = 1; out < babies.size(); out++) {
            Baby temp = babies.get(out);

            in = out;
            while (in > 0
                    && babies.get(in - 1).getName().compareTo(temp.getName()) > 0) {
                babies.set(in, babies.get(in - 1));
                --in;

            }
            babies.set(in, temp);
        }
    }

    //Bubble sort
    public static void sortByAge(Stack<Baby> stack, int n) {
        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (stack.get(i).getAge() > stack.get(i + 1).getAge()) {
                int temp = stack.get(i).getAge();
                stack.get(i).setAge(stack.get(i + 1).getAge());
                stack.get(i + 1).setAge(temp);
            }
        }
        //Recursion used here
        sortByAge(stack, n - 1);
    }

    //Static method
    public static void writeDataInStackFromFile() {
        //File handling Input file
        File file = new File("InputData.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                System.out.println(parts[0]);
                //Here use polymorphism to add Patient and Playgroup class objects in Baby class type stack 
                if (parts[0].equalsIgnoreCase("patient")) {
                    babies.push(new Patient(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                    Baby.babyNumbers++;
                } else if (parts[0].equalsIgnoreCase("baby")) {
                    babies.push(new Baby(parts[1], Integer.parseInt(parts[2])));
                    Baby.babyNumbers++;
                } else if (parts[0].equalsIgnoreCase("playgroup")) {
                    babies.push(new Playgroup(parts[1], Integer.parseInt(parts[2])));
                    Baby.babyNumbers++;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Exception: " + ex);
        }

    }

    //Static method
    public static void writeDataInSortFiles(String fileName) {
        //Write in file Output File
        File outputFile = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            for (int i = 0; i < babies.size(); i++) {
                fileWriter.write(babies.get(i).toString() + "\n" + babies.get(i).BabySound() + "\n");
            }
            fileWriter.write("Total number of babies: " + Baby.babyNumbers);
            fileWriter.close();            
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
