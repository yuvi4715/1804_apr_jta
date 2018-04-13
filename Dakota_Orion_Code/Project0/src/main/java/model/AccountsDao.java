package model;

import java.util.List;

public interface AccountsDao {
	public boolean insertAccountsBean(AccountBean AccountsBean);
	public AccountBean getAccountsBean(int id);
	public List<AccountBean> getAllAccountsBeans();
	public boolean updateAccountsBean(AccountBean AccountsBean);
	public boolean deleteAccountsBean(int a);
	public int getMaxAccountsBeanId();
	public boolean createUserAccountRelationship(int UserId, int AccountId);
}
