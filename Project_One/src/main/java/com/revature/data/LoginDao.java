package com.revature.data;

import com.revature.beans.Login;

public interface LoginDao {
	Login login(String username, String password);
}
