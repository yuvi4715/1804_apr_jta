package com.revature.bankUtil;

import java.sql.SQLException;

@FunctionalInterface
public interface errorMessage {
	public void printallerrors(SQLException e);

}
