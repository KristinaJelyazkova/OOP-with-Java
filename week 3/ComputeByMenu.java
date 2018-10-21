import java.util.Scanner;

public class ComputeByMenu {
    private double x;
    private Scanner in = new Scanner(System.in);

    public ComputeByMenu(double x) {
        this.x = x;
    }

    public void displayMenu(){
        // clear the screen:
        for(int line = 0; line < 50; line++){
            System.out.println();
        }

        // display menu:
        System.out.println("1. Enter a floating point number x.");
        System.out.println("2. Compute and display exp(x).");
        System.out.println("3. Compute and display sin(x).");
        System.out.println("4. Compute and display floor(x).");
        System.out.println("5. Exit.");
    }

    public void doSelection(int choice){
        switch(choice){
            case 1:
                x = in.nextDouble();
                break;
            case 2:
                System.out.printf("exp(x) = %.2f%n", Math.exp(x));
                break;
            case 3:
                System.out.printf("sin(x) = %.2f%n", Math.sin(x));
                break;
            case 4:
                System.out.printf("floor(x) = %.0f%n", Math.floor(x));
                break;
            case 5:
                System.out.println("Exiting the program...");
                System.exit(0);
            default:
                System.out.println("Wrong usage! Please enter a number between 1 and 5!");
        }
    }

    public void getUserChoice(){
        int choice = 0;

        while(choice != 5){
            displayMenu();
            choice = in.nextInt();
            doSelection(choice);
            System.out.printf("Press enter to continue...%n");
            in.nextLine();
            in.nextLine();
        }
    }
}
