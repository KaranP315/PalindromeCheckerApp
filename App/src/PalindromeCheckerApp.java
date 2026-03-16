public class PalindromeCheckerApp {
    import java.util.Scanner;

    public class UseCase4PalindromeCheckerApp {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);


            System.out.print("Enter a string: ");
            String input = sc.nextLine();


            char[] chars = input.toCharArray();

            // two pointers
            int start = 0;
            int end = chars.length - 1;

            boolean isPalindrome = true;


            while (start < end) {
                if (chars[start] != chars[end]) {
                    isPalindrome = false;
                    break;
                }
                start++;
                end--;
            }


            if (isPalindrome) {
                System.out.println("Input: " + input);
                System.out.println("Is Palindrome? true");
            } else {
                System.out.println("Input: " + input);
                System.out.println("Is Palindrome? false");
            }

            sc.close();
        }
    }
}
