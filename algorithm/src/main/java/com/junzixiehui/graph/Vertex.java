package com.junzixiehui.graph;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/4/6  1:04 PM
 * @version: 1.0
 */
public class Vertex {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vertex{" + "name='" + name + '\'' + '}';
	}
}
