package com.example.demo.liftcontrol;

public class Lift {
	private  int liftId;
    private String state;
    private String direction;
    private String person;
    private int floor;
    public Lift() {
  		
  	}
    public Lift(int liftId, String state, String direction, String person, int floor) {
		super();
		this.liftId = liftId;
		this.state = state;
		this.direction = direction;
		this.person = person;
		this.floor = floor;
	}
	public int getLiftId() {
		return liftId;
	}
	public void setLiftId(int liftId) {
		this.liftId = liftId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
    
}
