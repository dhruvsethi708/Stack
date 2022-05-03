import java.util.*;

//    0  1  2  3(index)
// 0  0  1  1  1
// 1  1  0  1  0
// 2  0  0  0  0
// 3  1  1  1  0
//(index)
public class CelebrityProb {
    public static void main(String[] args) {
        // Celebrity- known by everybody and does not know anybody


        int arr[][] = new int[4][4];
        arr[0][0] = 0;
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[0][3] = 1;
        arr[1][0] = 1;
        arr[1][1] = 0;
        arr[1][2] = 1;
        arr[1][3] = 0;
        arr[2][0] = 0;
        arr[2][1] = 0;
        arr[2][2] = 0;
        arr[2][3] = 0;
        arr[3][0] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[3][3] = 0;

        Stack <Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);

        }

        while (st.size()>=2) {
            int i = st.pop();
            int j = st.pop();

            if(arr[i][j] == 1){
                // if i knows j = i is not a celebrity
                st.push(j);
            }else{
                // if i doesnot know j = j is not a celebrity
                st.push(i);
            }
        }

        int pot = st.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != pot) {
                if(arr[i][pot]==0 || arr[pot][i]==1){
                    System.out.println("no celebrity");
                    return;
                }
            }
            
        }

        System.out.println(pot + " is a celbrity");;
    }
}
