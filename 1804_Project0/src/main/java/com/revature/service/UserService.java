package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.User;

public class UserService {

		private static UserDao dao = new UserDaoImpl();
		
		public static boolean activate(String username) {
			return dao.activate(username);
		}
		
		public static boolean deactivate(String username) {
			return dao.deactivate(username);
		}
		
		public static boolean promoteAdmin(String username) {
			return dao.promoteAdmin(username);
		}
		
		public static boolean revokeAdmin(String username) {
			return dao.revokeAdmin(username);
		}
		
		public static User deposit(User user, double amount) {
			return dao.deposit(user, amount);
		}
		
		public static User withdraw(User user, double amount) {
			return dao.withdraw(user, amount);
		}
}
