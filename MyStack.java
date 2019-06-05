/*
* File Name : MyStack.java
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

public class MyStack
{
	public sNode head;
	
	public boolean isEmpty()
	{
		if (head == null)
			return true;
		else
			return false;
	}
	public void push(String x)
	{
		sNode newNode = new sNode();
		newNode.data = x;
		newNode.next = head;
		head = newNode;
	}
	
	public String pop()
	{
		
		if(head != null)
		{
			String temp = head.data;
			head.data = null;
			head = head.next;
			return temp;
		}
		else
			return null;
	}
	
	public String peek()
	{	
		if(isEmpty() == false)
		{
			if(head != null)
				return head.data;
			else
				return null;
		}
		else
			return null;
	}
	
	public void printList()
	{
		sNode temp = head;
		
		while(temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
}