import java.util.Scanner;                                                                                    

public class main

{

     public static void printName(String name)
     {
        int x = 0; 
        String space = " ";
        while(name.charAt(x) != space.charAt(0))
        {
            x++;
        }
        System.out.println(name.substring(x));
     }
     public static void main(String[] args)

     {
         Scanner s = new Scanner(System.in);

         int totalNumberOfStudents = 0, numberOfAs = 0, numberOfBs = 0, numberOfCs = 0, numberOfDs = 0, gradeHolder, cumGrade = 0;
         String name;
         char flag = 'c';
         System.out.println("Enter your name");
         name = s.nextLine();
         do{
             System.out.println("Enter a grade");

             gradeHolder = s.nextInt(); 
             cumGrade += gradeHolder;

             if(gradeHolder >= 90)

             {
                 numberOfAs += 1;
             }
             else if(gradeHolder >= 80)
             {
                 numberOfBs += 1;
             }
             else if(gradeHolder >= 70)
             {
                 numberOfCs += 1;
             }
             else
             {
                 numberOfDs += 1; 
             }

             totalNumberOfStudents += 1; 
             System.out.println("Enter q to quit, c to continue");
             flag = s.next().charAt(0);  

         }while(flag != 'q');

         System.out.println("Number of A: " + numberOfAs);
         System.out.println("Number of B: " + numberOfBs);
         System.out.println("Number of C: " + numberOfCs);
         System.out.println("Number of D: " + numberOfDs);
         System.out.println("The average of this class is: " + cumGrade / totalNumberOfStudents);
         System.out.println("Total number of students " + totalNumberOfStudents);
         printName("Goodbye prof " + name);
         s.close();

     }
}
