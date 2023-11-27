package task_1;

import java.util.Arrays;
import java.util.Stack;

public class MyLIFO_App {
	    // This method reserves the given array
	  public static <E> void reserve(E[] array) {
	        Stack<E> stack = new Stack<>();
	        for (E element : array) {
	            stack.push(element);
	        }

	        for (int i = 0; i < array.length; i++) {
	            array[i] = stack.pop();
	        }
	    }
	       


	    // This method checks the correctness of the given input
	    // i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	    public static boolean isCorrect(String input) {
	        Stack<Character> stack = new Stack<>();

	        for (char ch : input.toCharArray()) {
	            if (ch == '(' || ch == '[' || ch == '{') {
	                stack.push(ch);
	            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
	                stack.pop();
	            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
	                stack.pop();
	            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
	                stack.pop();
	            } else {
	                return false; // Invalid character or mismatch
	            }
	        }

	        return stack.isEmpty(); // If stack is empty, all parentheses are matched
	    }

	    // This method evaluates the value of an expression
	    // i.e. 51 + (54 *(3+2)) = 321
	    public static int evaluateExpression(String expression) {
	        Stack<Integer> operands = new Stack<>();
	        Stack<Character> operators = new Stack<>();

	        for (char ch : expression.toCharArray()) {
	            if (Character.isDigit(ch)) {
	                operands.push(Character.getNumericValue(ch));
	            } else if (ch == '(') {
	                operators.push(ch);
	            } else if (ch == ')') {
	                while (operators.peek() != '(') {
	                    operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
	                }
	                operators.pop(); // Remove '('
	            } else if (isOperator(ch)) {
	                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
	                    operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
	                }
	                operators.push(ch);
	            }
	        }

	        while (!operators.isEmpty()) {
	            operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
	        }

	        return operands.pop(); // Result of the expression
	    }

	    private static boolean isOperator(char ch) {
	        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	    }

	    private static int precedence(char operator) {
	        switch (operator) {
	            case '+':
	            case '-':
	                return 1;
	            case '*':
	            case '/':
	                return 2;
	            default:
	                return 0;
	        }
	    }

	    private static int applyOperator(char operator, int operand2, int operand1) {
	        switch (operator) {
	            case '+':
	                return operand1 + operand2;
	            case '-':
	                return operand1 - operand2;
	            case '*':
	                return operand1 * operand2;
	            case '/':
	                return operand1 / operand2;
	            default:
	                throw new IllegalArgumentException("Invalid operator: " + operator);
	        }
	    }

	    public static void main(String[] args) {
	        // Example usage
	        Integer[] array = {1, 2, 3, 4, 5};
	        reserve(array);
	        System.out.println("Reversed array: " + Arrays.toString(array));

	        System.out.println(isCorrect("()(())[]{(())}")); // true
	        System.out.println(isCorrect("){[]}()"));         // false

	        System.out.println(evaluateExpression("51 + (54 *(3+2))")); // 321
	    }
	}


