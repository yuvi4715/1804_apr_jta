package com.revature.projectzero.main;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.projectzero.accounts.Account;
import com.revature.projectzero.accounts.AccountTypes;
import com.revature.projectzero.accounts.User;
import com.revature.projectzero.db.BankDB;
import com.revature.projectzero.db.DatabaseSingleton;
import com.revature.projectzero.db.MockDB;

public class Main {
	public static void main(String[] args) {
		Program.start();
	}
}
