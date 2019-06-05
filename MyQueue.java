/*
* File Name : MyQueue.java
*
* The Science of Data Structures
*
* Course : CSC172 SPRING 2015
*
* Assignment : PROJECT 2
*
* Author : Annabelle Taylor
*
* Lab Partner : n/a
*
* Lab Session : TR 4:50-6:05 pm
*
* Lab TA : Pauline Chen
*
* Last Revised : February 24, 2015
*
*/

public class MyQueue
{
	qNode head = new qNode();
	qNode tail = new qNode();
	
	public MyQueue()
	{
		head.prev = null;
		head.next = tail;
		tail.prev = head;
		tail.next = null;
	}
	
	public boolean isEmpty()
	{
		if (head.next == tail)
			return true;
		else
			return false;
	}
	public void enqueue(String x)
	{
		qNode newNode = new qNode();
		newNode.data = x;
		
		tail.prev.next = newNode;
		newNode.prev = tail.prev;
		tail.prev= newNode;
		newNode.next = tail;
	}
	public String dequeue()
	{
		qNode temp = head;
		
		if(isEmpty() == false)
		{
			head.data = null;
			head = head.next;
			(head.next).prev = head;
			return temp.data;
		}
		else
			return null;
	}
	public String peek()
	{
		if(isEmpty() == false)
			return head.next.data;
		else
			return null;
	}
	
	public void printList()
	{
		qNode current = head.next;
		while (current.next != null)
		{
			System.out.print(current.data + " ");
			current.next.prev = current;
			current = current.next;
		}
	}
}