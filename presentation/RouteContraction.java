package presentation;

import java.util.Date;

public class RouteContraction {
	
	private Route r;
	private Group g;
	private Date d;
	
	public RouteContraction(Route r, Group g, java.util.Date d2) {
		this.r = r;
		this.g = g;
		this.d = (Date) d2;
	}

	public Route getR() {
		return this.r;
	}

	public void setR(Route r) {
		this.r = r;
	}

	public Group getG() {
		return this.g;
	}

	public void setG(Group g) {
		this.g = g;
	}

	public Date getD() {
		return this.d;
	}

	public void setD(Date d) {
		this.d = d;
	}
	
	

}
