package by.training.xmlparsing.bean;

public class Display extends Device{
	int resolutionX;
	int resolutionY;
	
	public Display() {
	}

	public Display(int resolutionX, int resolutionY) {
		super();
		this.resolutionX = resolutionX;
		this.resolutionY = resolutionY;
	}

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
	

}
