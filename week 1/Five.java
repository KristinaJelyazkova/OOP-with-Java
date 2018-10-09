// Lab 3: Five.java
// Program breaks apart a five-digit number


import java.util.Scanner;

public class Five {

   public static void main( String args[] ) {
       int originalNumber;
       int number;
       String inputString;

       // read five-digit number from standard input and store in var originalNumber
       Scanner in = new Scanner(System.in);
       System.out.print("Enter a five-digit number: ");
       inputString = in.nextLine();
       originalNumber = Integer.parseInt(inputString);

       // determine the 5 digits
       int digit1; // first digit of number
       int digit2; // second digit of number
       int digit3; // third digit of number
       int digit4; // fourth digit of number
       int digit5; // fifth digit of number

       digit1 = originalNumber / 10000; // get leftmost digit
       number = originalNumber % 10000; // get rightmost four digits

      /* write code here that will separate the remainder of the digits in the 
         variable "number" and assign each one to the corresponding integer 
         variable */
       digit2 = number / 1000;
       number %= 1000;
       digit3 = number / 100;
       number %= 100;
       digit4 = number / 10;
       number %= 10;
       digit5 = number;

       // create the result string
       String resultString;
      /* write a statement that creates a string that displays each digit 
         separated by three spaces. Name this string resultString for use in
         the call to showMessageDialog in lines 38-39 of the template code */
       resultString = digit1 + "   "
               + digit2 + "   "
               + digit3 + "   "
               + digit4 + "   "
               + digit5 + "   ";

       // output  results on standard output
       System.out.printf("The digits are %s%n", resultString);
   }

} // end class Five

