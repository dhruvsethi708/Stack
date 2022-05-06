import java.util.Scanner;
import java.util.Stack;

public class SmallestNoFollowingPattern {
    public static void main(String[] args) {
        // ddididd
        // d- decrease, i-increase
        // number digits will be letters+1

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression");
        String exp = sc.next();

        Stack <Integer> st = new Stack<>();
        int num = 1;

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == 'd') {
                st.push(num);
                num++;
            }else{
                st.push(num);
                num++;

                while (st.size()>0) {
                    System.out.print(st.pop());                   
                }
            }
        }
        st.push(num);
        while (st.size()>0) {
            System.out.print(st.pop());   

    }
}
}