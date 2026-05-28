import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // Added monkey ArrayList
    private static ArrayList<Dog> dogList = new ArrayList<Dog>(); // Added dog ArrayList

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeMonkeyList(); // Call method to initialize monkey list

        // Menu loop
        while (true) {
            displayMenu(); // Display the menu
            String choice = scanner.nextLine().trim().toLowerCase(); // Prompt user for input

            // Take appropriate action based on user input
            switch (choice) {
                case "1":
                    intakeNewMonkey(scanner);
                    break;
                case "2":
                    intakeNewDog(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("monkey");
                    break;
                case "5":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Quitting application...");
                    scanner.close(); // Close scanner before exiting
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("George", "male", "3", "15.5", "01-05-2021", "Brazil", "intake", false, "Brazil", 12.5, 30.0, 50.0, "Capuchin");
        Monkey monkey2 = new Monkey("Jack", "male", "2", "12.0", "05-10-2020", "Peru", "in service", true, "Peru", 10.0, 25.0, 40.0, "Marmoset");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
    }

    // Complete intakeNewMonkey
    //Instantiate and add the new monkey to the appropriate list
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("Enter monkey's name:");
        String name = scanner.nextLine();

        // Check if monkey with the same name already exists
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis monkey already exists in our system.\n");
                return;
            }
        }

        // If monkey name is unique, continue with data input
        System.out.println("Enter monkey's gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter monkey's age:");
        String age = scanner.nextLine();
        System.out.println("Enter monkey's weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter monkey's acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter monkey's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter monkey's training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the monkey reserved? (true/false):");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine(); // Consume the newline character left by nextBoolean
        System.out.println("Enter monkey's in-service country:");
        String inServiceCountry = scanner.nextLine();
        System.out.println("Enter monkey's tail length:");
        double tailLength = scanner.nextDouble();
        System.out.println("Enter monkey's height:");
        double height = scanner.nextDouble();
        System.out.println("Enter monkey's body length:");
        double bodyLength = scanner.nextDouble();
        System.out.println("Enter monkey's species:");
        String species = scanner.next();
        scanner.nextLine(); // Consume the newline character left by next

        // Instantiate a new monkey and add it to the appropriate list
        Monkey newMonkey = new Monkey(name, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength, species);
        monkeyList.add(newMonkey);
        System.out.println("New monkey added successfully!");
    }

    // Complete intakeNewDog
    //Instantiate and add the new dog to the appropriate list
    // to make sure the dog doesn't already exist and the breed type is allowed
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("Enter dog's name:");
        String name = scanner.nextLine();

        // Check if dog with the same name already exists
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis dog already exists in our system.\n");
                return;
            }
        }

        // If dog name is unique, continue with data input
        System.out.println("Enter dog's breed:");
        String breed = scanner.nextLine();
        System.out.println("Enter dog's gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter dog's age:");
        String age = scanner.nextLine();
        System.out.println("Enter dog's weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter dog's acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter dog's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter dog's training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog reserved? (true/false):");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine(); // Consume the newline character left by nextBoolean
        System.out.println("Enter dog's in-service country:");
        String inServiceCountry = scanner.nextLine();

        // Instantiate a new dog and add it to the appropriate list
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog);
        System.out.println("New dog added successfully!");
    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Your animal is reserved.");
    }

    // Complete printAnimals
    // Include the animal name, status, acquisition country and if the animal is reserved.
    // Remember that this method connects to three different menu items.
    // The printAnimals() method has three different outputs
    // based on the listType parameter
    // monkey - prints the list of monkeys
    // available - prints a combined list of all animals that are
    // fully trained ("in service") but not reserved
    // The other lists can have a print statement saying "This option needs to be implemented".
    // To score "exemplary" you must correctly implement the "available" list.
    public static void printAnimals(String listType) {
        if (listType.equalsIgnoreCase("monkey")) {
            System.out.println("List of Monkeys:");
            for (Monkey monkey : monkeyList) {
                System.out.println("Name: " + monkey.getName());
                System.out.println("Gender: " + monkey.getGender());
                System.out.println("Age: " + monkey.getAge());
                System.out.println("Weight: " + monkey.getWeight());
                System.out.println("Acquisition Date: " + monkey.getAcquisitionDate());
                System.out.println("Acquisition Country: " + monkey.getAcquisitionLocation());
                System.out.println("Training Status: " + monkey.getTrainingStatus());
                System.out.println("Reserved: " + (monkey.getReserved() ? "Yes" : "No"));
                System.out.println("In Service Country: " + monkey.getInServiceLocation());
                System.out.println("Tail Length: " + monkey.getTailLength());
                System.out.println("Height: " + monkey.getHeight());
                System.out.println("Body Length: " + monkey.getBodyLength());
                System.out.println("Species: " + monkey.getSpecies());
                System.out.println();
            }
        } else if (listType.equalsIgnoreCase("available")) {
            System.out.println("List of Available Monkeys:");
            boolean foundAvailable = false;
            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                    System.out.println("Name: " + monkey.getName());
                    System.out.println("Gender: " + monkey.getGender());
                    System.out.println("Age: " + monkey.getAge());
                    System.out.println("Weight: " + monkey.getWeight());
                    System.out.println("Acquisition Date: " + monkey.getAcquisitionDate());
                    System.out.println("Acquisition Country: " + monkey.getAcquisitionLocation());
                    System.out.println("Training Status: " + monkey.getTrainingStatus());
                    System.out.println("Reserved: " + (monkey.getReserved() ? "Yes" : "No"));
                    System.out.println("In Service Country: " + monkey.getInServiceLocation());
                    System.out.println("Tail Length: " + monkey.getTailLength());
                    System.out.println("Height: " + monkey.getHeight());
                    System.out.println("Body Length: " + monkey.getBodyLength());
                    System.out.println("Species: " + monkey.getSpecies());
                    System.out.println();
                    foundAvailable = true;
                }
            }
            if (!foundAvailable) {
                System.out.println("No available monkeys found.");
            }
        } else {
            System.out.println("Invalid list type.");
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new monkey");
        System.out.println("[2] Intake a new dog");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all monkeys");
        System.out.println("[5] Print a list of all available monkeys");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
}
