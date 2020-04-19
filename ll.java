import java.util.*;
class LinkedList
{
	Node head;
	 class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}

	public  LinkedList insert(LinkedList list,int data)
	{
		Node new_node=new Node(data);
		new_node.next=null;
		if(list.head==null)
		{
			list.head=new_node;
		}
		else
		{
			Node last=list.head;
			while(last.next!=null)
			{
				last=last.next;
			}
			last.next=new_node;
		}
		return list;
	}
	//public static void delete()
	public  void printList(LinkedList list)
	{
		Node temp=list.head;
		System.out.print("Elements in list are:");
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public LinkedList reverse(LinkedList list)
	{
		Node temp=list.head;
		Node prev=null;
		Node next=null;
		while(temp!=null)
		{
			next=temp.next;
			temp.next=prev;
			prev=temp;
			temp=next;
		}
		list.head=prev;
		return list;
	}
	public LinkedList reversep(LinkedList list)
	{
		Node temp=list.head;
		while(temp!=null && temp.next!=null)
		{
			int t=temp.data;
			temp.data=temp.next.data;
			temp.next.data=t;
			temp=temp.next.next;
		}
		return list;
	}
	public void middle(LinkedList list)
	{
		Node t1=list.head,t2=list.head;
		while(t1!=null && t2!=null && t2.next!=null)
		{
					t1=t1.next;
			t2=t2.next.next;

		}
		System.out.println("Middle element is :"+t1.data);
	}
	public void loop(LinkedList  list)
	{
		//list.head.next.next=list.head;
		Node t1=list.head;
		Node t2=list.head.next;
		while(t1!=null && t2!=null && t2.next!=null)
		{
			if(t1==t2)
			{
				System.out.println("Loop exists\n");
				return;
			}
			t1=t1.next;
			t2=t2.next.next;
		}
		System.out.println("Loop doesnt exist\n");
	}
	public void startloop(LinkedList list)
	{
		list.head.next.next.next=list.head.next;
		Node t1=list.head;
		Node t2=list.head.next;
		while(t1!=null && t2!=null && t2.next!=null)
		{
			if(t1==t2)
			{
				break;
			}
			t1=t1.next;
			t2=t2.next.next;
		}
		t2=list.head;
		while(t1.next!=t2)
		{
			t1=t1.next;
			t2=t2.next;
		}
		System.out.println("Start node of loop contains data: "+t1.data);

	}
	public void nthend(LinkedList list,int n)
	{
		Node t1=list.head;
		Node t2=list.head;
		for(int i=0;i<n;i++)
		{
			if(t1==null)
			{
				return;
			}
			t1=t1.next;
		}
		while(t1!=null)
		{
			t1=t1.next;
			t2=t2.next;
		}
		System.out.println("Required element is :"+t2.data);
	}
	public void palindrome(LinkedList list)
	{
		int top=-1;
		Node t1=list.head;
		int count=0;
		while(t1!=null)
		{
			count++;
			t1=t1.next;
		}
		int arr[]=new int[count/2+1];
		t1=list.head;
		for(int i=0;i<count/2;i++)
		{
			arr[++top]=t1.data;
			t1=t1.next;
		}
		if(count%2!=0)
			t1=t1.next;
		while(t1!=null)
		{
			if(arr[top--]!=t1.data)
			{
				System.out.println("Not a palindrome\n");
				return;
			}
			t1=t1.next;
		}
		
		System.out.println("palindrome\n");
	}
}
class B
{
	public static void main(String [] args)
	{
		int i,ele,ch;
		LinkedList list=new LinkedList();
		do
		{
			System.out.print("1.insert\n2.print\n3.reverse\n4.reversep\n5.middle\n6.looptest\n7.startnode\n8.nth node from end\n9.palindrome\n10.exit\n");
			Scanner sc=new Scanner(System.in);
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:System.out.print("Enter the element");
						ele=sc.nextInt();
						list=list.insert(list,ele);
						break;
				case 2:list.printList(list);
						break;
				case 3:list.reverse(list);
						break;
				case 4:list.reversep(list);
						break;
				case 5:list.middle(list);
						break;
				case 6:list.loop(list);
						break;
				case 7:list.startloop(list);
						break;
				case 8:System.out.println("Enter n value");
						int k=sc.nextInt();
						list.nthend(list,k);
						break;
				case 9:list.palindrome(list);
						break;
				case 10:break;
			}

		}while(ch!=10);

	}
}