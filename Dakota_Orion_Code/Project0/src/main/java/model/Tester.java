package model;


public class Tester {

	public static void main(String[] args) {
/*		int maxUserId = Service.getMaxUsersBeanId();
		System.out.println(maxUserId);
		List<UsersBean> u = Service.getAllUsersBean();
		for(UsersBean x : u) {
			System.out.println(x.toString());
		}
		
		System.out.println(Service.getUsersBean(1));*/
		Service.deleteUsersBean(3);
	}

}
