import java.util.Stack;

public class LargestAreaHisto {
    public static void main(String[] args) {
        int[] height={2,1,5,6,2,7,9,3};
        int Ans = LargestAreaRec(height);
        System.out.println(Ans);
    }
    public static int[] nextSmaller(int[] nums ){
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = n-1; i >=0; i--){
            while(stack.peek()!=-1 && nums[stack.peek()]>= nums[i]){
                stack.pop();
            }
            result[i]=stack.peek();
            stack.push(i);
        }
        return result;
    }
    public static int[] prevSmaller(int[] nums ){
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int  i =0;i <= n-1; i++){
            while(stack.peek()!=-1 && nums[stack.peek()]>= nums[i]){
                stack.pop();
            }
            result[i]=stack.peek();
            stack.push(i);
        }
        return result;
    }
    public static  int LargestAreaRec(int[] height){
        int n = height.length;
        int[] next = nextSmaller(height);
        int[] prev = prevSmaller(height);
        int area = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){
        int l = height[i];
        if(next[i]==-1){
            next[i]=n;
        }
        int b = next[i]-prev[i]-1;
        int newarea= l*b;
        area = Math.max(area,newarea); 
    }
    return area;
    }
}
