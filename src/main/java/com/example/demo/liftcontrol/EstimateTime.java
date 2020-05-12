package com.example.demo.liftcontrol;

public class EstimateTime {
	private  int liftId;
    private int estimateTime;
	public EstimateTime() {
	
	}
	public EstimateTime(int liftId, int estimateTime) {
		super();
		this.liftId = liftId;
		this.estimateTime = estimateTime;
	}
	public int getLiftId() {
		return liftId;
	}
	public void setLiftId(int liftId) {
		this.liftId = liftId;
	}
	public int getEstimateTime() {
		return estimateTime;
	}
	public void setEstimateTime(int estimateTime) {
		this.estimateTime = estimateTime;
	}
	
    
}
