package lettersequences;

import java.util.EmptyStackException;
import java.util.Stack;

class QueueWithTowStacks {
    Stack<Integer> stackPush;
    Stack<Integer> stackPop;

    public QueueWithTowStacks() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }
    
    public void push(int x) {
        if(stackPush.isEmpty() && !stackPop.isEmpty()) {
            stackPush = reverse(stackPop); 
        }
        stackPush.push(x);
    }
    
    public int pop() {
        if(stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new EmptyStackException();
        }
        if(stackPop.isEmpty() && !stackPush.isEmpty()) {
            stackPop = reverse(stackPush); 
        }
        return stackPop.pop();
    }
    
    public Stack<Integer> reverse(Stack<Integer> stack) {
        Stack<Integer> returnStack = new Stack<>();
        while(!stack.isEmpty()) {
            returnStack.push(stack.pop());
        }
        return returnStack;
    }
    
    public int peek() {
        if(stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new EmptyStackException();
        }
        if(stackPop.isEmpty() && !stackPush.isEmpty()) {
            stackPop = reverse(stackPush); 
        }
        return stackPop.peek();
    }
    
    public boolean empty() {
        return stackPop.isEmpty() && stackPush.isEmpty();
    }

    @Override
    public String toString() {
        if(stackPop.isEmpty()){
            return stackPush.toString();
        }
        return stackPop.toString();
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[3][3];
        for(int row=0; row<3; row++) {
            for(int col=0; col<3; col++) {
                if(mat[row][col]==0) {
                    distance[row][col]=0;
                } else {
                    int[] pos = {row, col};
                    distance[row][col] = findClosestZero(mat, pos);
                }
            }
        }
        return distance;
    }
    
    public int findClosestZero(int[][] mat, int[] pos) {
        int minDis = 5;
        int dis;
        for(int row=0; row<3; row++) {
            for(int col=0; col<3; col++) {
                if(mat[row][col]==0) {
                    int[] zeroPos = {row, col};
                    dis = distance(pos, zeroPos);
                    minDis = dis<minDis ? dis:minDis;
                } 
            }
        }
        return minDis;
    }
    
    public int distance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0]-pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
    
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */