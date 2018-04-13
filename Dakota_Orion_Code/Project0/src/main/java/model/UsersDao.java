package model;

import java.util.List;

import model.UsersDao;

public interface UsersDao {
	public boolean insertUsersBean(UsersBean user);
	public UsersBean getUsersBean(int id);
	public List<UsersBean> getAllUsersBean();
	public List<Integer> getUnapprovedUsers();
	public boolean updateUsersBean(UsersBean user);
	public boolean deleteUsersBean(int u);
	public int getMaxUsersBeanId();
	public List<Integer> getUserAccounts(int UserId);
}
