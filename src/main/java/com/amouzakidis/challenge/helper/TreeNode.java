package com.amouzakidis.challenge.helper;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public static TreeNode arrayToBinaryTree(ArrayList<Integer> values){
        TreeNode root = new TreeNode( values.get(0) );
        List<TreeNode> prevRow = new ArrayList<>(1);
        List<TreeNode> currentRow = new ArrayList<>(2);
        prevRow.add( root );
        int currentRowSize = 1;

        for( int i = 1; i < values.size(); i ++ ){
            Integer val = values.get(i);
            TreeNode newNode = null;
            if(val != null){
                newNode = new TreeNode(val);
            }
            currentRow.add(newNode);
            boolean foundPos = false;
            do {
                for (TreeNode parent : prevRow) {
                    if (parent != null) {
                        if (parent.left != null) {
                            parent.left = newNode;
                            foundPos = true;
                            break;
                        } else if (parent.right != null) {
                            parent.right = newNode;
                            foundPos = true;
                            break;
                        }
                    }
                }
                if (!foundPos) {
                    prevRow = currentRow;
                    currentRow = new ArrayList<>(currentRow.size() * 2);
                }
            } while ( !foundPos );
        }
        return root;
    }
}
