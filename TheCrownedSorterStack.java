import java.util.Scanner;
import java.util.Stack;

/**
 * The Crowned Sorter program keeps a sorted stack of numbers.
 * 
 * This version uses a Stack instead of a LinkedList to maintain sorted numbers.
 * 
 * Maintenance Notes:
 * 1. Changed LinkedList to Stack to use LIFO handling while keeping numbers sorted.
 * 2. Modified addInOrder method to work with Stack while keeping its original functionality.
 */

public class TheCrownedSorterStack {

    /**
     * The main method that gets user input, adds numbers to a Stack,
     * and prints the sorted stack.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Changed LinkedList to Stack to use LIFO handling
        Stack<Integer> numbers = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter integers separated by spaces:");
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            
            // Add each number to the stack, preserving sorted order
            for (String numberStr : inputArray) {
                try {
                    int number = Integer.parseInt(numberStr);
                    addInOrder(numbers, number); // Reuse addInOrder to keep the stack sorted
                } catch (NumberFormatException e) {
                    System.out.println("'" + numberStr + "' is not a valid number.");
                }
            }

            // Print the sorted stack
            System.out.println("The Crowned Sorter: Sorted numbers: " + numbers);
            
        } finally {
            scanner.close(); // Close the scanner
        }
    }

    /**
     * Adds a number into the Stack while keeping it sorted.
     * 
     * Maintenance Update:
     * 1. This method was originally written for LinkedList.
     * 2. Modified to use a Stack with a temporary stack to keep sorted order.
     * 3. Core logic preserved, adapted for Stack behavior.
     *
     * @param stack The stack to add the number to.
     * @param number The number to add.
     */
    private static void addInOrder(Stack<Integer> stack, int number) {
        // Use a temporary stack to hold numbers greater than 'number'
        Stack<Integer> tempStack = new Stack<>();
        
        // Move elements greater than 'number' to the temporary stack
        while (!stack.isEmpty() && stack.peek() > number) {
            tempStack.push(stack.pop());
        }
        
        // Add 'number' to the correct position in the stack
        stack.push(number);
        
        // Move back the elements from the temporary stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}

/**
 * Javadoc command: javadoc -d doc TheCrownedSorterStack.java
 */