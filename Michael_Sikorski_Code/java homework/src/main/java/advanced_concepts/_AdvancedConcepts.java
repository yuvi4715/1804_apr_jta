package advanced_concepts;

import java.util.StringTokenizer;

import org.omg.CORBA.Context;
import org.omg.CORBA.ContextList;
import org.omg.CORBA.DomainManager;
import org.omg.CORBA.ExceptionList;
import org.omg.CORBA.NVList;
import org.omg.CORBA.NamedValue;
import org.omg.CORBA.Object;
import org.omg.CORBA.Policy;
import org.omg.CORBA.Request;
import org.omg.CORBA.SetOverrideType;
import org.omg.SendingContext.RunTime;

public class _AdvancedConcepts {

	public static void main(String[] args) {
		Question16();
		Question17();
		Question18();
		Question19();
		Question20();
	}

	public static void Question16() {
		System.out.println("-- Question 16 --");
		StringBuilder sb = new StringBuilder("StringBuilder String");
		System.out.println(sb);
		sb.append(" -append");
		sb.deleteCharAt(13);
		sb.append(new Integer(0));
		System.out.println(sb);
		System.out.println();
	}

	public static void Question17() {
		System.out.println("-- Question 17 --");
		String tracks = "Ghost In The Machine:Evolution:Silicon Messiah:"
				+ "Born As A Stranger:The Hunger:The Brave:Identity:"
				+ "Reach For The Horizon:The Launch:Stare At The Sun";
		StringTokenizer st = new StringTokenizer(tracks, ":");
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken() + ",");
		}
		System.out.println();
		System.out.println();
	}

	public static void Question18() {
		System.out.println("-- Question 18 --");
		String firstNumber = "2000";
		String secondNumber = "2018";
		System.out.println(firstNumber + " + " + secondNumber + " = " + addStrings(firstNumber, secondNumber));
		System.out.println();
	}

	public static int addStrings(String first, String second) {
		int result = -1;
		int one;
		int two;
		try {
			one = Integer.parseInt(first);
			two = Integer.parseInt(second);
			result = one + two;
		} catch (Exception e) {

		}
		return result;
	}

	public static void Question19() {
		System.out.println("-- Question 19 --");
		System.gc();
		System.out.println("Garbage collection has been requested.");
		System.out.println();
	}

	public static void Question20() {
		System.out.println("-- Question 20 --");
		RunTime r = new RunTime() {
			
			@Override
			public Object _set_policy_override(Policy[] policies, SetOverrideType set_add) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Request _request(String operation) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void _release() {
				// might be used to free resources that are no longer needed
				System.out.println("The _release method might be used to free resources that are no longer needed");
			}
			
			@Override
			public boolean _non_existent() {
				// might be used to query a server object
				System.out.println("The _non_existent method might be used to query a server object");
				return false;
			}
			
			@Override
			public boolean _is_equivalent(Object other) {
				
				return false;
			}
			
			@Override
			public boolean _is_a(String repositoryIdentifier) {
				// might be used in load balancing to determine if the Object is capable of handling a request
				System.out.println("The _is_a method might be used in load balancing applications");
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int _hash(int maximum) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Policy _get_policy(int policy_type) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object _get_interface_def() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public DomainManager[] _get_domain_managers() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object _duplicate() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Request _create_request(Context ctx, String operation, NVList arg_list, NamedValue result,
					ExceptionList exclist, ContextList ctxlist) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Request _create_request(Context ctx, String operation, NVList arg_list, NamedValue result) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		r._non_existent();
		r._release();
		try {
			r._is_a("TEST");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
}
