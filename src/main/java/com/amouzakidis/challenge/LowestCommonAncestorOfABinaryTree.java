package com.amouzakidis.challenge;

import com.amouzakidis.challenge.helper.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args){
        TreeNode tmp1 = new TreeNode(7);
        TreeNode tmp2 = new TreeNode(4);
        TreeNode root = new TreeNode(2, tmp1, tmp2);

        TreeNode p = tmp1;
        TreeNode q = tmp2;

        tmp1 = new TreeNode(6);
        tmp2 = root;
        root = new TreeNode(5, tmp1, tmp2);

        tmp1 = new TreeNode(0);
        tmp2 = new TreeNode(8);
        TreeNode root2 = new TreeNode(1, tmp1, tmp2);

        tmp1 = root;
        tmp2 = root2;
        root = new TreeNode(3, tmp1, tmp2);

        LowestCommonAncestorOfABinaryTree solution = new LowestCommonAncestorOfABinaryTree();
        TreeNode lowestCommonAncestor = solution.lowestCommonAncestor(root, p, q);
        if(lowestCommonAncestor != null){
            System.out.println(lowestCommonAncestor.val);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pathToP = findNode(root, p);
        Deque<TreeNode> pathToQ = findNode(root, q);
        if(pathToP == null || pathToQ == null){
            return null;
        }
        TreeNode ret = pathToP.getFirst();
        while( pathToP.getFirst() == pathToQ.getFirst() ) {
            ret = pathToP.getFirst();
            pathToP.removeFirst();
            pathToQ.removeFirst();
        }

        return ret;
    }

    Deque<TreeNode> findNode(TreeNode root, TreeNode target){
        Map<Integer,TreeNode> parrents = new HashMap<>();
        Deque<TreeNode> path = new LinkedList<>();
        Deque<TreeNode> toSearch = new LinkedList<>();
        toSearch.addLast(root);
        while(!toSearch.isEmpty()){
            TreeNode currentNode = toSearch.removeLast();
            if( currentNode == target ){
                while(currentNode != null){
                    path.addFirst(currentNode);
                    currentNode = parrents.get(currentNode.val);
                }
                return path;
            }
            if(currentNode.left != null){
                toSearch.addLast(currentNode.left);
                parrents.put(currentNode.left.val, currentNode);
            }
            if(currentNode.right != null){
                toSearch.addLast(currentNode.right);
                parrents.put(currentNode.right.val, currentNode);
            }
        }
        return null;
    }
}
