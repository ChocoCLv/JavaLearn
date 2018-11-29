package com.choco.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by choco on 2018/4/25.
 */
public class ValidateBinarySearchTree {
     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
      }

    class Solution{
        List<Integer> node_list = new ArrayList<>();
        public boolean isValidBST(TreeNode root) {
            if(root == null)
                return true;
            if(!dfs(root))
                return false;
            for(int i = 0 ; i < node_list.size()-1 ; i++){
                if(node_list.get(i) >= node_list.get(i+1))
                    return false;
            }
            return true;
           // return bfs(root);
        }

        private boolean dfs(TreeNode root){
            if(root.left != null){
                if(root.left.val >= root.val)
                    return false;
                if(!dfs(root.left))
                    return false;
            }

            node_list.add(root.val);

            if(root.right != null){
                if(root.right.val <= root.val)
                    return false;
                if(!dfs(root.right))
                    return false;
            }


            return true;
        }

        private boolean bfs(TreeNode root){
            if(root==null){
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode node;
            queue.add(root);
            while(!queue.isEmpty()){
                node = queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                    if(node.left.val >= node.val){
                        return false;
                    }
                }
                if(node.right!=null){
                    queue.add(node.right);
                    if(node.right.val <= node.val){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
