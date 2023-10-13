import java.util.*;

public class Combination_Sum {

    // Function to generate unique combinations that sum to the target
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // List to store the final combinations
        List<List<Integer>> ans = new ArrayList<>();

        // Start the recursive process to find combinations
        findCombinations(0, candidates, target, ans, new ArrayList<>());

        // Return the list of combinations
        return ans;
    }

    // Recursive function to find combinations
    private static void findCombinations(int ind, int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> comb) {
        // Base case: If we have processed all candidates
        if (ind == candidates.length) {
            // Check if the target is reached
            if (target == 0) {
                ans.add(new ArrayList<>(comb)); // Add the current combination to the result
            }
            return;
        }

        // Pick the current candidate if it does not exceed the target
        if (candidates[ind] <= target) {
            comb.add(candidates[ind]); // Add the current candidate to the combination
            // Recursive call with updated target
            findCombinations(ind, candidates, target - candidates[ind], ans, comb);
            comb.remove(comb.size() - 1); // Backtrack: Remove the last added element
        }

        // Move to the next candidate
        findCombinations(ind + 1, candidates, target, ans, comb);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input: Length of the array
        int n = in.nextInt();

        // Input: Array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // Input: Target sum
        int target = in.nextInt();
        in.close();

        // Generate combinations using the combinationSum() method
        List<List<Integer>> ans = combinationSum(arr, target);

        // Print the combinations in the specified format
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
