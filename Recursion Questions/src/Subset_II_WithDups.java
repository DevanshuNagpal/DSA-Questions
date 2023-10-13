import java.util.*;

/*
Given an integer array nums that may contain duplicates, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


 */
public class Subset_II_WithDups
{

    private static List<List<Integer>> subsetsWithoutDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subsets = new ArrayList<>();
        int i =0;
        func(nums,i,subsets,ans);
        return ans;
    }
    private  static void func(int[] nums,int i ,ArrayList<Integer> subsets,List<List<Integer>> ans){

        if(i == nums.length){
            ans.add(new ArrayList<>(subsets));
            return;
        }
        while(i+1<nums.length && nums[i] ==nums[i+1]){
            i++;
        }

        subsets.add(nums[i]);
        func(nums,i+1,subsets,ans);
        subsets.remove(subsets.size()-1);
        func(nums,i+1,subsets,ans);


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
        List<List<Integer>> ans = subsetsWithoutDup(arr);

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



