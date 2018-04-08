//John Eifert
package Bonus_Exercises;

//Does not currently work
public class Q50
{
	public static void main(String args[])
	{
		Q50 obj = new Q50();
		Both b1 = obj.new Both();
		Both b2 = obj.new Both();
		
		ThisThread t1 = obj.new ThisThread(b1, b2, "t1");
		t1.start();
		
		ThisThread t2 = obj.new ThisThread(b1, b2, "t2");
		t2.start();
		
	}
	
	

	
	public class Both
	{
		synchronized void writeTrue(String name, Both other)
		{
			System.out.println(name + " started writeTrue.");
			/*
			for(int i=0; i<20; i++)
			{
				System.out.println(true);
				try
				{
					Thread.sleep(100);
					other.writeFalse(name, this);
				}
				catch(Exception e)
				{
					System.out.println(name);
					System.out.println(true);
				}
			}
			*/
			Act.act(name);
			other.writeFalse(name, this);
			System.out.println(name + " ended writeTrue.");
		}
		
		synchronized void writeFalse(String name, Both other)
		{
			System.out.println(name + " started writeFalse.");
			/*
			for(int i=0; i<20; i++)
			{
				System.out.println(false);
				try
				{
					Thread.sleep(100);
					other.writeTrue(name, this);
				}
				catch(Exception e)
				{
					System.out.println(name);
					System.out.println(false);
				}
			}
			*/
			Act.act(name);
			other.writeTrue(name, this);
			System.out.println(name + " endeded writeTrue.");
		}
	}
	
	
	public class ThisThread extends Thread
	{
		private Both here;
		private Both there;
		String name;
		Thread thisThread;
		
		public ThisThread(Both b1, Both b2, String n)
		{
			this.here=b1;
			this.there=b2;
			this.name=n;
		}
		
		@Override
		public void run()
		{
			here.writeTrue(name, there);
		}
		
		public void start()
		{
			System.out.println("Starting " + name + ".");
			
			if(thisThread == null)
			{
				thisThread = new Thread(this, name);
				thisThread.start();
			}
		}
	}
		
//////////////////////////////////////////////////////////////////////////////////	
	
	public class ThatThread extends Thread
	{
		private Both here;
		private Both there;
		String name;
		Thread thisThread;
		
		public ThatThread(Both b1, Both b2, String n)
		{
			this.here=b1;
			this.there=b2;
			this.name=n;
		}
		
		@Override
		public void run()
		{
			there.writeFalse(name, here);
		}
		
		public void start()
		{
			System.out.println("Starting " + name + ".");
			
			if(thisThread == null)
			{
				thisThread = new Thread(this, name);
				thisThread.start();
			}
		}
	}
		
		
}

class Act
{
	static void act(String n)
	{
		try
		{
			System.out.println(n + " acted.");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println("Oops.");
		}
	}
}
