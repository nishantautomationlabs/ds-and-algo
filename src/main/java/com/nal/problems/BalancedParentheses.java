package com.nal.problems;

import java.util.Stack;

/**
 * Created by nishant on 20/01/20.
 */
public class BalancedParentheses {

    private static final char[][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public static void main(String[] args) {
        String input = "{54f{([123])}}([nishant]){w}{{rr}}";
        BalancedParentheses balancedParentheses = new BalancedParentheses();
        System.out.println("Is Balanced: " + balancedParentheses.isBalanced(input));
    }

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isOpenParentheses(c)) {
                stack.push(c);
            } else if (isCloseParentheses(c)) {
                if (stack.isEmpty() || !matchesWithStackTop(stack.pop(), c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpenParentheses(char c) {
        for (char[] token : TOKENS) {
            if (token[0] == c)
                return true;
        }
        return false;
    }

    private boolean isCloseParentheses(char c) {
        for (char[] token : TOKENS) {
            if (token[1] == c)
                return true;
        }
        return false;
    }

    private boolean matchesWithStackTop(char openParen, char closeParen) {
        for (char[] token : TOKENS) {
            if (token[0] == openParen) {
                return token[1] == closeParen;
            }
        }
        return false;
    }
}
