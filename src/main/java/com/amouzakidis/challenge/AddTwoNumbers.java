package com.amouzakidis.challenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) throws Exception {
        ListNode num1 = ListNode.Build(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode num2 = ListNode.Build( new int[]{9,9,9,9});
        ListNode output = AddTwoNumbers.addTwoNumbers(num1, num2);
        int[] outputArray = output.toInbArray();
        int[] expectedOutput = new int[]{8,9,9,9,0,0,0,1};
        if(!Arrays.equals(expectedOutput, outputArray)){
            throw new Exception("Output should be " + Arrays.toString(expectedOutput) + " but it was " + Arrays.toString(outputArray));
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;
        ListNode ret = new ListNode();
        ListNode current = ret;
        while(l1 != null || l2 != null){
            int val1 = 0;
            if( l1 != null ) {
                val1 = l1.val;
                l1 = l1.next;
            }
            int val2 = 0;
            if( l2 != null ) {
                val2 = l2.val;
                l2 = l2.next;
            }
            current.val =  (val1 + val2 + extra) % 10;
            extra = (val1 + val2 + extra) / 10;
            if( l1 != null  || l2 != null ){
                current.next = new ListNode();
                current = current.next;
            }
        };
        if(extra > 0 ){
            current.next = new ListNode();
            current = current.next;
            current.val = extra;
        }
        return ret;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode Build(int[] vals) {
        ListNode current = new ListNode(vals[0]);
        ListNode ret = current;
        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode();
            current = current.next;
            current.val = vals[i];
        }
        return ret;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        ListNode current = this;
        do {
            str.append(current.val);
            current = current.next;
        } while (current != null);
        return str.reverse().toString();
    }

    public int[] toInbArray() {
        List<Integer> retList = new LinkedList<>();
        ListNode current = this;
        do{
            retList.add(current.val);
            current = current.next;
        } while (current != null);
        return retList.stream().mapToInt(i->i).toArray();
    }
}

