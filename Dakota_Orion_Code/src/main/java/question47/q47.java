package question47;

import java.util.LinkedList;

public class q47 {

	public static void main(String[] args) {
		LinkedList<Integer> ls = new LinkedList<Integer>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(4);
		System.out.println(findMiddle(ls));
	}
	
	@SuppressWarnings("unchecked")
	static Object findMiddle(LinkedList<Integer> list) {
		int i=0;
		LinkedList<Integer> middle = new LinkedList<Integer>();
		middle=(LinkedList<Integer>) list.clone();
		while(list.iterator().hasNext()) {
			list.remove();
			i++;
			if(i%2==0) {
				middle.remove();
			}
		}
		return middle.remove();
	}
}
