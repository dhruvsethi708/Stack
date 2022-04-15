import java.util.*;
public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = sc.nextInt();

        int arr[] = new int[n];
        int result[] = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Stack <Integer> st = new Stack<>();
        st.push(0);
        result[0] = 1;
        for(int i = 1; i<n; i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                st.pop();
            }

            if(st.size()==0){
                result[i] = i+1;
            }else{
                result[i] = i- st.peek();
            }
            st.push(i);
        }
        
        for(int i = 0; i<n; i++){
            System.out.print(result[i] + " ");
        }
    }
}
