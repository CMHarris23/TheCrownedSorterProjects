import java.util.LinkedList;
import java.util.Scanner;

/**
 * The Crowned Sorter program keeps a sorted list of integers by
 * inserting numbers in the right order.
 * 
 * Design Overview:
 * - The program uses a LinkedList to store numbers.
 * - It reads numbers from the user, then inserts each number into the list in order.
 * - The `addInOrder` method is used to insert the numbers and keep the list sorted.
 * - This method is reused each time a new number is added.
 */
public class TheCrownedSorterLinkedList {

    /**
     * The main method reads input, adds numbers to the LinkedList,
     * and prints the sorted list.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter integers separated by spaces:");
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");

            // Insert each number into the list in order
            for (String numberStr : inputArray) {
                try {
                    int number = Integer.parseInt(numberStr);
                    addInOrder(numbers, number); // Reuse addInOrder method
                } catch (NumberFormatException e) {
                    System.out.println("'" + numberStr + "' is not valid.");
                }
            }

            // Print the sorted list
            System.out.println("Sorted numbers: " + numbers);
        } finally {
            scanner.close();
        }
    }

    /**
     * Inserts a number into the LinkedList in sorted order.
     * This method is reused to keep the list sorted as numbers are added.
     * 
     * @param list The LinkedList of integers.
     * @param number The number to insert.
     */
    private static void addInOrder(LinkedList<Integer> list, int number) {
        if (list.isEmpty() || number < list.getFirst()) {
            list.addFirst(number);
        } else if (number > list.getLast()) {
            list.addLast(number);
        } else {
            // Find the correct position and insert the number
            for (int i = 0; i < list.size(); i++) {
                if (number <= list.get(i)) {
                    list.add(i, number);
                    break;
                }
            }
        }
    }
}

/**
 * Javadoc command: javadoc -d doc TheCrownedSorterLinkedList.java
 * 
 * Design Summary:
 * - `addInOrder` is used multiple times to insert numbers in sorted order.
 * - The program handles input, sorts as it goes, and prints the result.
 */
