// Take 1st 4 elements in array and print max and leave 1st element i.e next 4 elements print max and so on

import java.util.Scanner;
import java.util.Stack;
public class SlidingWindowMax{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        st.push(n-1);
        nge[n-1] = n;

        for (int i = n-2; i >= 0; i--) {
            while (st.size()>0 && arr[i]>=arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = n;
            }else{
                nge[i] = st.peek();
            }

            st.push(i);
        }
        
        int k = 4;

        int j = 0;
        for (int i = 0; i <= n-k; i++) {
            if (j<i) {
                j=i;
            }
            while(nge[j]<i+k){
                j = nge[j];
            }

            System.out.print(arr[j] + " ");
        }

    }
    
}