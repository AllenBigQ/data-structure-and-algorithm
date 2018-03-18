package com.lucky.offer66;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * @author Allen
 *
 */
import java.util.ArrayList;
import java.util.Stack;

public class Solution3 {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList list = new ArrayList<Integer>();
		if (listNode == null) {
			return list;
		}
		Stack s = new Stack();
		while (listNode != null) {
			s.push(listNode.val);
			listNode = listNode.next;
		}
		while (!s.isEmpty()) {
			list.add(s.pop());
		}
		return list;
	}
}
