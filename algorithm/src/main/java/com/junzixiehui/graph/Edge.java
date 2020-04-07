package com.junzixiehui.graph;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/4/6  1:05 PM
 * @version: 1.0
 */
public class Edge {

	private Vertex begin;
	private Vertex end;
	private long weight;

	public Vertex getBegin() {
		return begin;
	}

	public void setBegin(Vertex begin) {
		this.begin = begin;
	}

	public Vertex getEnd() {
		return end;
	}

	public void setEnd(Vertex end) {
		this.end = end;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}
}
