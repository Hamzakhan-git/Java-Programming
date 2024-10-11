import java.util.Stack;
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + solution.largestRectangleArea(heights));
    }
    private int[] nextSmallerElement(int[] num){
        int n = num.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=n-1; i>=0; i--){
            while(stack.peek() != -1 && num[stack.peek()] >= num[i]){
                stack.pop();
            }
            result[i] =  stack.peek();
            stack.push(i);
        }
        return result;
    }

    private int[] prevSmallerElement(int[] num){
        int n = num.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0; i<n; i++){
            while(stack.peek() != -1 && num[stack.peek()] >= num[i]){
                stack.pop();
            }
            result[i] =  stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
       
       int[] next = nextSmallerElement(heights);
        
       int[] prev = prevSmallerElement(heights);
        int area = Integer.MIN_VALUE;
        for(int i =0; i<n ; i++){
            int l= heights[i];
            if(next[i]==-1){
                next[i]= n;
            }
            int b = next[i]-prev[i]-1;
           int newarea = l*b;
            area = Math.max(area, newarea);

        }
        return area;
    }
    
    
}