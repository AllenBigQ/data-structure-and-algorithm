package com.lucky.day05;

import java.util.HashSet;
import java.util.Stack;
/**
 * 
 * @author Allen
 * 图的深度优先遍历，使用栈
 */
public class Code_03_DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			//弹出栈顶元素
			Node cur = stack.pop();
			//遍历当前元素的nexts集合，如果没有注册，压入当前元素和next元素并注册next然后打印next
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}
}

