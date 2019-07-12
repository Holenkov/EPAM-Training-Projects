package by.training.edocuments.bean.base;

import by.training.edocuments.bean.BaseEntity;

public class UserRole extends BaseEntity{
	
	private int roleID;
	private RoleEnum role;
	
	public UserRole() {
	}

	public UserRole(int roleID, RoleEnum role) {
		super();
		this.roleID = roleID;
		this.role = role;
	}

	public UserRole(RoleEnum role) {
		super();
		this.roleID = role.ordinal()+1;
		this.role = role;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + roleID;
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
		UserRole other = (UserRole) obj;
		if (role != other.role)
			return false;
		if (roleID != other.roleID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRole [roleID=" + roleID + ", role=" + role + "]";
	}	
		
	
}
