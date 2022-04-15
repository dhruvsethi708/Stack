import java.util.*;
public class LargestAreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of bars in histogram");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter heights of each bar");

        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] rb = new int[n];    //next smaller element index on the right
        Stack <Integer> st = new Stack<>();
        st.push(n - 1);
        rb[n-1] = n;

        for (int i = n-1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                rb[i] = n;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }


        int[] lb = new int[n];    //next smaller element index on the left

        Stack <Integer> slt = new Stack<>();
        slt.push(0);
        lb[0] = -1;

        for (int i = 1; i < n; i++) {
            while (slt.size() > 0 && arr[i] <= arr[slt.peek()]) {
                slt.pop();
            }

            if (slt.size() == 0) {
                lb[i] = -1;
            }else{
                lb[i] = slt.peek();
            }
            slt.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i<n; i++){
            int width = rb[i] - lb[i] -1;
            int area = arr[i]*width;
            if(area>maxArea){
                maxArea = area;
            }
        }

        System.out.println(maxArea);


    }
}
