// Added import statement for Arrays
import java.util.*;

/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
*/
public class Combination_Sum_II {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // List to store the final combinations
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        // Start the recursive process to find combinations
        findCombinations(0, candidates, target, ans, new ArrayList<>());

        // Return the list of combinations
        return ans;
    }

    // Recursive function to find combinations
    private static void findCombinations(int ind, int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> comb) {
        // Base case: If we have processed all candidates

            // Check if the target is reached
            if (target == 0) {
                ans.add(new ArrayList<>(comb)); // Add the current combination to the result
                return;

            }

        for (int i = ind; i < candidates.length; i++) {
            // Skip duplicates
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }

            // Pick the current candidate if it does not exceed the target
            comb.add(candidates[i]);
            findCombinations(i, candidates, target - candidates[i], ans, comb);
            comb.remove(comb.size() - 1); // Backtrack: Remove the last added element
        }

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

        // Generate combinations using the combinationSum2() method
        List<List<Integer>> ans = combinationSum2(arr, target);

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
