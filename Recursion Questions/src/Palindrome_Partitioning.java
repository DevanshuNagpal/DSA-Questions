import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrome_Partitioning {
    // Function to generate palindrome partitions of the input string
    private static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> subsets = new ArrayList<>();
        int ind = 0;
        func(s, ind, subsets, ans);
        return ans;
    }

    // Recursive helper function to find palindrome partitions
    private static void func(String s, int ind, ArrayList<String> subsets, List<List<String>> ans) {
        // If we've reached the end of the string, add the current partition to the result
        if (ind == s.length()) {
            ans.add(new ArrayList<>(subsets));
            return;
        }
        // Try different partitioning options
        for (int i = ind; i < s.length(); i++) {
            // If the current substring is a palindrome, explore further
            if (isPalindrome(s, ind, i)) {
                subsets.add(s.substring(ind, i + 1));
                func(s, i + 1, subsets, ans);
                subsets.remove(subsets.size() - 1);
            }
        }
    }

    // Function to check if a substring is a palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input: String
        System.out.println("Enter a string:");
        String str = in.next();
        in.close();

        // Generate partitions using the partition() method
        List<List<String>> ans = partition(str);

        // Print the partitions
        System.out.print("[");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if (i < ans.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
