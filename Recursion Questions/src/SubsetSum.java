import java.util.*;

public class SubsetSum {

    // Function to generate subset sums
    public static ArrayList<Integer> subsetSum(int[] nums) {
        int ind = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        subSum(ind, sum, nums, ans);
        Collections.sort(ans);
        return ans;
    }

    // Recursive function to generate subset sums
    private static void subSum(int ind, int sum, int[] nums, ArrayList<Integer> ans) {
        // Base case: If we have processed all elements in the array
        if (ind == nums.length) {
            ans.add(sum);
            return;
        }

        // Pick the current element
        subSum(ind + 1, sum + nums[ind], nums, ans);

        // Not pick the current element
        subSum(ind + 1, sum, nums, ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        // Input the array elements
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        // Generate subset sums using the subsetSum() method
        List<Integer> ans = subsetSum(arr);

        // Print the subset sums in the specified format
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
