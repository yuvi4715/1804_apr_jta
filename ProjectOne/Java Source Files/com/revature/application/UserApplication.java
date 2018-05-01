package com.revature.application;

import java.util.*;

import com.revature.model.Request;
import com.revature.model.User;
import com.revature.service.UserService;

public class UserApplication {
	public static void main(String[] args) {
		User t1 = UserService.getUser("tester","trololo");
//		System.out.println(UserService. getResolvedRequests(t1.getEmail()));
		//System.out.println(UserService.isManager(t1.getEmail()));
		//System.out.println(UserService.logOn("tester", "testee"));
		
		//System.out.println(UserService.updateUser("test@gmail.com", "Jhon", "Trollston", "trololo"));
		
		// getall works
//		List<User> user = UserService.getAllUsers();
//		for (User u: user) {
//			System.out.println(u);
//		}
		
		
		// employee requests all of his/her requests done
//		List<Request> requests = UserService.getEmployeeRequests("test@gmail.com");
//		for (Request req : requests) {
//			System.out.println(req);
//		}
		
		// resolved requests work, pending requests also work. 
		List<Request> requests = UserService.getResolvedRequests("test@gmail.com");
		for (Request req : requests) {
			System.out.println(req);
		}
		
		//Getting all requests and All resolved/pending requests(managers only) works as well
//		List<Request> requests = UserService.getAllResolvedRequests();
//		for (Request req : requests) {
//			System.out.println(req);
//		}
		
		// submit request works
//		System.out.println(UserService.submitRequest("test@gmail.com", 9000, "Because its over 9000!"));
		
		//System.out.println(UserService.checkUsername("H777")); 
	}
	
}
