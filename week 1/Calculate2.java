// Lab 2: Calculate2.java
// Perform simple calculations on three integers.
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Calculate2 {

   public static void main( String args[] )
   {
      String firstNumber;  // first string entered by user
      String secondNumber; // second string entered by user
      String thirdNumber;  // third string entered by user

      int number1; // first number
      int number2; // second number
      int number3; // third number

      int average;  // average of the numbers 
      int largest;  // largest number
      int product;  // product of the numbers
      int smallest; // smallest number
      int sum;      // sum of the numbers

      /* write a series of statements to read in three numbers, convert them
         to integers, and assign them to number1, number2, and number3 */
      Scanner in = new Scanner(System.in);

      System.out.print("Enter first number: ");
      firstNumber = in.nextLine();
      System.out.print("Enter second number: ");
      secondNumber = in.nextLine();
      System.out.print("Enter third number: ");
      thirdNumber = in.nextLine();

      number1 = Integer.parseInt(firstNumber);
      number2 = Integer.parseInt(secondNumber);
      number3 = Integer.parseInt(thirdNumber);

      // initialize largest and smallest
      largest = number1;
      smallest = number2;

      // determine smallest and largest
      /* write code here that compares all three integers and sets the 
         largest and smallest accordingly */
      if(number1 < smallest) {
          smallest = number1;
      }
      if(number2 < smallest){
          smallest = number2;
      }
      if(number2 > largest){
          largest = number2;
      }
       if(number3 < smallest){
           smallest = number3;
       }
       if(number3 > largest){
           largest = number3;
       }

      // perform calculations
      sum = number1 + number2 + number3;
      /* write statements to calculate the product and the average */
       product = number1 * number2 * number3;
       average = (number1 + number2 + number3) / 3;

      // create result string
      String result;
      /* Write a statement that concatenates all the results into a single string
         "result" that is displayed on line from line 44 of the template code */
      result = "The smallest number is " + smallest + ".\n"
              + "The largest number is " + largest + ".\n"
              + "The sum is " + sum + ".\n"
              + "The product is " + product + ".\n"
              + "The average is " + average + ".\n";

      // Write a statement to output results
        System.out.print(result);
   }

} // end class Calculate2

 
 
