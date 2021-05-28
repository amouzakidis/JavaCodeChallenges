package com.amouzakidis.challenge.helper;

public class TreeNode {

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode( int val){
        this(val, null, null);
    }

    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return val + "";
    }
}
