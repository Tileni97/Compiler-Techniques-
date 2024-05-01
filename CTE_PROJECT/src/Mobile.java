import java.util.Scanner;
import java.util.Stack;

public class Mobile {
    private Stack<Character> operatorStack = new Stack<>();

    private Stack<Double> valueStack = new Stack<>();

    private boolean error = false;

    private boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    private int getPrecedence(char ch) {
        if (ch != '+' && ch != '-')
            return (ch != '*' && ch != '/') ? 0 : 2;
        return 1;
    }

    private void processOperator(char t) {
        if (this.valueStack.empty()) {
            System.out.println("Expression error.");
            this.error = true;
        } else {
            double b = ((Double)this.valueStack.peek()).doubleValue();
            this.valueStack.pop();
            if (this.valueStack.empty()) {
                System.out.println("Expression error.");
                this.error = true;
            } else {
                double a = ((Double)this.valueStack.peek()).doubleValue();
                this.valueStack.pop();
                double r = 0.0D;
                if (t == '+') {
                    r = a + b;
                } else if (t == '-') {
                    r = a - b;
                } else if (t == '*') {
                    r = a * b;
                } else if (t == '/') {
                    r = a / b;
                } else {
                    System.out.println("Operator error.");
                    this.error = true;
                }
                this.valueStack.push(Double.valueOf(r));
            }
        }
    }

    public void processInput(String input) {
        String[] tokens = input.split(" ");
        for (int n = 0; n < tokens.length; n++) {
            String nextToken = tokens[n];
            char ch = nextToken.charAt(0);
            if (ch >= '0' && ch <= '9') {
                double value = Double.parseDouble(nextToken);
                this.valueStack.push(Double.valueOf(value));
            } else if (isOperator(ch)) {
                if (!this.operatorStack.empty() && getPrecedence(ch) <= getPrecedence(((Character)this.operatorStack.peek()).charValue())) {
                    while (!this.operatorStack.empty() && getPrecedence(ch) <= getPrecedence(((Character)this.operatorStack.peek()).charValue())) {
                        char toProcess = ((Character)this.operatorStack.peek()).charValue();
                        this.operatorStack.pop();
                        processOperator(toProcess);
                    }
                    this.operatorStack.push(Character.valueOf(ch));
                } else {
                    this.operatorStack.push(Character.valueOf(ch));
                }
            } else if (ch == '(') {
                this.operatorStack.push(Character.valueOf(ch));
            } else if (ch == ')') {
                while (!this.operatorStack.empty() && isOperator(((Character)this.operatorStack.peek()).charValue())) {
                    char toProcess = ((Character)this.operatorStack.peek()).charValue();
                    this.operatorStack.pop();
                    processOperator(toProcess);
                }
                if (!this.operatorStack.empty() && ((Character)this.operatorStack.peek()).charValue() == '(') {
                    this.operatorStack.pop();
                } else {
                    System.out.println("Error: unbalanced parenthesis.");
                    this.error = true;
                }
            }
        }
        while (!this.operatorStack.empty() && isOperator(((Character)this.operatorStack.peek()).charValue())) {
            char toProcess = ((Character)this.operatorStack.peek()).charValue();
            this.operatorStack.pop();
            processOperator(toProcess);
        }
        if (!this.error) {
            double result11 = ((Double)this.valueStack.peek()).doubleValue();
            this.valueStack.pop();
            if (this.operatorStack.empty() && this.valueStack.empty()) {
                System.out.println("The result of the arithmetic extression is : " + result11);
            } else {
                System.out.println("Expression error.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an expression to compute: ");
        String userInput = input.nextLine();
        Mobile calc = new Mobile();
        calc.processInput(userInput);
    }
}
