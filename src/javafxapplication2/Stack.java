
package javafxapplication2;

/**
 * Custom stack class using abstract data type
 * @author Bobby Wettig
 * @version 20170408
 */
public class Stack<T> {
 
    private int top;
    private T[] array;
    
    /**
     * Constructor, creates new instance of stack of specified size
     * @param size size of the new stack 
     */
    public Stack(int size) {
        Object[] array1 = new Object[size];
        array = (T[]) array1;
        top = -1;
    }
    
    /**
     * Adds a new entry to the top of the stack
     * @param anItem item to be added to the stack
     * @return true if successful, false if not
     */
    public boolean push(T anItem) {
        top++;
        array[top] = anItem;
        
        return true;
    }
    
    /**
     * Returns the item at the top of the stack without removing it
     * @return item at the top of the stack
     */
    public T peek() {
        if (top >= 0)
            return array[top];
        else
             return null;
    }
    
    /**
     * Returns and removes the item at the top of the stack
     * @return item at the top of the stack
     */
    public T pop() {
        if (top >= 0)
        {
            top--;
            return array[top+1];
        }
        else
            return null;
    }
    
    /**
     * Determines if the stack is empty
     * @return true if the stack is empty, false if not
     */
    public boolean isEmpty() {
        return(top == -1);
    }
    
    /**
     * Removes all entries from the stack
     */
    public void clear() {
        top = -1;
    }
}
