package com.amouzakidis.challenge;
/*
 Binary Tree Level Order Traversal

 Given the root of a binary tree, return the level order traversal of its nodes' values.
 (i.e., from left to right, level by level).
 */
import com.amouzakidis.challenge.helper.TreeNode;

import java.util.*;

public class LevelOrderTraversalOfABinaryTree {

    public static void main(String[] args){
        TreeNode tmp1 = new TreeNode(7);
        TreeNode tmp2 = new TreeNode(4);
        TreeNode root = new TreeNode(2, tmp1, tmp2);

        tmp1 = new TreeNode(6);
        tmp2 = root;
        root = new TreeNode(5, tmp1, tmp2);

        tmp1 = new TreeNode(0);
        tmp2 = new TreeNode(8);
        TreeNode root2 = new TreeNode(1, tmp1, tmp2);

        tmp1 = root;
        tmp2 = root2;
        root = new TreeNode(3, tmp1, tmp2);

        LevelOrderTraversalOfABinaryTree solution = new LevelOrderTraversalOfABinaryTree();
        List<List<Integer>> toPrint = solution.levelOrder(root);
        for(List<Integer> lst: toPrint){
            System.out.println(lst);
        }
    }

    public List<List<Integer>> levelOrder( TreeNode root ) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) {
            return ret;
        }
        int currentLevel = 0;
        Map<TreeNode, Integer> nodeToLevel = new HashMap<>();
        List<Integer> currentRow = new LinkedList<>();
        ret.add( currentRow );
        Deque<TreeNode> toSearch = new LinkedList<>();
        toSearch.addFirst( root );
        nodeToLevel.put( root, currentLevel );
        while ( !toSearch.isEmpty() ) {
            TreeNode currentNode = toSearch.removeFirst();
            if ( nodeToLevel.get( currentNode ) > currentLevel ){
                currentLevel = nodeToLevel.get( currentNode );
                currentRow = new LinkedList<>();
                ret.add( currentRow );
            }
            currentRow.add( currentNode.val );
            if ( currentNode.left != null ){
                toSearch.add( currentNode.left );
                nodeToLevel.put( currentNode.left,currentLevel + 1 );
            }
            if ( currentNode.right != null){
                toSearch.add( currentNode.right );
                nodeToLevel.put( currentNode.right, currentLevel + 1 );
            }
        }
        return ret;
    }
}
