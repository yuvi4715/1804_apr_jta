package myBankModel;

import java.io.Serializable;

	public class Bank implements Serializable {
		
		private static final long serialVersionUID = 9047845691562510998L;
		
		private String firstName;
		private String lastName;
		private String userName;
		private String password;
		private String privilege;
		private String isApproved;
		private int checkingBalance;
		private int savingBalance;
		
		
		public Bank() {
			
		}


		public Bank(String firstName, String lastName, String username, String password, String privilege, String isApproved,
				int checkingBalance, int savingBalance) {
			super();
			this.privilege = privilege;
			this.setIsApproved(isApproved); // this value has the possibility of being null for admins
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = username;
			this.password = password;
			this.checkingBalance = checkingBalance;
			this.savingBalance = savingBalance;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getIsApproved() {
			if(isApproved == null) {
				this.isApproved = "true";
			}
			return this.isApproved;
		}


		public void setIsApproved(String isApproved) {
			if(isApproved == null) {
				this.isApproved = "N/A";
			}
			this.isApproved = isApproved;
		}


		public int getCheckingBalance() {
			return checkingBalance;
		}


		public void setCheckingBalance(int checkingBalance) {
			this.checkingBalance = checkingBalance;
		}


		public int getSavingBalance() {
			return savingBalance;
		}


		public void setSavingBalance(int savingBalance) {
			this.savingBalance = savingBalance;
		}
		
		


		public String getPrivilege() {
			return privilege;
		}


		public void setPrivilege(String privilege) {
			this.privilege = privilege;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + checkingBalance;
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((isApproved == null) ? 0 : isApproved.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((privilege == null) ? 0 : privilege.hashCode());
			result = prime * result + savingBalance;
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Bank other = (Bank) obj;
			if (checkingBalance != other.checkingBalance)
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (isApproved == null) {
				if (other.isApproved != null)
					return false;
			} else if (!isApproved.equals(other.isApproved))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (privilege == null) {
				if (other.privilege != null)
					return false;
			} else if (!privilege.equals(other.privilege))
				return false;
			if (savingBalance != other.savingBalance)
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Bank [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
					+ "*******" + ", privilege=" + privilege + ", isApproved=" + isApproved + ", checkingBalance="
					+ checkingBalance + ", savingBalance=" + savingBalance + "]";
		}



		


		
	}


