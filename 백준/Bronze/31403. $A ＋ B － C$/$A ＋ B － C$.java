import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] nums = new int[3];
        for(int i = 0; i<nums.length; i++){
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(nums[0]+nums[1]-nums[2]);
        System.out.println(Integer.parseInt(nums[0]+""+nums[1])-nums[2]);
    }
}