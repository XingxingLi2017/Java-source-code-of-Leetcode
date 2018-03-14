/*
key idea: 
            after filling water, the shape of water trapper is convex, we just need to fill it one layer by one layer
    
    two pointer: left and right
    maintain the max left and max right
            compare h[left] and h[right] first, the smaller one is the number of layers that should be filled
                {
                    compare h[left] and h[max left]
                        determin whether update max left or fill water
                }
            same for right part
    stack: 
        1. fill the water channel from right part of the concave
            if stack is empty or h[i] <= stack.top
                push i
                get next i
            else
                pop bot;
                water of this bot = (min(h[i],h[stack.top])-h[bot])*(i - stack.top - 1)
*/
class Solution {
    public int trap(int[] height) {
        if(height.length <= 2)
            return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < height.length;){
            if(stack.isEmpty() || height[i] <=height[stack.peek()])
                stack.push(i++);
            // there is a bot
            else
            {
                int bot = stack.pop();
                int botWater = stack.isEmpty() ? 0:(Math.min(height[stack.peek()], height[i])-height[bot]) * (i - stack.peek() - 1);
               // System.out.println(bot+", "+i+", botWater = "+botWater);
                res += botWater;
            }
        }
        return res;
    }
}