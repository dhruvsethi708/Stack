import java.util.*;

public class PrefixConversions {
    public static void main(String[] args) {
        
        String exp = "-+2/*6483"; //prefix expression

        Stack<Integer> value = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for(int i = exp.length()-1; i>=0; i--){
            char ch = exp.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                // value stack
                int v1 = value.pop();
                int v2 = value.pop();
                int val = operation(v1, v2, ch);
                value.push(val);

                // infix stack
                String inv1 = infix.pop();
                String inv2 = infix.pop();
                String inval = "(" + inv1 + ch + inv2 + ")";
                infix.push(inval);

                //postfix stack
                String pov1 = postfix.pop();
                String pov2 = postfix.pop();
                String poval = pov1 + pov2 + ch;
                postfix.push(poval);
                
            }else{
                value.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");
            }
        }

        System.out.println("Value is" + value.pop());
        System.out.println("Infix expression is" + infix.pop());
        System.out.println("Postfix expression is" + postfix.pop());
    }

    public static int operation(int v1, int v2, char ch) {
        if(ch == '+'){
            return v1+v2;
        }else if(ch == '-'){
            return v1-v2;
        }else if(ch == '*'){
            return v1*v2;
        }else{
            return v1/v2;
        }
    }
}
