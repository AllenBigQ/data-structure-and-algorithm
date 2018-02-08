package com.lucky.day05;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author Allen
 * 图的宽度优先遍历，使用队列
 */
public class Code_02_BFS {

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		//Set集合用来注册节点，
		HashSet<Node> map = new HashSet<>();
		queue.add(node);
		map.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			//循环弹出节点的nexts集合，没有被Set注册过就加入队列
			for (Node next : cur.nexts) {
				if (!map.contains(next)) {
					map.add(next);
					queue.add(next);
				}
			}
		}
	}
}

