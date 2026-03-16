import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    // Convert string to linked list
    public static void createList(String str) {
        Node temp = null;

        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);

            if (head == null) {
                head = newNode;
                temp = head;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }
    }

    // Reverse linked list
    public static Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Check palindrome
    public static boolean isPalindrome() {

        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        // Find middle using fast and slow pointer
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        createList(input);

        if (isPalindrome()) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }
}
