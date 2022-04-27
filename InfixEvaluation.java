import java.util.Stack;
import java.util.Scanner;


public class InfixEvaluation {
    public static void main(String[] args) {
        // Make 2 stacks. i of operator and another of operand 
        // operands -> push 
        // operators -> push
        // ( -> operators push
        // ) -> pop till (
        // operator -> solve operators of equal or higher priority first

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression");
        String expression = sc.next();


        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if(ch == '('){
                operators.push(ch);
            } else if(Character.isDigit(ch)){
                operands.push(ch - '0'); // char to integer
            } else if(ch == ')'){
                while(operators.peek() != '(' ){
                    char operator = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int opvalue = operation(v1, v2, operator);
                    operands.push(opvalue); 
                }
                operators.pop();
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operators.size() > 0 && operators.peek() != '(' && precedence(ch)<=precedence(operators.peek())){
                    char operator = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int opvalue = operation(v1, v2, operator);
                    operands.push(opvalue);
                }
                operators.push(ch);
            }
        }

        while(operators.size() != 0 ){
            char operator = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();

            int opvalue = operation(v1, v2, operator);
            operands.push(opvalue); 
        }
        
        System.out.println(operands.peek());


    }

    public static int precedence(char operator) {
        if(operator == '+'){
            return 1;
        } else if(operator == '-'){
            return 1;
        } else if(operator == '*'){
            return 2;
        } else{
            return 2;
        }
    }

    public static int operation(int v1, int v2, char operator) {
        if(operator == '+'){
            return v1+v2;
        } else if(operator == '-'){
            return v1-v2;
        } else if(operator == '*'){
            return v1*v2;
        } else{
            return v1/v2;
        }
    }
}
