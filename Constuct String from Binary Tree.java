/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    ->remember to process leaves specifically
    ->if right child is null, don't need to process since it's preorder
    ->if left child is null, need to return ""
*/
class Solution {
    public String tree2str(TreeNode t) {
        if(t == null)
        {
            return "";
        }
        String cur = String.valueOf(t.val);
        // if current node is leaf, return cur
        if(t.left == null && t.right == null)
        {
            return cur;
        }
        String left = tree2str(t.left);
        String right = "";
        //right empty node can be discarded 
        if(t.right != null)
        {
            right = tree2str(t.right);
            return cur+"("+left+")"+"("+right+")";
        }
        return cur+"("+left+")";
    }
}