import java.util.Scanner;

public class Main {
    public static int countSubarrays(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                long sum = 1;
                for(int t = i; t <= j; t++) {
                    sum *= nums[t];
                }
                if(sum % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(countSubarrays(nums, k));
    }
}
