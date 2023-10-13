import java.util.*;

public class KthPermutation {


        private static String getPermutation(int n, int k) {
            int fact = 1;
            ArrayList<Integer> numbers = new ArrayList<>();
            for(int i = 1;i<n;i++){
                fact = fact*i;
                numbers.add(i);

            }
            numbers.add(n);
            String ans = "";
            k = k-1;
            while(true){
                ans = ans+"" +numbers.get(k/fact);
                numbers.remove(k/fact);
                if(numbers.size()==0){
                    break;
                }
                k = k%fact;
                fact = fact /numbers.size();
            }return ans;
        }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();


        in.close();
        System.out.println(getPermutation(n,k));
    }
}
