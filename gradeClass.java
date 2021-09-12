import java.util.Scanner;
public class main{
    int numA, numB, numC, numD, numF, gradeHolder, gradeCount, average, totalGrade;
    String name; 

    public void getName(Scanner s)
    {
            System.out.println("Enter your name");
            String space = " ", comma = ",", str;
            str = s.nextLine();
            int pos = 0;
            while(true)
            {
                    if(str.charAt(pos) == space.charAt(0))
                    {
                            this.name = str.substring(pos+1);
                            break;
                    }
                    if(str.charAt(pos) == comma.charAt(0))
                    {
                            this.name = str.substring(0,pos);
                            break;
                    }
                    pos++;
            }
    }
    public void addGrade()
    {
            if(this.gradeHolder >= 90)
            {
                    this.numA ++;
            }
            else if(this.gradeHolder >= 80)
            {
                    this.numB ++;
            }
            else if(this.gradeHolder >= 70)
            {
                    this.numC ++;
            }
            else if(this.gradeHolder >= 60)
            {
                    this.numD ++;
            }
            else
            {
                    this.numF ++;
            }
    }

    public void finalize()
    {
            System.out.println("Professor " + this.name +"'s class");
            System.out.println("Average: " + this.totalGrade / this.gradeCount);
    }
    public void getGrade()
    {
            Scanner s = new Scanner(System.in);
            int flag;
            getName(s);
            do{
                    System.out.println("Enter a grade");
                    this.gradeHolder = s.nextInt();
                    this.gradeCount ++;
                    this.totalGrade += this.gradeHolder;
                    addGrade();
                    System.out.println("Enter 1 to continue or 0 to exit");
                    flag = s. nextInt();
                }while(flag != 0);
            finalize();
            s.close();
    }

    public static void main(String[] args)
    {
            main obj = new main();
            obj.getGrade();
    }
}
