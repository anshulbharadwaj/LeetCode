package com.practice.concepts.string;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] input = s.toCharArray();
        int len = input.length;

        for(int i = 0; i<len; i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i)==')' && !stack.empty() && stack.peek()=='(')
                stack.pop();
            else if (s.charAt(i)=='}' && !stack.empty() && stack.peek()=='{')
                stack.pop();
            else if (s.charAt(i)==']' && !stack.empty() && stack.peek()=='[')
                stack.pop();
            else
                return false;
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("()[]{}");
    }
}
