package entity;

public class Message {
	private int r_id;
	private String state;
	private String information;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "Message [r_id=" + r_id + ", state=" + state + ", information=" + information + "]";
	}
	
}
