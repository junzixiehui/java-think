package com.junzixiehui.linked;

import lombok.Data;
import lombok.ToString;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/4/13  10:01 PM
 * @version: 1.0
 */
public class LinkedList {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		final Node head = linkedList.init();
		//final Node reverseList = linkedList.reverseList(head);
		//System.out.println(linkedList.reverseList(head));
		//System.out.println(linkedList.reverseListV2(head));
		System.out.println(linkedList.swapList(head));
	}

	// 1-2-3-4  2-1-4-3
	public Node swapList(Node head) {
		Node cur = head;
		Node pre = head.next;
		Node temp = null;
		while (cur != null) {
			final Node next = pre.next;

			pre.setNext(cur);
			cur.setNext(temp);
			temp = cur;

			cur = next;
			pre = next.next;
		}
		return cur;
	}

	public Node reverseList(Node head) {
		Node cur = null;
		Node pre = head;
		while (pre != null) {
			final Node next = pre.getNext();
			final Node next1 = next.getNext();
			next.setNext(pre);
			pre.setNext(cur);

			cur = next;
			pre = next1;
		}
		return cur;
	}

	public Node reverseListV2(Node head) {
		Node cur = null;
		Node pre = head;
		while (pre != null) {
			final Node t = pre.getNext();
			pre.setNext(cur);

			cur = pre;
			pre = t;
		}
		return cur;
	}

	private Node init() {


		Node node3 = new Node();
		node3.setData(4);
		node3.setNext(null);

		Node node2 = new Node();
		node2.setData(3);
		node2.setNext(node3);

		Node node1 = new Node();
		node1.setData(2);
		node1.setNext(node2);


		Node head = new Node();
		head.setData(1);
		head.setNext(node1);

		return head;
	}

	@Data
	@ToString
	private static class Node {

		private int data;
		private Node next;
	}
}
