package javafxapplication2;

/**
 * Class for the conversion of an expression from infix to postfix notation 
 * Utilizes custom stack class
 * @author Bobby Wettig
 * @version 20170408
 */
public class Postfix {
    
     /**
      * 
     * Determines if the operator op1 is of lower precedence than op2
     * @param op1 current operator
     * @param op2 operator to evaluate against
     * @return true if op1 is of lower precedence than op2, false if not
     */
    private static boolean isLower(String op1, String op2)
    {
       
        if (op1.equals("+"))
            return (!(op2.equals("+") || op2.equals("(")));
        
        else if (op1.equals("-"))
            return (!(op2.equals("-") || op2.equals("(")));
        
        else if (op1.equals("*"))
            return (op2.equals("/") || op2.equals("^") || op2.equals("("));
        
        else if (op1.equals("/"))
            return (op2.equals("*") || op2.equals("^") || op2.equals("("));
        
        else if (op1.equals("^"))
            return (op2.equals("("));
        
        else
            return false;
    }
    
    /**
     * Converts a string from infix to postfix notation
     * @param inputExpression expression in infix notation
     * @return expression converted to postfix notation
     */
    public static String convertToPostfix(String inputExpression)
    {
        String[] input = inputExpression.split(" ");
        String output = "";
        Stack stack = new Stack(50);
        
        for (String oper : input)
        {
            // if oper is an operator
            if (oper.equals("(") || oper.equals(")") || oper.equals("+") ||
                    oper.equals("-") || oper.equals("*") || oper.equals("/") ||
                    oper.equals("^"))
            {
                // if oper is ')'
                if (oper.equals(")"))
                {
                    //while the stack is not empty, pop the stack to the output
                    //until te item on top of the stack is '(' 
                    while (!stack.isEmpty() && !stack.peek().equals("("))
                        output += stack.pop();
                    
                    //pop the '(' from the stack without appending to the output 
                    if (!stack.isEmpty())
                        stack.pop();
                }
                
                //if oper is not ')'
                else
                    {
                        //if the stack is not empty and the item on top of the 
                        //stack has higher precedence, push oper on the stack
                        if (!stack.isEmpty() && 
                                !isLower(oper, (String)stack.peek()))
                            stack.push(oper);
                        else
                        {
                            //while the stack is not empty and oper is lower 
                            //precedence than the item on top of the stack, 
                            //pop the stack and append to the output. 
                            //If the item on top of the stack is '(', just pop
                            //the stack without appending to the output.
                            while (!stack.isEmpty() && 
                                    isLower(oper, (String)stack.peek()))
                            {
                                if (!stack.peek().equals("("))
                                    output += stack.pop();
                                else
                                    stack.pop();
                            }
                            
                            //push oper on to the stack when it has lower
                            //precedence
                            stack.push(oper);
                        }
                    }
                }
            
                //when the token is an operand, just append it to the output.
                else
                    output += oper;
            }
        
        //after looping through all the tokens, keep popping the stack and 
        //appending the results to the output
        while (!stack.isEmpty())
            output += stack.pop();
        
        //return the expression converted to postfix notation
        return output;
    }
}
