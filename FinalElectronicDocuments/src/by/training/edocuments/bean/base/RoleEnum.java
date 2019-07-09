package by.training.edocuments.bean.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum RoleEnum {
	ADMIN(1, "Administrator"), 
	USER(2, "User"), 
	MANAGER(3, "Manager"),
	NO_PERMISSIONS(4, "Unregistered"); 
	
	private String name;
	private int id;
	
	
	private RoleEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public static List<RoleEnum> getRoles(){
		return new ArrayList<>(Arrays.asList(RoleEnum.values()));
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
