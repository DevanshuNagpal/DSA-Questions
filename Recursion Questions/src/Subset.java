import java.util.*;
/*
Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

public class Subset {
    // Function to generate all subsets of a given array
    private static List<List<Integer>> subsets(int[] nums) {
        // List to store the final result
        List<List<Integer>> ans = new ArrayList<>();
        // Temporary list to store the current subset being generated
        ArrayList<Integer> subset = new ArrayList<>();

        // Start the recursive process to generate subsets
        func(nums, 0, subset, ans);

        // Return the final list of subsets
        return ans;
    }

    // Recursive function to generate subsets
    private static void func(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> ans) {
        // If we have processed all elements in the array
        if (i == nums.length) {
            // Add a copy of the current subset to the result
            ans.add(new ArrayList<Integer>(subset));
            return;
        }

        // Include the current element in the subset
        subset.add(nums[i]);
        // Recursively call the function with the next index
        func(nums, i + 1, subset, ans);
        // Backtrack and remove the last element to explore other possibilities
        subset.remove(subset.size() - 1);
        // Recursively call the function without including the current element
        func(nums, i + 1, subset, ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        // Generate subsets using the subsets() method
        List<List<Integer>> ans = subsets(arr);

        // Print the subsets in the specified format

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
