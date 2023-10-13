import java.util.List;
import java.util.*;

public class Permutations {
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        func(0,nums,ans);
        return ans;

    }
    private static void swap(int i ,int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private static void func(int index,int[] nums,List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i =0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index;i<nums.length;i++){
            swap(i,index,nums);
            func(index+1,nums,ans);
            swap(i,index,nums);
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

        in.close();

        // Generate combinations using the combinationSum() method
        List<List<Integer>> ans = permute(arr);

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
