package com.GLBalanceBrackesys;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BalanceBrackets {
	
	

public class BalancedBrackets {
  
    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();
        		//<Character>();
  
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) 
        {
            char x = expr.charAt(i);
  
            if (x == '(' || x == '[' || x == '{') 
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
  
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
  
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
  
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
  
        // Check Empty Stack
        return (stack.isEmpty());
    }
	
    public static void main(String[] args)
    {
        String expr = "([{}])";
        String secondExpr = "([{}]";
        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Entered string "+expr+" "+"has Balanced Brackets");
        else
            System.out.println("Entered string "+expr+" "+"do not contain Balanced Brackets");
        
        //second expression check
        if (areBracketsBalanced(secondExpr))
            System.out.println("Entered string "+secondExpr+" "+"has Balanced Brackets");
        else
            System.out.println("Entered string "+secondExpr+" "+"do not contain Balanced Brackets");
    }
}

}
