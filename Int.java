import java.util.Scanner;
public class Int{
    public static void main (String[]args){
        Scanner in=new Scanner (System.in);
        int option;
        do { 
            System.out.println("Secret Santa Raffle System");
            System.out.println("1. Register Raffle Information");
            System.out.println("2. Register Participants");
            System.out.println("3. List Participants");
            System.out.println("4. Generate Secret Santa");
            System.out.println("5. Show Raffle Summary");
            System.out.println("6. Exit");
            System.out.println("Please choose an option: ");
            option=in.nextInt();
            in.nextLine();

            switch(option){
                case 1: 
                    System.out.println("Option 1 selected - Register Raffle Information");
                    break;
                case 2: 
                    System.out.println("Option 2 selected - Register Participants");
                    break;
                case 3: 
                    System.out.println("Option 3 selected - List Participants");
                    break;    
                case 4: 
                    System.out.println("Option 4 selected - Generate Secret Santa");
                    break;     
                case 5: 
                    System.out.println("Option 5 selected - Show Raffle Summary");
                    break; 
                case 6: 
                    System.out.println("Exit Completed.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
        }

        } while (option!=6);
        in.close();
    }
}