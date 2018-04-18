package com.revature.projectzero.main;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.projectzero.accounts.Account;
import com.revature.projectzero.accounts.AccountTypes;
import com.revature.projectzero.accounts.Transaction;
import com.revature.projectzero.accounts.User;
import com.revature.projectzero.service.BankService;

public class UserLoggedInLoopBehavior implements StateBehavior {
	final static Logger log = Logger.getLogger(UserLoggedInLoopBehavior.class);
	private StateBehavior createAccountBehavior = null;

	public UserLoggedInLoopBehavior(StateBehavior createAccountBehavior) {
		super();
		this.createAccountBehavior = createAccountBehavior;
	}

	public static void getUserAccounts(int page) {
		BankService.getUserAccounts(Program.getU(), page);
	}

	@Override
	public void execute(PrintStream out) {
		log.debug("userLoggedInLoop");
		out.println("Welcome " + Program.getU().getName());
		if (Program.getU().isAdmin()) {
			out.println("enter \"activateAccounts(aa)\" to activate user accounts");
			out.println("enter \"deleteuseraccount(dua)\" to delete user accounts");
			out.println("enter \"updateuseraccount(uua)\" to update user accounts");
			out.println("enter \"createuseraccount(cua)\" to create user accounts");
		}
		out.println("enter \"viewaccounts(va)\" to view bankaccounts");
		out.println("enter \"deposit(d)\" to deposit money on a given account");
		out.println("enter \"withdraw(w)\" to withdraw from a given account");
		out.println("enter \"createbankaccount(cba)\" to create bank accounts");
		out.println("enter \"deletebankaccount(dba)\" to delete bank accounts");
		out.println("enter \"viewtransactions(vt)\" to view transactions");
		out.println("enter \"quit(q)\" to go back to the main menu\n");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if ((input.equalsIgnoreCase("createuseraccount") || input.equalsIgnoreCase("cua"))
				&& Program.getU().isAdmin()) {
			if(createAccountBehavior!=null)
				createAccountBehavior.execute(out);
			else {
				out.println("You can't create accounts!");
				log.error("Null pointer Exception");
			}
			Program.setState(ProgramState.userLoggedInLoop);
				
		} else if ((input.equalsIgnoreCase("updateuseraccount") || input.equalsIgnoreCase("uua"))
				&& Program.getU().isAdmin()) {
			int page = 0;
			do {
				List<User> list = BankService.getAllUsers(page);
				out.println("The following accounts can be Updated.");
				try {
					for (int i = 0; i < list.size(); i++) {
						out.println(i + ") " + list.get(i));
					}
				} catch (NullPointerException e) {
					log.error("Null pointer exception inside of userLoggedInLoop");
				}
				out.println("Enter the number of account to delete or conversely enter quit(q)");
				out.println("You can view more accounts by typing \"nextpage(np)\" \"previouspage(pp)\"");
				input = in.nextLine();
				if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
					break;
				else if (input.equalsIgnoreCase("previouspage") || input.equalsIgnoreCase("pp")) {
					page = page == 0 ? 0 : page - 1;
					continue;
				} else if (input.equalsIgnoreCase("nextPage") || input.equalsIgnoreCase("np")) {
					page++;
					continue;
				}
				try {
					int accountIndex = Integer.parseInt(input);
					if (list == null || list.size() == 0) {
						out.println("No accounts to select");
						continue;
					}
					if (accountIndex > list.size() || accountIndex < 0) {
						out.println("Number not in range");
						continue;
					}
					out.println("Please enter the type of account you wish to update this user");
					out.println("enter \"useraccount(ua)\" to create a user account");
					out.println("enter \"adminaccount(aa)\" to create a admin account");
					input = in.nextLine();
					boolean isAdmin = false;
					if (input.equalsIgnoreCase("useraccount") || input.equalsIgnoreCase("ua")) {
						isAdmin = false;
					} else if (input.equalsIgnoreCase("adminaccount") || input.equalsIgnoreCase("aa")) {
						isAdmin = true;
					} else {
						out.println("Input not understood");
						continue;
					}
					out.println("Enter New Updated Fields");
					out.println("Name:");
					String name = in.nextLine();
					out.println("Last Name:");
					String lname = in.nextLine();
					out.println("Password:");
					String password = in.nextLine();
					User tempU = list.get(accountIndex);
					tempU.setName(name);
					tempU.setLname(lname);
					tempU.setAdmin(isAdmin);
					BankService.update(tempU, password);
					break;
				} catch (NumberFormatException e) {
					log.error("ClassCastException pointer exception inside of userLoggedInLoop");
					out.println("Not a number entered");
				} catch (NullPointerException e) {
					log.error("Null pointer exception inside of userLoggedInLoop");
				}
			} while (true);
		} else if ((input.equalsIgnoreCase("deleteuseraccount") || input.equalsIgnoreCase("dua"))
				&& Program.getU().isAdmin()) {
			int page = 0;
			do {
				List<User> list = BankService.getAllUsers(page);
				try {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getUsername().equals(Program.getU().getUsername())) {
							list.remove(i);
							break;
						}
					}
				} catch (NullPointerException e) {
					log.error("Null pointer exception inside of userLoggedInLoop");
				}
				out.println("The following accounts can be deleted.");
				try {
					for (int i = 0; i < list.size(); i++) {
						out.println(i + ") " + list.get(i));
					}
				} catch (NullPointerException e) {
					log.error("Null pointer exception inside of userLoggedInLoop");
				}
				out.println("Enter the number of account to delete or conversely enter quit(q)");
				out.println("You can view more accounts by typing \"nextpage(np)\" \"previouspage(pp)\"");
				input = in.nextLine();
				if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
					break;
				else if (input.equalsIgnoreCase("previouspage") || input.equalsIgnoreCase("pp")) {
					page = page == 0 ? 0 : page - 1;
					continue;
				} else if (input.equalsIgnoreCase("nextPage") || input.equalsIgnoreCase("np")) {
					page++;
					continue;
				}
				try {
					int accountIndex = Integer.parseInt(input);
					if (list == null || list.size() == 0) {
						out.println("No accounts to select");
						continue;
					}
					if (accountIndex > list.size() || accountIndex < 0) {
						out.println("Number not in range");
						continue;
					}
					out.println("Are you sure (y/n) or conversely enter \"quit(q)\"");
					input = in.nextLine();
					if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
						continue;
					if (input.equalsIgnoreCase("y")) {
						list.get(accountIndex).setDeleted(true);
						out.println("Updating  account");
						BankService.update(list.get(accountIndex));
					}
				} catch (NumberFormatException e) {
					log.error("ClassCastException pointer exception inside of userLoggedInLoop");
					out.println("Not a number entered");
				} catch (NullPointerException e) {
					log.error("Null pointer exception inside of userLoggedInLoop");
				}
			} while (true);
		} else if ((input.equalsIgnoreCase("activateAccounts") || input.equalsIgnoreCase("aa"))
				&& Program.getU().isAdmin()) {
			int page = 0;
			do {
				List<User> list = BankService.getUnActivatedAccounts(page);

				out.println("The following Accounts need activation");
				try {
					for (int i = 0; i < list.size(); i++) {
						out.println(i + ") " + list.get(i));
					}
				} catch (NullPointerException e) {
					log.error("Null pointer exception inside of userLoggedInLoop");
				}
				out.println("Enter the number of account to activate or conversely enter quit(q)");
				out.println("You can view more accounts by typing \"nextpage(np)\" \"previouspage(pp)\"");
				input = in.nextLine();
				if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
					break;
				else if (input.equalsIgnoreCase("previouspage") || input.equalsIgnoreCase("pp")) {
					page = page == 0 ? 0 : page - 1;
					continue;
				} else if (input.equalsIgnoreCase("nextPage") || input.equalsIgnoreCase("np")) {
					page++;
					continue;
				}
				try {
					int accountIndex = Integer.parseInt(input);
					if (list == null || list.size() == 0) {
						out.println("No accounts to select");
						continue;
					}
					if (accountIndex > list.size() || accountIndex < 0) {
						out.println("Number not in range");
						continue;
					}
					list.get(accountIndex).setActive(true);
					out.println("Updating ac count");
					BankService.update(list.get(accountIndex));
				} catch (NumberFormatException e) {
					log.error("ClassCastException pointer exception inside of userLoggedInLoop");
					out.println("Not a number entered");
				} catch (NullPointerException e) {
					log.error("Null pointer exception inside of userLoggedInLoop");
				}
			} while (true);
		} else if (input.equalsIgnoreCase("viewtransactions") || input.equalsIgnoreCase("vt")) {
			int page = 0;
			do {
				try {
					getUserAccounts(page);
					out.println("You have the following accounts:");
					for (int i = 0; i < Program.getU().getAccounts().size(); i++) {
						Account account = Program.getU().getAccounts().get(i);
						out.println(i + ") " + account);
					}
					out.println(
							"Enter the account index number to view the transaction history or conversely enter \"quit(q)\"");
					out.println("You can view more accounts by typing \"nextpage(np)\" \"previouspage(pp)\"");
					input = in.nextLine();
					if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
						break;
					else if (input.equalsIgnoreCase("previouspage") || input.equalsIgnoreCase("pp")) {
						page = page == 0 ? 0 : page - 1;
						continue;
					} else if (input.equalsIgnoreCase("nextPage") || input.equalsIgnoreCase("np")) {
						page++;
						continue;
					}
					try {
						int accountIndex = Integer.parseInt(input);
						if (Program.getU().getAccounts() == null || Program.getU().getAccounts().size() == 0) {
							out.println("No accounts to select");
							continue;
						}
						if (accountIndex > Program.getU().getAccounts().size() || accountIndex < 0) {
							out.println("Number not in range");
							continue;
						}
						int transPage = 0;
						do {
							Account a = Program.getU().getAccounts().get(accountIndex);
							BankService.getAccountTransactions(a, transPage);
							out.println("You have the following accounts:");
							for (int i = 0; i < a.getTran().size(); i++) {
								Transaction trans = a.getTran().get(i);
								out.println(i + ") " + trans);
							}
							out.println("Press \"quit(q)\" to quit");
							out.println("You can view more accounts by typing \"nextpage(np)\" \"previouspage(pp)\"");

							input = in.nextLine();
							if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
								break;
							if (input.equalsIgnoreCase("previouspage") || input.equalsIgnoreCase("pp")) {
								transPage = transPage == 0 ? 0 : transPage - 1;
								continue;
							} else if (input.equalsIgnoreCase("nextPage") || input.equalsIgnoreCase("np")) {
								transPage++;
								continue;
							}
						} while (true);
					} catch (NumberFormatException e) {
						log.error("ClassCastException pointer exception inside of userLoggedInLoop");
						out.println("Not a number entered");
					} catch (NullPointerException e) {
						log.error("Null pointer exception inside of userLoggedInLoop");
					}
				} catch (NullPointerException e) {
					log.error("Null pointer exception inside of userLoggedInLoop");
				}

			} while (true);
		} else if (input.equalsIgnoreCase("deposit") || input.equalsIgnoreCase("withdraw")
				|| input.equalsIgnoreCase("w") || input.equalsIgnoreCase("d")) {
			int transactionSign = 1;
			if (input.equalsIgnoreCase("withdraw") || input.equalsIgnoreCase("w"))
				transactionSign = -1;
			int page = 0;
			do {
				try {
					getUserAccounts(page);
					out.println("You have the following accounts:");
					for (int i = 0; i < Program.getU().getAccounts().size(); i++) {
						Account account = Program.getU().getAccounts().get(i);
						out.println(i + ") " + account);
					}
					out.println("Enter the account index number or conversely enter \"quit(q)\"");
					out.println("You can view more accounts by typing \"nextpage(np)\" \"previouspage(pp)\"");
					input = in.nextLine();
					if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
						break;
					else if (input.equalsIgnoreCase("previouspage") || input.equalsIgnoreCase("pp")) {
						page = page == 0 ? 0 : page - 1;
						continue;
					} else if (input.equalsIgnoreCase("nextPage") || input.equalsIgnoreCase("np")) {
						page++;
						continue;
					}
					try {
						int accountIndex = Integer.parseInt(input);
						if (Program.getU().getAccounts() == null || Program.getU().getAccounts().size() == 0) {
							out.println("No accounts to select");
							continue;
						}
						if (accountIndex > Program.getU().getAccounts().size() || accountIndex < 0) {
							out.println("Number not in range");
							continue;
						}
						Account a = Program.getU().getAccounts().get(accountIndex);
						out.println("Enter the amount or conversely enter \"quit(q)\"");
						input = in.nextLine();
						if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
							continue;
						try {
							double amount = Double.parseDouble(input);
							a.setBalance(a.getBalance() + (transactionSign * amount));
							BankService.update(a);
							BankService.create(new Transaction(0, a.getId(), amount, transactionSign > 0, false, null));
						} catch (NumberFormatException e) {
							log.error("ClassCastException pointer exception inside of userLoggedInLoop");
							out.println("Not a number entered");
						} catch (NullPointerException e) {
							log.error("Null pointer exception inside of userLoggedInLoop");
						}
					} catch (NumberFormatException e) {
						log.error("ClassCastException pointer exception inside of userLoggedInLoop");
						out.println("Not a number entered");
					} catch (NullPointerException e) {
						log.error("Null pointer exception inside of userLoggedInLoop");
					}
				} catch (NullPointerException e) {
					log.error("Null pointer exception inside of userLoggedInLoop");
				}

			} while (true);
		} else if (input.equalsIgnoreCase("createbankaccount") || input.equalsIgnoreCase("cba")) {
			List<AccountTypes> list = Arrays.asList(AccountTypes.values());
			do {
				out.println("Please enter the account type or conversely enter \"quit(q)\" to return");
				for (AccountTypes a : list) {
					out.print(a + ",");
				}
				out.println();
				input = in.nextLine();
				if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
					break;
				try {
					AccountTypes type = AccountTypes.valueOf(input);
					if (!list.contains(type)) {
						out.println("Invalid Account Type");
						continue;
					}
					out.println("Valid Account Type");
					out.println("Please Enter Balance for the account or conversely enter \"quit(q)\" to return");
					input = in.nextLine();
					if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
						continue;
					try {
						double amount = Double.parseDouble(input);
						Account a = new Account(amount, 0L, Program.getU(), type, false);
						BankService.create(a);
						out.println("Account Creation Succesful");
						out.println(a);
						break;
					} catch (NumberFormatException e) {
						log.error(e.getMessage());
						out.println("You did not enter a number.");
					}
				} catch (IllegalArgumentException e) {
					log.error(e.getMessage());
				}
			} while (true);
		} else if (input.equalsIgnoreCase("deletebankaccount") || input.equalsIgnoreCase("dba")) {
			int page = 0;
			do {
				try {
					getUserAccounts(page);
					out.println("You have the following accounts:");
					for (int i = 0; i < Program.getU().getAccounts().size(); i++) {
						Account account = Program.getU().getAccounts().get(i);
						out.println(i + ") " + account);
					}
					out.println("Enter the account index number or conversely enter \"quit(q)\"");
					out.println("You can view more accounts by typing \"nextpage(np)\" \"previouspage(pp)\"");
					input = in.nextLine();
					if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
						break;
					else if (input.equalsIgnoreCase("previouspage") || input.equalsIgnoreCase("pp")) {
						page = page == 0 ? 0 : page - 1;
						continue;
					} else if (input.equalsIgnoreCase("nextPage") || input.equalsIgnoreCase("np")) {
						page++;
						continue;
					}
					try {
						int accountIndex = Integer.parseInt(input);
						if (Program.getU().getAccounts() == null || Program.getU().getAccounts().size() == 0) {
							out.println("No accounts to select");
							continue;
						}
						if (accountIndex > Program.getU().getAccounts().size() || accountIndex < 0) {
							out.println("Number not in range");
							continue;
						}
						Account a = Program.getU().getAccounts().get(accountIndex);
						if (a.getBalance() > 0) {
							out.println("Cannot delete an account with a positive balance");
							continue;

						} else
							out.println("Are you sure (y/n) or conversely enter \"quit(q)\"");
						input = in.nextLine();
						if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
							continue;
						if (input.equalsIgnoreCase("y")) {
							Program.getU().getAccounts().remove(a);
							BankService.delete(a);
						}

					} catch (NumberFormatException e) {
						log.error(e.getMessage());
					}
				} catch (NullPointerException e) {
					log.error(e.getMessage());
				}
			} while (true);
		} else if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {
			Program.setU(null);
			Program.setState(ProgramState.mainLoop);
		}
	}

}
