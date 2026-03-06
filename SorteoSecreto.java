/*
 * Secret Santa Raffle System - Phase 1
 * 
 * General Problem Description:
 * This program manages a Secret Santa raffle for events. It allows an organizer
 * to register one raffle with its details (name, description, budget, date),
 * register multiple participants with duplicate validation, display the participant list,
 * randomly generate secret friend assignments ensuring no self-assignments or repeats,
 * and show a summary of the raffle results.
 * 
 * Requirement 1: Register Raffle Information
 * Description: Allows user to register information for one raffle including name,
 *              description, budget, and event date using LocalDate.
 * Inputs: 
 *   - raffle name: String
 *   - description: String
 *   - budget: double
 *   - event year: int
 *   - event month: int
 *   - event day: int
 * Outputs: 
 *   - Confirmation message with all entered data: String
 * Example:
 *   Enter raffle name: Christmas Party
 *   Enter description: School gift exchange
 *   Enter budget per gift: 15.50
 *   Enter event year: 2026
 *   Enter event month: 12
 *   Enter event day: 20
 *   Output: Raffle registered successfully! 
 *           Name: Christmas Party
 *           Description: School gift exchange
 *           Budget: $15.5
 *           Date: 2026-12-20
 * 
 * Requirement 2: Register Participants
 * Description: Asks for number of participants and then registers each name.
 * Inputs:
 *   - number of participants: int
 *   - participant names: String (multiple)
 * Outputs:
 *   - List of all registered participants with numbers: String
 * Example:
 *   Enter number of participants: 3
 *   Enter participant 1 name: Ana
 *   Enter participant 2 name: Carlos
 *   Enter participant 3 name: Maria
 *   Output: 3 participants registered successfully!
 *           Participants list:
 *           1. Ana
 *           2. Carlos
 *           3. Maria
 * 
 * Requirement 3: Validate Participant Information
 * Description: Ensures no duplicate names are registered using case-insensitive comparison.
 * Inputs:
 *   - name to check: String
 *   - existing participants array: String[]
 *   - current count: int
 * Outputs:
 *   - Error message if duplicate found: String
 * Example:
 *   Enter participant 3 name: Ana
 *   Output: Error: 'Ana' already exists! Please enter a different name.
 * 
 * Requirement 4: List/Consult Participants
 * Description: Displays all registered participants with consecutive numbers.
 * Inputs:
 *   - participants array: String[]
 * Outputs:
 *   - Numbered list of participants: String
 * Example:
 *   Output: ---- Participants List ----
 *           1. Ana
 *           2. Carlos
 *           3. Maria
 * 
 * Requirement 5: Generate Secret Santa
 * Description: Randomly assigns each participant a secret friend using Random class,
 *              ensuring no self-assignments and no repeats.
 * Inputs:
 *   - participants array: String[]
 * Outputs:
 *   - Confirmation message: String
 *   - Assignments array: String[] (returned)
 * Example:
 *   Output: Secret Santa assignments generated successfully.
 * 
 * Requirement 6: Show Raffle Summary
 * Description: Displays all participants and their secret friends if raffle was generated.
 * Inputs:
 *   - participants array: String[]
 *   - assignments array: String[]
 *   - status: String ("Created" or "Done")
 * Outputs:
 *   - Summary with participants and assignments (if done): String
 *   - Error message if raffle not generated: String
 * Example (if done):
 *   Output: ---- Raffle Summary ----
 *           Status: Done
 *           Participants (3):
 *             1. Ana
 *             2. Carlos
 *             3. Maria
 *           Secret Santa Assignments:
 *             Ana -> Carlos
 *             Carlos -> Maria
 *             Maria -> Ana
 * Example (if not done):
 *   Output: Error: Raffle has not been generated yet. Please select option 4 first.
 */
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
public class SorteoSecreto{
    public static void main (String[]args){
        Scanner in=new Scanner (System.in);

        int option;
        String[] participants = null;  
        String[] assignments = null;
        String status = "Created";

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
                    listParticipants(participants);
                    break;    
                case 4: 
                    System.out.println("Option 4 selected - Generate Secret Santa");
                    assignments = generateSecretSanta(participants);
                    if (assignments != null) {
                        status = "Done";
                    }
                    break;    
                case 5: 
                    System.out.println("Option 5 selected - Show Raffle Summary");
                    showSummary(participants, assignments, status);
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

        LocalDate eventDate = LocalDate.of(year, month, day);

        System.out.println("Raffle registered successfully!");
        System.out.println("Name: " + name);
        System.out.println("Description: " + desc);
        System.out.println("Budget: $" + budget);
        System.out.println("Date: "+eventDate);
    }
/**
Method Register Participants
What does it do? Asks number of participants, their names,
and saves all the names in an array. 
Then it shows the complete list of registered participants.
Then it returns the array to main. 

@param Scanner in: Scanner used to read user input.
@return String[]: Array containing all participant names in order entered. Returns a new array each time method is called.
*/
    public static String[] registerParticipants(Scanner in){
        System.out.println("\n----Register Participants----");
        
        System.out.print("Enter the number of participants: ");
        int numParticipants = in.nextInt();
        in.nextLine(); 
                
        String[] participants = new String[numParticipants];  
        int currentCount = 0;

        while (currentCount < numParticipants) {
            System.out.print("Enter participant " + (currentCount + 1) + " name: ");
            String name = in.nextLine();
        
            if (infoValidation(name, participants, currentCount)) {
                System.out.println("Error: '" + name + "' already exists! Please enter a different name.");
            } else {
                participants[currentCount] = name;
                currentCount++;  
            }
        }
        System.out.println("\n" + numParticipants + " participants registered successfully!");
        System.out.println("Participants list:");
        for (int i = 0; i < numParticipants; i++) {
            System.out.println((i + 1) + ". " + participants[i]);
        }
        return participants;
    }
/**
Method Info Validation
What does it do? Checks if a given name already exists in the participants array.
It loops through the array and compares each name with the one we're trying to add.

@param String name: The name to check for duplicates
@param String[] participants: The array of existing participant names
@param int currentCount: How many names are currently in the array
@return boolean: true if name is duplicate (already exists in array), false if name is available (not found).
*/
    public static boolean infoValidation(String name, String[] participants, int currentCount) {
        for (int i = 0; i < currentCount; i++) {
            if (participants[i].equalsIgnoreCase(name)) {
                return true;  
            }
        }
        return false;  
    }
/**
Method List Participants
What does it do? Displays the complete list of registered participants 
with a consecutive number next to each name. If no participants are registered,
it shows a message saying no participants have been registered yet.

@param String[] participants: Array containing all participant names
*/
    public static void listParticipants(String[] participants) {
        System.out.println("\n---- Participants List ----");

        if (participants == null || participants.length == 0) {
            System.out.println("No participants have been registered yet.");
            return; 
        }
        for (int i = 0; i < participants.length; i++) {
            System.out.println((i + 1) + ". " + participants[i]);
        }
    }
/**
Method Generate Secret Santa
What does it do? Randomly assigns each participant a secret friend.
It makes sure no one is assigned to themselves and no repeats.
Returns an array where the index matches the participant and the value is their assigned friend.

@param String[] participants: Array containing all participant names
@return String[]: Array where position i contains the secret friend for participant i. 
Returns null if participants is null or has less than 2 people.
*/
    public static String[] generateSecretSanta(String[] participants) {
        System.out.println("\n---- Generate Secret Santa ----");
        
        if (participants == null || participants.length < 2) {
            System.out.println("Error: Need at least 2 participants to generate a secret santa.");
            return null;
        }
        int n = participants.length;
        String[] assigned = new String[n];
        boolean[] available = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            available[i] = true;
        }
        Random random = new Random();
        
        for (int i = 0; i < n; i++) {
            int randomIndex;
        
            do {
                randomIndex = random.nextInt(n);
            } while (!available[randomIndex] || randomIndex == i);
            
            assigned[i] = participants[randomIndex];
            available[randomIndex] = false;
        }
        if (assigned[n-1].equals(participants[n-1])) {
            String temp = assigned[0];
            assigned[0] = assigned[n-1];
            assigned[n-1] = temp;
        }
        System.out.println("Secret Santa assignments generated successfully.");
        return assigned;
    }
/**
Method Show Summary
What does it do? Displays all participants. If the raffle has been generated 
(status = "Done"), it also shows each participant and their secret friend.
If the raffle hasn't been generated yet, it shows an error message.

@param String[] participants: Array of participant names
@param String[] assignments: Array of secret friend assignments
@param String status: Current status of the raffle ("Created" or "Done")
*/
    public static void showSummary(String[] participants, String[] assignments, String status) {
        System.out.println("\n---- Raffle Summary ----");
        
        System.out.println("Status: " + status);

        if (participants == null || participants.length == 0) {
            System.out.println("No participants registered yet.");
            return;
        }
        System.out.println("\nParticipants (" + participants.length + "):");
        for (int i = 0; i < participants.length; i++) {
            System.out.println("  " + (i + 1) + ". " + participants[i]);
        }
        if (status.equals("Done")) {
            if (assignments != null && assignments.length == participants.length) {
                System.out.println("\nSecret Santa Assignments:");
                for (int i = 0; i < participants.length; i++) {
                    System.out.println("  " + participants[i] + " -> " + assignments[i]);
                }
            } else {
                System.out.println("\nError with assignments data");
            }
        } else {
            System.out.println("\nError: Raffle has not been generated yet. Please select option 4 first.");
        }
    }
}