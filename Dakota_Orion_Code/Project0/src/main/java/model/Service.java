package model;

import java.util.List;

public class Service {
	private static UsersDao dao1 = UsersAccountsDaoImpl.getInstance();
	private static AccountsDao dao2 = UsersAccountsDaoImpl.getInstance();
	
	public static boolean insertUsersBean(UsersBean u) {
		return dao1.insertUsersBean(u);
	}
	public static UsersBean getUsersBean(int id) {
		return dao1.getUsersBean(id);
	}
	public static List<UsersBean> getAllUsersBean(){
		return dao1.getAllUsersBean();
	}
	public static int getMaxUsersBeanId() {
		return dao1.getMaxUsersBeanId();
	}
	public static boolean deleteUsersBean(int u) {
		return dao1.deleteUsersBean(u);
	}
	public static List<Integer> getUserAccounts(int u) {
		return dao1.getUserAccounts(u);
	}
	public static boolean updateUsersBean(UsersBean user) {
		return dao1.updateUsersBean(user);
	}
	
	
	public static boolean createUserAccountRelationship(int uid, int aid) {
		return dao2.createUserAccountRelationship(uid, aid);
	}
	public static boolean insertAccountsBean(AccountBean a) {
		return dao2.insertAccountsBean(a);
	}
	public static AccountBean getAccountBean(int id) {
		return dao2.getAccountsBean(id);
	}
	public static List<AccountBean> getAllAccountsBeans(){
		return dao2.getAllAccountsBeans();
	}
	public static int getMaxAccountsBeanId() {
		return dao2.getMaxAccountsBeanId();
	}
	public static boolean deleteAccountsBean(int a) {
		return dao2.deleteAccountsBean(a);
	}
	public static boolean updateAccountsBean(AccountBean AccountsBean) {
		return dao2.updateAccountsBean(AccountsBean);
	}
}
