package com.test.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private int actualSize;
	private Map<Integer, Node> map;
	private DoublyLinkedList linkedList;

	public LRUCache(){
		this.map = new HashMap<>();
		this.linkedList =  new DoublyLinkedList();
	}

	public void put(int id, String data){
		if(map.containsKey(id)){
			Node node = map.get(id);
			node.setData(data);
			bringToFront(node);
		}else{
			Node node = new Node(id,data);
			if(actualSize < Constants.CAPACITY){
				actualSize++;
				add(node);
			}else{
				removeTail();
				add(node);
			}
		}
	}

	public Node get(int id){

		if(map.containsKey(id)){
			Node node = map.get(id);
			bringToFront(node);
			return node;
		}
		return null;
	}

	private void removeTail() {
		Node lastNode = map.get(linkedList.getTailNode().getId());
		linkedList.setTailNode(linkedList.getTailNode().getPrevious());
		if(linkedList.getTailNode() != null){
			linkedList.getTailNode().setNext(null);
		}
		map.remove(lastNode.getId());
		lastNode = null;
	}

	private void add(Node node) {
		if(linkedList.getHeadNode() == null && linkedList.getTailNode() == null){
			linkedList.setHeadNode(node);
			linkedList.setTailNode(node);
		}else{
			node.setNext(linkedList.getHeadNode());
			linkedList.getHeadNode().setPrevious(node);
			linkedList.setHeadNode(node);
		}
		map.put(node.getId(), node);
	}

	private void bringToFront(Node node) {
		if(node.getPrevious() !=null){
			node.getPrevious().setNext(node.getNext());
		}else{
			linkedList.setHeadNode(node.getNext());
		}
		if(node.getNext() != null){
			node.getNext().setPrevious(node.getPrevious());
		}else{
			linkedList.setTailNode(node.getPrevious());
		}
		add(node);
	}

	public void show(){
		Node start = this.linkedList.getHeadNode();
		while(start != null){
			System.out.print(start +"<->");
			start = start.getNext();
		}
	}
}
