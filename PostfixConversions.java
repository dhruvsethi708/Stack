import java.util.Stack;

public class PostfixConversions {
    public static void main(String[] args) {
        
        String exp = "264*8/+3-"; //postfix expression

        Stack<Integer> value = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                //value stack
                int v2 = value.pop();
                int v1 = value.pop();
                int val = operation(v1, v2, ch);
                value.push(val);

                //infix stack
                String iv2 = infix.pop();
                String iv1 = infix.pop();
                String ival = "(" + iv1 + ch + iv2 + ")";
                infix.push(ival);

                //prefix stack
                String pv2 = prefix.pop();
                String pv1 = prefix.pop();
                String pval = ch + pv1 + pv2;
                prefix.push(pval);

            }else{
                value.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            }
        }

        System.out.println("Value of the postfix expression is " + value.pop());
        System.out.println("Infix expression of the postfix expression is " + infix.pop());
        System.out.println("Prefix expression of the postfix expression is " + prefix.pop());


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
