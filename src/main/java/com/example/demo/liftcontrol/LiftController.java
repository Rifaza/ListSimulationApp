package com.example.demo.liftcontrol;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiftController {
@Autowired
private LiftService liftService;

@RequestMapping("/smartkent/liftsimulation")
public int pickAndDrop( @RequestParam("fromFloor")  int fromFloor,@RequestParam("toFloor") int toFloor ){
	return liftService.pickAndDrop(fromFloor, toFloor);
}

}
