package com.junzixiehui.linked;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2021/3/14  10:56 PM
 * @version: 1.0
 */
public class LinkedSimple {

	public static void main(String[] args) {

		//a->b->c->d

		Node node3 = new Node("3", null);
		Node node2 = new Node("2", node3);
		Node node1 = new Node("1", node2);
		bianli(node1);
		final Node reveser = reveser(node1);
		bianli(reveser);

		System.out.println("===判断有环==");

		final Node node = checkRing(node1);
		bianli(node);
	}

	private static void bianli(Node head) {

		Node current = head;

		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	static class Node {

		private String data;
		private Node next;

		public Node(String data, Node node) {
			this.data = data;
			this.next = node;
		}
	}

	//翻转链表
	private static Node reveser(Node head) {

		Node pre = null;
		Node current = head;

		while (current != null) {

			Node next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}
	//判断链表有环
	private static Node checkRing(Node head) {

		if (head == null || head.next == null){
			return null;
		}

		Node slow = head;
		Node fast = head.next.next;

		while (slow != fast || ( slow == null || fast.next == null)) {
			slow = slow.next;
			fast = fast.next.next ;
		}
		return slow;
	}
}
