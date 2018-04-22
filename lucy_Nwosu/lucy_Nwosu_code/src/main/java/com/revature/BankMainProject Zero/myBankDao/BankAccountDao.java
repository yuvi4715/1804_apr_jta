package myBankDao;

import java.util.List;
import bankModel.BankAccount;

public interface BankAccountDao {
	
			public boolean insertBankAccount(BankAccount bankAccount);	// Create
			public BankAccount getBankAccount(int accountNumber);	// Read
			public List<BankAccount> getAllBankAccount();
			public boolean updateBankAccount(BankAccount bankAccount);	// Update
			public boolean deleteBankAccount(int accountNumber);	// Delete
		}