//John Eifert
package Bonus_Exercises;

import java.util.ArrayList;
import java.util.Scanner;

//Does not currently work
public class Q64
{
	public static void main(String args[])
	{
		Q64 here = new Q64();
		ArrayList<Branch<Integer>> row = new ArrayList<Branch<Integer>>();
		ArrayList<ArrayList<Branch<Integer>>> matrix = new ArrayList<ArrayList<Branch<Integer>>>();
		
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the number of desired rows of Pascal's triangle: ");
		int rows=in.nextInt();
		in.close();
		
		//Creates and prints the first row of Pascal's Triangle:
		row.add(here.new Branch(1));
			//For centering:
		for(int i=0; i<((rows*2)/2); i++)
		{
			System.out.print(" ");
		}
		System.out.print(row.get(0).value);
		matrix.add(row);
		
		//Creates and prints the rest of Pascal's Triangle:
		for(int i=0; i<rows; i++)
		{
			//For centering:
			for(int j=0; j<((rows-(i+1))*2); j++)
			{
				System.out.print(" ");
			}
			
			for(int j=0; j<matrix.get(i).size(); j++)
			{
				
				
				
			}
			
		}
		
		
	}
	
	
	class Branch<type>
	{
		type value;
		Branch<type> parent1;
		Branch<type> parent2;
		Branch<type> child1;
		Branch<type> child2;
		Branch<type> sibling1;
		Branch<type> sibling2;
		
		public Branch(type v, Branch<type> p1, Branch<type> p2)
		{
			value=v;
			parent1=p1;
			parent2=p2;
		}
		public Branch(type v, Branch<type> p1)
		{
			value=v;
			parent1=p1;
		}
		public Branch(type v)
		{
			value=v;
		}
		
		public void addSib(Branch<type> sib)
		{
			if(this.sibling1 == null)
			{
				this.sibling1=sib;
			}
			else
			{
				this.sibling2=sib;
			}
		}
		
		public Branch<type> makeChild(type v, Branch<type> otherParent)
		{
			if(this.child1==null)
			{
				Branch<type> child = new Branch<type>(v, this, otherParent);
				this.child1=child;
				return(child);
			}
			else
			{
				Branch<type> child = new Branch<type>(v, this, otherParent);
				child.addSib(this.child1);
				this.child1.addSib(child);
				this.child2=child;
				return(child);
			}
		}
		public Branch<type> makeChild(type v)
		{
			if(this.child1==null)
			{
				Branch<type> child = new Branch<type>(v, this);
				this.child1=child;
				return(child);
			}
			else
			{
				Branch<type> child = new Branch<type>(v, this);
				child.addSib(this.child1);
				this.child2=child;
				return(child);
			}
		}
	}
}
