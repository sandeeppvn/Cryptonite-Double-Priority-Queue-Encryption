package lstack;
public class Linkedstack
{
	Listnode head;
	public Linkedstack()
	{
		head=null;
	}
	public String pop()//return the first element or -1
	{
		String x="";
		if(head==null)
			System.out.println("Empty Stack..pop");
		else
		{
			x=head.getdata();
			head=head.getnext();
		}
		return x;
	}
	public void push(String x)//insert first
	{
		Listnode  newnode;
		newnode= new Listnode(x);
		newnode.setnext(head);
		head=newnode;
	}
	public void insertBottom(String x)
	{
		if(isEmpty())
			push(x);
		else
		{
			String temp=pop();
			insertBottom(x);
			push(temp);
		}
	}
	public void reverse()
	{
		if(isEmpty())
		{}
			else
			{
				String temp = pop();
				reverse();
				insertBottom(temp);
			}
		}
		public boolean isEmpty()
		{
			return (head==null);
		}
		public String display()
		{
			String disp="";
			Listnode curr;
			curr=head;
			while(curr!=null)
			{
				disp+=curr.getdata();
				curr=curr.getnext();
			}
			return disp;
		}
		public String undisplay()
		{
			String disp="";
			Listnode curr;
			curr=head;
			if(curr==null)
				System.out.println("Empty Stack..undisplay");
			else
			{
				while(curr!=null)
				{
					if(curr.getdata()!="\r\n")
						disp+=curr.getdata()+"\r\n";
					else
						disp+=curr.getdata();
					curr=curr.getnext();
				}
			}
			return disp;
		}
	}
	class Listnode
	{
		private String data;
		Listnode next;
		Listnode(String x)
		{
			data=x;
			next=null;
		}
		public void setdata(String x)
		{
			data = x;
		}
		public void setnext(Listnode newnode)
		{
			next=newnode;
		}
		public String getdata()
		{
			return data;
		}
		public Listnode getnext()
		{
			return next;
		}
	}

