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
	public String toString() {
		return "UserRole [roleID=" + roleID + ", role=" + role + "]";
	}	
		
	
}
