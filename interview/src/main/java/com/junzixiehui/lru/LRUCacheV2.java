package com.junzixiehui.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2021/3/13  2:35 PM
 * @version: 1.0
 */
class LRUCacheV2 {

	private Map<Integer,ListNode> map = null;
	private ListNode head;
	private ListNode tail;
	private int capacity;

	class ListNode{
		private int key;
		private int value;
		private ListNode pre;
		private ListNode next;
		public ListNode(){

		}
		public ListNode(int key,int value){
			this.key = key;
			this.value = value;
		}
	}

	public LRUCacheV2(int capacity) {
		map = new HashMap<Integer, ListNode>();
		head = new ListNode();
		tail = new ListNode();
		head.next = tail;
		tail.pre = head;
		this.capacity = capacity;
	}

	public int get(int key) {
		if(map == null || map.size() == 0){
			return -1;
		}
		if(!map.containsKey(key)){
			return -1;
		}

		ListNode node = map.get(key);
		//将node删除
		remove(node);
		//将node写入尾结点
		addLast(node);
		return node.value;
	}

	private void remove(ListNode node){
		node.pre.next = node.next;
		node.next.next = node.pre;
	}

	private void addLast(ListNode node){
		tail.next = node;
		node.pre = tail;
	}


	public void put(int key, int value) {
		if(!map.containsKey(key)){
			//判断缓冲容量和节点数量
			if(map.size() >= capacity){
				remove(head.next);
				map.remove(key);
			}

			ListNode node = new ListNode(key,value);
			//将节点写入尾结点
			addLast(node);
			map.put(key,node);
		} else {
			ListNode node = map.get(key);
			//将node删除
			remove(node);
			//将node写入尾结点
			addLast(node);
			//赋值
			node.value = value;
		}
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
