import java.util.Scanner;
import java.util.Stack;
/**
 * NGETR
 */
public class NGETR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //3
        int arr[] = new int[n]; // 2 2 2
        int result[] = new int[n];
        result[n-1] = -1;
        // Stack <Integer> st = new Stack <>();
        // for(int i = 0; i<n; i++){
        //     arr[i] = sc.nextInt();
        //     st.push(arr[i]);
        //     st.peek();
        // }
        
        // System.out.println(st);
        // sc.close();
        // // st.size();

        Stack <Integer> st = new Stack <>();

        for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
                // st.push(arr[i]);
            }

            st.push(arr[n-1]);

        for(int i = n-2; i>=0; i--){
                // arr[i] = sc.nextInt();
                // st.push(arr[i]);
                while(st.size()>0 && arr[i]>=st.peek()){
                    st.pop();
                }

                if(st.size() == 0){
                    result[i] = -1;
                }else{
                    result[i] = st.peek();
                }

                st.push(arr[i]);
            }
        for(int i = 0; i<n; i++){
            System.out.print(result[i] + " ");
        }

    }
   
}