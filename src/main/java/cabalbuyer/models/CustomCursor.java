package cabalbuyer.models;

public class CustomCursor {
	private Integer xLocation;
	private Integer yLocation;
	
	public CustomCursor(Integer xLocation, Integer yLocation) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}
	
	public Integer getyLocation() {
		return yLocation;
	}
	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}
	public Integer getxLocation() {
		return xLocation;
	}
	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.xLocation.toString() + "-" + this.yLocation.toString();
	}
}
