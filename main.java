import java.util.Scanner; 
public class main{
        final double milk = 3.99;
	final double rice = 6.99;
	final double orangeJuice = 5.99;
	final double iceCream = 4.99;
        String name; 
        int option = 0;
        double total = 0;
        
        public static void p(String str)
        {
                System.out.println(str);
        }
        
        public void add(final int option)
        {
                switch(option)
                {
                        case 1:
                                this.total += this.milk;
                                break;
                        case 2:
                                this.total += this.rice;
                                break;
                        case 3:
                                this.total += this.orangeJuice;
                                break;
                        case 4:
                                this.total += this.iceCream;
                                break;
                        default:
                                p("wrong input, adding 0");
                }
        }

        public void getName(Scanner s)
        {
                p("Enter your name");
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
        
        public void finalize()
        {
                System.out.println("Your total: " + this.total);
                System.out.println(this.name + " thank you for your business, good day ahead");
        }
       
        public void menu()
        {
                Scanner s = new Scanner(System.in);
                getName(s);
                do
                {
                        p("1: Milk: 3.99");
                        p("2: rice: 6.99");
                        p("3: orange juice: 5.99");
                        p("4: ice cream: 4.99");
                        p("5: quit");
                        p("Enter a number: ");
                        this.option = s.nextInt();
                        if(this.option != 5)
                        {
                                add(option);
                        }
                }while(this.option != 5);
                s.close();
                finalize();
        }
        
        public static void main(String[] args)
        {
                main obj = new main();
                obj.menu();
        }
}

