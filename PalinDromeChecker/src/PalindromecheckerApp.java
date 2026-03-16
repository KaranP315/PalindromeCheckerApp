import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        scanner.close();
    }

    public static boolean isPalindrome(String text) {
        String cleanText = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : cleanText.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            Character front = deque.removeFirst();
            Character back = deque.removeLast();

            if (!front.equals(back)) {
                return false;
            }
        }

        return true;
    }
}