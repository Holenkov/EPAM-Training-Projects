package by.training.xmlparsing.bean;

public class SSD extends Store{
	protected int speed;
	

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "SSD [speed=" + speed + ", capacity=" + capacity + ", name=" + name + ", origin=" + origin
				+ ", dateOfIssue=" + dateOfIssue + ", price=" + price + ", types=" + types + ", critical=" + critical
				+ "]";
	}

	
}
