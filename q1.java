import java.util.Scanner;                                                                               
public class q1 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int totalNumberOfStudents = 0, numberOfAs = 0, numberOfBs = 0, numberOfCs = 0, numberOfDs = 0;
		int gradeHolder = 0, totalGrade = 0; 
        char flag = 'c';
        do{
            System.out.println("Enter a grade");
            gradeHolder = s.nextInt();
		   	totalGrade += gradeHolder;
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
            System.out.println("Enter q to quit, otherwise enter anything to continue");
            flag = s.next().charAt(0);  
        }while(flag != 'q');
        System.out.println("Total number of A: " + numberOfAs);
        System.out.println("Total number of B: " + numberOfBs);
        System.out.println("Total number of C: " + numberOfCs);
        System.out.println("Total number of D: " + numberOfDs);
		System.out.println("Average: " + totalGrade / totalNumberOfStudents); 
        System.out.println("Total number of students " + totalNumberOfStudents);
        s.close();
    }
}
/*
import java.util.Scanner;
public class q1
{
	public static void getMean(final int total, final int totalGrade)
	{
		System.out.println("Average grade is: " + (total / totalGrade));
	}
	public static void pln(final String str)
	{
		System.out.println(str);
	}	
	public static void pStat(final char c, final int numberOf)
	{
		System.out.println("Total number of " + c + ": " + numberOf);
	}
	public static void menu()
	{
			Scanner s = new Scanner(System.in);
			int totalNumberOfStudents = 0, numberOfAs = 0, numberOfBs = 0, numberOfCs = 0, numberOfDs = 0;
			int gradeHolder = 0, totalGrade = 0; 
			char flag = 'c';
			do{
					System.out.println("Enter a grade");
					gradeHolder = s.nextInt();
					totalGrade += gradeHolder;
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
					pln("Enter q to quit, otherwise enter anything to continue");
					flag = s.next().charAt(0);  
	        }while(flag != 'q');
			s.close();
		    pStat('A',numberOfAs);
		    pStat('B',numberOfBs);
		    pStat('C', numberOfCs);
		    pStat('D', numberOfDs);
		   	getMean(totalGrade, totalNumberOfStudents);	
	}
	public static void main(String[] args)
	{
			menu();
	}
}
*/
