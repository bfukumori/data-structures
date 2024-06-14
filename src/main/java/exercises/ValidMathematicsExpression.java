package exercises;

import java.util.Set;
import java.util.Stack;

public class ValidMathematicsExpression {
    public static boolean isValidMathematicsExpression(String mathematicsExpression) {
        Set<Character> openSymbols = Set.of('(','{','[');
        Set<Character> closeSymbols = Set.of(')','}',']');
        Stack<Character> stack = new Stack<>();

        for(char c: mathematicsExpression.toCharArray()) {
            if(openSymbols.contains(c)) stack.push(c);
            if(closeSymbols.contains(c)) {
                if(stack.isEmpty()) return false;
                var open = stack.pop();
                if(open == '(' && c != ')') return false;
                if(open == '[' && c != ']') return false;
                if(open == '{' && c != '}') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidMathematicsExpression("{[(2+3)×4]−5}"));
        System.out.println(isValidMathematicsExpression("{[(2+3)×4]−5"));
        System.out.println(isValidMathematicsExpression("{[(2+3)×4)−5}"));
    }
}
