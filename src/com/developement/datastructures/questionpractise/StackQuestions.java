package com.developement.datastructures.questionpractise;

import com.developement.datastructures.linkedlist.Node;

import java.util.Stack;

/*
     --------- STRATEGY ---------
  traversing array or list and pushing data to the stack and while 2nd traversal we in some way or other
   are using stack's data to manipulate the list for the use cases.
 */

/*
      ------- basic approach---------
      1.parenthesis balancing as a concept would be ( for every closing bracket there should
      be corresponding matching opening bracket )
      2.for any balanced parenthesis there would be a point where closing parenthesis would have immediate
      matching opening parenthesis, here balancing would start as whole.
      3.therefore stack is best for such a problem. we keep on adding open parenthesis into the stack and
      for every closing one we match it with the top of the stack for balancing. if matches then pop if not then
      unbalanced.
      4.so every time we are getting a closing bracket we are trying to match it with corresponding unmatched open
      bracket.
  */


// practise for basic stack question
public class StackQuestions {

    private static final boolean NOT_BALANCED = false;
    private static final boolean BALANCED = true;

    // reversing string, words remain unchanged
    // time complexity is O(n).
    // space complexity is O(n).
    public String reverseStringWordsUnchanged(String string){

        // stack to save string words
        Stack<String> stack = new Stack<String>();
        // saving words into string array using split method
        String[] array = string.split("\\s");
        // using string buffer to avoid too many garbage objects creation
        StringBuffer sb = new StringBuffer();

        // looping in array and pushing it to stack
        for(int i = 0; i < array.length; i++){
            stack.push(array[i]);
        }

        // looping in array and appending it to string buffer
        for(int i = 0; i < array.length; i++){
             array[i] = stack.pop();
             sb.append(array[i] + " ");
        }

        // converting buffer to string
        return sb.toString();
    }

    // here a string is reversed completely.
    // time complexity is O(n).
    // space complexity is O(n).
    public String reverseString(String string){

        // using stack to store each character.
        Stack<Character> stack = new Stack<Character>();
        // converting string to char array using toChararray method
        char[] array = string.toCharArray();

        // looping array and pushing data to stack
        for(int i = 0; i < array.length; i++){
            stack.push(array[i]);
        }

        // looping in array and filling data through stack.
        for(int i = 0; i < array.length; i++){
            array[i] = stack.pop();
        }

        // converting char array to string and returning it
        return String.valueOf(array);
    }

    // reversing the linked list
    // time complexity is O(n).
    // space complexity is O(n).
    public Node reverseLinkedList(Node head){
        // temp for traversing the list
        Node temp = head.getNext();
        // saving each node's address to the stack
        Stack<Node> stack = new Stack<Node>();

        // pshing each node address to the stack
        while(temp != null){
            stack.push(temp);
            temp = temp.getNext();
        }

        // top of the stack now points to last node, hence changing head to it.
        head  = stack.pop();
        // temp now pts to the last node
        temp = head;

        // keeping on poping address from stack and chaning the next for each node.
        // as stack has addresses in reverse order
        while(!stack.isEmpty()){
            temp.setNext(stack.pop());
            temp = temp.getNext();
        }

        // setting earlier 1st node to the last one.
        temp.setNext(null);

        // returning head, calling method will have list.head.setNext() as per my own LinkedList implementation;
        return head;
    }

    // checking if parenthesis are balanced or not.
    // time complexity is O(n).
    // space complexity is O(n).
    public boolean isParenthesisBalanced(String string){

        Stack<Character> stack = new Stack<Character>();

        char[] array = string.toCharArray();

        for(int i = 0; i < array.length; i++){
            if (array[i] == '(' || array[i] == '[' || array[i] == '{') {
                stack.push(array[i]);
            }else{
                if(stack.isEmpty()){
                    return NOT_BALANCED;
                }
                if(array[i] == ')' && stack.peek() == '('){
                    stack.pop();
                }
                if(array[i] == '}' && stack.peek() == '{'){
                    stack.pop();
                }
                if(array[i] == ']' && stack.peek() == '['){
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()){
            return BALANCED;
        }else{
            return NOT_BALANCED;
        }

    }

    //evaluating a postfix notation value.
    // time complexity is O(n).
    // space complexity is O(n).
    public Integer evaluatePostfix(String string){
        Stack<Integer> stack  = new Stack<Integer>();
        int value = 0;
        char[] array = string.toCharArray();
        int value1 = 0;
        int value2 = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == '+' || array[i] == '-' || array[i] == '*' || array[i] == '/'){

                value2 = stack.pop();
                value1 = stack.pop();
                switch (array[i]){
                    case '+':
                        value = value1 + value2;
                        break;
                    case '-':
                        value = value1 - value2;
                        break;
                    case '*':
                        value = value1 * value2;
                        break;
                    case '/':
                        value = value1 / value2;
                }
                stack.push(value);
            }else{
                /*
                  parse int is being used as we have char array, hence if we directly push it into a integer stack
                  unicode value of that number would be stored and when that stack value would be called theat
                  unicode value for char would be called eg '4' unicode is 52, tat would be called
                  so we convert it into string and then string is parsed to int.
                 */
                stack.push(Integer.parseInt((array[i]) + ""));
            }
        }
        return value;
    }

    //evaluating a postfix notation value with larger values using string.split().
    // time complexity is O(n).
    // space complexity is O(n).
    public Integer evaluatePostfixString(String string){

        Stack<Integer> stack  = new Stack<Integer>();
        int value = 0;
        String[] array = string.split("\\s");
        int value1 = 0;
        int value2 = 0;

        for(int i = 0; i < array.length; i++){
            if("+".equals(array[i]) || "-".equals(array[i]) || "*".equals(array[i]) ||  "/".equals(array[i])){

                value2 = stack.pop();
                value1 = stack.pop();

                switch (array[i]){
                    case "+":
                        value = value1 + value2;
                        break;
                    case "-":
                        value = value1 - value2;
                        break;
                    case "*":
                        value = value1 * value2;
                        break;
                    case "/":
                        value = value1 / value2;
                }
                stack.push(value);
            }else{
                stack.push(Integer.parseInt((array[i])));
            }
        }
        return value;
    }


    // infix to postfix notation including parenthesis.
    public String convertInToPostFix(String string){
        char[] array = string.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < array.length; i++){
            if(array[i] != '+' || array[i] != '-' || array[i] != '*' || array[i] != '/'){
                stringBuffer.append(array[i] + " ");
            }else{
                stack.push(array[i]);
            }
        }

        return string;
    }
    
}
