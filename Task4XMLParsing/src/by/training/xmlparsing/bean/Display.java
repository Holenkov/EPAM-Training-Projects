package by.training.xmlparsing.bean;

public class Display extends Device{
	protected int resolutionX;
	protected int resolutionY;
	
	public int getResolutionX() {
		return resolutionX;
	}

	public void setResolutionX(int resolutionX) {
		this.resolutionX = resolutionX;
	}

	public int getResolutionY() {
		return resolutionY;
	}

	public void setResolutionY(int resolutionY) {
		this.resolutionY = resolutionY;
	}

	@Override
	public String toString() {
		return "Display [resolutionX=" + resolutionX + ", resolutionY=" + resolutionY + ", name=" + name + ", origin="
				+ origin + ", dateOfIssue=" + dateOfIssue + ", price=" + price + ", types=" + types + ", critical="
				+ critical + "]";
	}
	
	

}
