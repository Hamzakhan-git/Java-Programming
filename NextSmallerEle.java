import java.util.Stack;

public class NextSmallerEle {
    public static int[] nextSmallerElement(int[] num){
        int n = num.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=n-1; i>=0; i--){
            while(! stack.isEmpty() && stack.peek()>=num[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = nextSmallerElement(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
