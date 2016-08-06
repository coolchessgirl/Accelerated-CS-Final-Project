
public class Cube {
	
	private String topColor;
	private String bottomColor;
	private String rightColor;
	private String leftColor; 
	private String frontColor;
	private String backColor;
	
	public String getTopColor() {
		return topColor;
	}
	public void setTopColor(String topColor) {
		this.topColor = topColor;
	}
	public String getBottomColor() {
		return bottomColor;
	}
	public void setBottomColor(String bottomColor) {
		this.bottomColor = bottomColor;
	}
	public String getRightColor() {
		return rightColor;
	}
	public void setRightColor(String rightColor) {
		this.rightColor = rightColor;
	}
	public String getLeftColor() {
		return leftColor;
	}
	public void setLeftColor(String leftColor) {
		this.leftColor = leftColor;
	}
	public String getFrontColor() {
		return frontColor;
	}
	public void setFrontColor(String frontColor) {
		this.frontColor = frontColor;
	}
	public String getBackColor() {
		return backColor;
	}
	public void setBackColor(String backColor) {
		this.backColor = backColor;
	}
	

	
	public Cube (String front, String right, String back, String left, String top, String bottom){
		
		topColor = top; 
		bottomColor = bottom;
		leftColor = left;
		rightColor = right;
		frontColor = front;
		backColor = back;
		
	}
	
	public void turnLeft (){
		String temp = getFrontColor();
		setFrontColor(rightColor);
		setRightColor(backColor);
		setBackColor(leftColor);
		setLeftColor(temp);
				
	}
	
	
	
	public void flip90() {
		String temp = getTopColor();
		setTopColor(rightColor);
		setRightColor(bottomColor); 
		setBottomColor(leftColor);
		setLeftColor (temp);
	}
			

	
	
	public void flip180() {
		flip90();
		flip90();
		
	}
	
	public void tilt90(){
		String temp = getBottomColor();
		setLeftColor(topColor);
		setTopColor(rightColor); 
		setRightColor(temp);
		
		
	}
	
	
}
