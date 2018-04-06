package Bonus;

public class Problem51 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final LiveThread T1 = new LiveThread("Thread 1", true); 
		final LiveThread T2 = new LiveThread("Thread 2", true); 
		
		final Resource r = new Resource(T1);
		
        Thread test1 = new Thread(new Runnable() 
        {
            public void run() 
            {
                T1.dostuff(r, T2);
            }
        });
        test1.start();
        
        Thread test2 = new Thread(new Runnable() 
        {
            public void run() 
            {
                T2.dostuff(r, T1);
            }
        });
        test2.start();
		
		
	}
	
	public static class Resource
	{
		private LiveThread owner;
		
		public Resource(LiveThread a)
		{
			owner = a;
		}
		
		public LiveThread getOwner()
		{
			return owner;
		}
		
		public synchronized void setOwner(LiveThread a) 
		{
	        owner = a;
	    }
	}
	
	public static class LiveThread
	{
		private String name;
		private boolean active;
		
		public LiveThread(String n, boolean a) 
		{
	        name = n;
	        active = a;
	    }

	    public String getName() 
	    {
	        return name;
	    }

	    public boolean isActive() 
	    {
	        return active;
	    }
	    
	    public synchronized void dostuff(Resource r, LiveThread other)
	    {
	    	while(active)
	    	{
	    		if(r.getOwner() != this)
	    		{
	    			try
	    			{
	    				wait(10);
	    			}
	    			catch(InterruptedException e)
	    			{
	    				
	    			}
	    			continue;
	    		}
	    		
	    		if(other.isActive())
	    		{
	    			System.out.println(getName() + " passing resource to " + other.getName());
	    			r.setOwner(other);
	    			continue;
	    		}
	    		
	    		System.out.println(getName() + "Should not get here.");
	            active = false;
	            r.setOwner(other);
	    	}
	    }
	}
}
