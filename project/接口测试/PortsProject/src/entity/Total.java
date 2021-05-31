package entity;

public class Total {
	private int t_id;
	private int sum;
	private String success;
	private String fail;
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getFail() {
		return fail;
	}
	public void setFail(String fail) {
		this.fail = fail;
	}
	@Override
	public String toString() {
		return "Total [t_id=" + t_id + ", sum=" + sum + ", success=" + success + ", fail=" + fail + "]";
	}
	
	
	

}
