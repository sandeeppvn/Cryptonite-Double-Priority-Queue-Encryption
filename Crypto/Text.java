package backend;
import java.io.*;
import java.util.*;
import dpq.*;
import lstack.*;
public class Text
{	static	int  key,i=0,x=0;
	static	dpq.DPQ  q;
	static lstack.Linkedstack list ;
	public static void encrypt(String a, String b)
	{
		StackReverse(a,b+"\\encrypt.txt");
		RandomLine(b);
		ShiftBit(b);
		//DeleteFiles(b);	//deletes the intermediate files
	}
	public static void decrypt(String b, String c, String d)
	{
		unShiftBit(b,d);
		unRandomLine(d);
		StackReverse(d+"\\decrypt2.txt",d+"\\decryptFinal.txt");
		//DeleteFiles(d);	//deletes the intermediate files
	}
	public static void StackReverse(String s,String t)
	{
		String fileName = s;
		String line = null;
		try
		{
			PrintWriter writer = new PrintWriter(t, "UTF-8");
			FileReader fileReader=new FileReader(fileName);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null)
			{
				list = new lstack.Linkedstack();
				for(int i=0; i<line.length();i++)
				{
					list.push(line.charAt(i)+"");
				}
				writer.println(list.display());
			}
			writer.close();
			bufferedReader.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Unable to open file"+fileName);
		}
		catch(IOException ex)
		{
			System.out.println("Error reading file"+fileName);
		}
	}
	public static void unStackReverse(String s,String t)
	{
		String fileName = s;
		String line = null;
		try
		{
			PrintWriter writer = new PrintWriter(t, "UTF-8");
			FileReader fileReader=new FileReader(fileName);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null)
			{
				list = new lstack.Linkedstack();
				for(int i=0; i<line.length();i++)
				{
					list.push(line.charAt(i)+"");
				}
				writer.println(list.display());
			}
			writer.close();
			bufferedReader.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Unable to open file"+fileName);
		}
		catch(IOException ex)
		{
			System.out.println("Error reading file"+fileName);
		}
	}
	public static void RandomLine(String b)
	{
		String fileName = b+"\\encrypt.txt";
		String line = null;
		try
		{
			PrintWriter writer = new PrintWriter(b+"\\encrypt2.txt", "UTF-8");
			FileReader fileReader=new FileReader(fileName);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			int i=0;
			int len=count(fileName);
			q=new dpq.DPQ(len);
			while((line = bufferedReader.readLine()) != null)
			{
				q.insert(line,i,(int)(Math.pow(Math.random()+1,10)*1000));
				i++;
			}
			q.sortspty();
			writer.println("\n"+q.display());
			writer.close();
			bufferedReader.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Unable to open file"+fileName);
		}
		catch(IOException ex)
		{
			System.out.println("Error reading file"+fileName);
		}
	}
	public static void unRandomLine(String d)
	{
		String fileName = d+"\\decrypt.txt";
		String line = null;
		try
		{
			PrintWriter writer = new PrintWriter(d+"\\decrypt2.txt", "UTF-8");
			FileReader fileReader=new FileReader(fileName);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			int i=0;
			int len=count(fileName);
			q.sortppty();
			writer.println("\n"+q.display());
			writer.close();
			bufferedReader.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Unable to open file"+fileName);
		}
		catch(IOException ex)
		{
			System.out.println("Error reading file"+fileName);
		}
	}
	public static int count(String filename) throws IOException
	{
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try
		{
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean endsWithoutNewLine = false;
			while ((readChars = is.read(c)) != -1)
			{
				for (int i = 0; i < readChars; ++i)
				{
					if (c[i] == '\n')
						++count;
				}
				endsWithoutNewLine = (c[readChars - 1] != '\n');
			}
			if(endsWithoutNewLine)
			{
				++count;
			}
			return count;
		}
		finally
		{
			is.close();
		}
	}
	public static void ShiftBit(String b)
	{
		key=((int)Math.pow(Math.random()+1,10)/10)%10;
		String fileName = b+"\\encrypt2.txt";
		String line = null;
		try
		{
			PrintWriter writer = new PrintWriter(b+"\\encryptFinal.txt", "UTF-8");
			FileInputStream fis = new FileInputStream(fileName);
			char current;
			while (fis.available() > 0)
			{
				current = (char) fis.read();
				int temp=(int)(current+key+1);
				String s=Character.toString((char)temp);
				writer.print((char)temp);
			}
			writer.close();
			fis.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void unShiftBit(String b, String d)
	{
		String fileName = b+"\\encryptFinal.txt";
		String line = null;
		try
		{
			PrintWriter writer = new PrintWriter(d+"\\decrypt.txt", "UTF-8");
			FileInputStream fis = new FileInputStream(fileName);
			char current;
			while (fis.available() > 0)
			{
				current = (char) fis.read();
				int temp=(int)(current-key-1);
				String s=Character.toString((char)temp);
				writer.print((char)temp);
			}
			writer.close();
			fis.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void DeleteFiles(String bd)
	{
		try
		{
			File file1 = new File(bd+"\\encrypt.txt");
			file1.delete();
			File file2 = new File(bd+"\\encrypt2.txt");
			file2.delete();
			File file3 = new File(bd+"\\decrypt.txt");
			file3.delete();
			File file4 = new File(bd+"\\decrypt2.txt");
			file4.delete();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

