package by.training.edocuments.bean.base;

public enum RoleEnum {
	ADMIN("Administrator"), 
	USER("User"), 
	MANAGER("Manager"),
	NO_PERMISSIONS("Unregistered"); 
	
	private String name;
	
	
	private RoleEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public static RoleEnum getRole(int id) {
		switch (id) {
		case 1:
			return RoleEnum.ADMIN;
		case 2:
			return RoleEnum.USER;
		case 3:
			return RoleEnum.MANAGER;		
		case 4:
			return RoleEnum.NO_PERMISSIONS;
			
		default:
			throw new IllegalAccessError("Non existing role");
		}
	}

}
