import java.util.Scanner;
public class Int{
    public static void main (String[]args){
        Scanner in=new Scanner (System.in);

        int option;
        String[] participants = null;  

        do { 
            System.out.println("\n----Secret Santa Raffle System----");
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
                    registerRaffle(in);
                    break;
                case 2: 
                    System.out.println("Option 2 selected - Register Participants");
                    participants = registerParticipants(in);  
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
/**
Method Register Raffle
What does it do? Registers raffle information that the user inputs, 
such as raffle name, description, budget, and event date.

@param Scanner in: Scanner object used to read user input.
*/
    public static void registerRaffle(Scanner in){
        System.out.println("\n----Register Raffle----");
    
        System.out.print("Enter raffle name: ");
        String name = in.nextLine();
            
        System.out.print("Enter raffle description: ");
        String desc = in.nextLine();
            
        System.out.print("Enter budget per gift: ");
        double budget = in.nextDouble();
        in.nextLine();
            
        System.out.print("Enter event year: ");
        int year = in.nextInt();
            
        System.out.print("Enter event month (1-12): ");
        int month = in.nextInt();
                
        System.out.print("Enter event day: ");
        int day = in.nextInt();
        in.nextLine(); 

        System.out.println("Raffle registered successfully!");
        System.out.println("Name: " + name);
        System.out.println("Description: " + desc);
        System.out.println("Budget: $" + budget);
        System.out.println("Date: " + year + "-" + month + "-" + day);
    }
/**
Method Register Participants
What does it do? Asks number of participants, their names,
and saves all the names in an array. 
Then it shows the complete list of registered participants.

@param Scanner in: Scanner used to read user input.
*/
    public static String[] registerParticipants(Scanner in){
        System.out.println("\n----Register Participants----");
        
        System.out.print("Enter the number of participants: ");
        int numParticipants = in.nextInt();
        in.nextLine(); 
                
        String[] participants = new String[numParticipants];  // Named 'participants'

        for (int i = 0; i < numParticipants; i++) {
            System.out.print("Enter participant " + (i + 1) + " name: ");
            participants[i] = in.nextLine();
        }
        
        System.out.println("\n" + numParticipants + " participants registered successfully!");
        System.out.println("Participants list:");
        for (int i = 0; i < numParticipants; i++) {
            System.out.println((i + 1) + ". " + participants[i]);
        }
        return participants;
    }
}