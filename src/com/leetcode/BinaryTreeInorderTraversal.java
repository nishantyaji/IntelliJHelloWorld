package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return list;
    }

    public void inOrder(TreeNode root) {
        if(Objects.isNull(root)) {
            return;
        }
        if(Objects.nonNull(root.left)){
            inOrder(root.left);
        }
        list.add(root.val);
        if(Objects.nonNull(root.right)){
            inOrder(root.right);
        }
    }

}
