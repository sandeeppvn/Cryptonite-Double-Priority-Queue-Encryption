package dpq;
import java.util.*;
class element
{
	private String data;
	private int ppty=0,spty=0;
	public String getdata()
	{
		return data;
	}
	public int getppty()
	{
		return ppty;
	}
	public int getspty()
	{
		return spty;
	}
	public void setvalues(String key, int p ,int s)
	{
		data=key;
		ppty=p;
		spty=s;
	}
}
public class DPQ
{
	private element[] q;
	private int size;
	private int count;
	public DPQ(int sz)
	{
		q=new element[sz+1];
		size=sz;
		count=0;
	}
	public void insert(String key,int p,int s)
	{
		element temp=new element();
		temp.setvalues(key,p,s);
		q[count++]=temp;
		int j=count-2;
		while(j>=0 && (q[j].getppty() > temp.getppty()))
		{
			q[j+1]=q[j];
			j--;
		}
		q[j+1]=temp;
	}
	public String display()
	{
		String disp="";
		int i;
		if(count==0)
			System.out.println("Empty Queue");
		else
		{
			for(i=0;i<count;++i)
			{
				disp+=q[i].getdata()+"\r\n";
			}
		}
		return disp;
	}
	public void sortppty()
	{
		element temp;
		for(int i = 0; i <count; i++)
		{
			for(int j = 1; j < (count -i); j++)
			{
				if(q[j-1].getppty() > q[j].getppty())
				{
					temp = q[j-1];
					q[j-1]=q[j];
					q[j]=temp;
				}
			}
		}
	}
	public void sortspty()
	{
		element temp;
		for(int i = 0; i <count; i++)
		{
			for(int j = 1; j < (count -i); j++)
			{
				if(q[j-1].getspty() > q[j].getspty())
				{
					temp = q[j-1];
					q[j-1]=q[j];
					q[j]=temp;
				}
			}
		}
	}
}

