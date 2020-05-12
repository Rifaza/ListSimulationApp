package com.example.demo.liftcontrol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import java.lang.*;


@Service
public class LiftService {
	
	private List<Lift> lifts = new ArrayList(Arrays.asList(
			new Lift(1,"IDLE","NAN","0",1),
			new Lift(2,"IDLE","UP","0",5)
			));
	   int estimateTime=0;
	   String currentState;
	   int currentFloor;
	   int currentPerson;
	   int currentId;
	   int minEstimateTime;
	 
	

	public int pickAndDrop(int fromFloor, int toFloor) {
		 ArrayList<EstimateTime> eTime=new ArrayList<EstimateTime>(); 
		 for(Lift lift:lifts){  
	    	 currentState=lift.getState();
			 currentFloor=lift.getFloor();
			 if(currentState=="IDLE") {
				 
				 if(currentFloor==fromFloor) {
		    			estimateTime=0;
		    			EstimateTime t1=new EstimateTime(lift.getLiftId(),estimateTime);
		    			eTime.add(t1);
		    			
		    	}
				 else if(currentFloor!=fromFloor)
		    		{
		    			estimateTime=Math.abs((fromFloor-currentFloor)*3);
		    			EstimateTime t2=new EstimateTime(lift.getLiftId(),estimateTime);
		    			eTime.add(t2);
		    		}
			 }
			 else if(currentState=="DROPOFF") {
		    		estimateTime=Math.abs(4+((currentFloor-fromFloor-1)*3));
		    		EstimateTime t3=new EstimateTime(lift.getLiftId(),estimateTime);
	    			eTime.add(t3);
		    	}
			 }
		 EstimateTime t4 = new EstimateTime(0,0);
			
		    for (int tm=0 ; tm<eTime.size();tm++) {
		    	   minEstimateTime=eTime.get(tm).getEstimateTime();
			    	System.out.println("Estimated time for lift :- liftId : " + eTime.get(tm).getLiftId() + " , EstimateTime: "+ eTime.get(tm).getEstimateTime());
			    	if(minEstimateTime > eTime.get(tm).getEstimateTime()) {
			    		minEstimateTime= eTime.get(tm).getEstimateTime();
			    		 currentId=eTime.get(tm).getLiftId();
			    		t4.setEstimateTime(minEstimateTime);
			    		t4.setLiftId(currentId);
			    		System.out.println("liftId : " + currentId + ", min Time :" + minEstimateTime);
			    	}
		    	
		    }

		    printState(fromFloor,toFloor,t4);
		    return minEstimateTime;

			
	
	
	}
    public void printState(int fromFloor, int toFloor, EstimateTime t4) {
    	
        for(Lift lift:lifts){  
	    	 currentState=lift.getState();
			 currentFloor=lift.getFloor();
			 System.out.println("  initial detail of lift  { liftid : "+lift.getLiftId() +" , state: "+lift.getState() + " , direction : " +lift.getDirection() + " , person: "+ lift.getPerson() + " , floor: " +lift.getFloor() );

	    	if(currentState=="IDLE") {
	    		if(currentFloor==fromFloor) {

	    			 lift.setState("PICKUP");
	    			 lift.setPerson("1");
					 lift.setFloor(currentFloor);
					 System.out.println(" { liftid : "+lift.getLiftId() +" , state: "+lift.getState() + " , direction : " +lift.getDirection() + " , person: "+ lift.getPerson() + " , floor: " +lift.getFloor() );

	    		}else if(currentFloor!=fromFloor)
	    		{
	    			 while(currentFloor<fromFloor-1) {
	    					
	    				 if(fromFloor<toFloor) {
	    					 lift.setDirection("UP");
	    				 }else {
	    					 lift.setDirection("DOWN");
	    				 }
	    				 lift.setState("TO_PICKUP");
	    				 lift.setFloor(currentFloor+1);
	    				 System.out.println(" { liftid : "+lift.getLiftId() +" , state: "+lift.getState() + " , direction : " +lift.getDirection() + " , person: "+ lift.getPerson() + " , floor: " +lift.getFloor() );

	    			     currentFloor++;
	    			 }
	    		}
	    		
	    	}
			 else if(currentState=="TO_PICKUP") {
				 while(currentFloor<=fromFloor) {
					 if(fromFloor<toFloor) {
						 lift.setDirection("UP");
					 }else {
						 lift.setDirection("DOWN");
					 }
					 lift.setFloor(currentFloor+1);
					 if(currentFloor==fromFloor) {
						 lift.setState("PICKUP");
						 currentPerson=Integer.parseInt(lift.getPerson())+1;  
						 lift.setPerson(Integer.toString(currentPerson));
					 }
					 System.out.println(" { liftid : "+lift.getLiftId() +" , state: "+lift.getState() + " , direction : " +lift.getDirection() + " , person: "+ lift.getPerson() + " , floor: " +lift.getFloor() );

				     currentFloor++;
				 }
			 }else if(currentState=="PICKUP") {
				 while(currentFloor<=toFloor) {
					 
					 if(fromFloor<toFloor) {
						 lift.setDirection("UP");
					 }else {
						 lift.setDirection("DOWN");
					 }
						
					 lift.setState("TO_DROPOFF ");
					 lift.setFloor(currentFloor+1);
					 if(currentFloor==toFloor) {
						 lift.setState("DROPOFF");
						 currentPerson=0;  
						 lift.setPerson(Integer.toString(currentPerson));
					 }
					 System.out.println(" { liftid : "+lift.getLiftId() +" , state: "+lift.getState() + " , direction : " +lift.getDirection() + " , person: "+ lift.getPerson() + " , floor: " +lift.getFloor() );

				     currentFloor++;
				 }
				 
			 }
	    	else if(currentState=="DROPOFF") {
 		         lift.setState("IDLE");
 		        lift.setFloor(currentFloor);
 		        lift.setPerson("0");
 		       lift.setDirection("NAN");
 		       System.out.println(" { liftid : "+lift.getLiftId() +" , state: "+lift.getState() + " , direction : " +lift.getDirection() + " , person: "+ lift.getPerson() + " , floor: " +lift.getFloor() );

	    	}
	    	
	    	 
	    	

	    }  
	    
	   
	
  }	
}
