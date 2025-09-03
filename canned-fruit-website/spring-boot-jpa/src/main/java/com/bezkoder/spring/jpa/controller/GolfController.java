package com.bezkoder.spring.jpa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/golf")
public class GolfController {

	@GetMapping(value="/listOddNbrsSq/{highestNbr}") //, produces="application/text") causes 500 response
	ResponseEntity<List<Integer>> getOddSq(@PathVariable("highestNbr") int highestNbr) {
        Collection<Integer> nbrs = IntStream.rangeClosed(0, highestNbr).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<Integer> mutableOddNbrs = nbrs.stream().filter(x -> x%2==1).map(x -> x*x).collect(Collectors.toCollection(ArrayList::new));
	    int sum = mutableOddNbrs.stream().reduce(0, (a,b) -> a+b);
        //List<Integer> mutableOddNbrs = oddNbrs.stream().collect(Collectors.toCollection(ArrayList::new));
        //List<Integer> mutableOddNbrs = new ArrayList<Integer>(oddNbrs);
        mutableOddNbrs.add(Integer.valueOf(sum)); //////
        if (mutableOddNbrs != null) {
        	return new ResponseEntity(mutableOddNbrs, HttpStatus.OK);
        } else {
        	return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
	}

	/*
	 * private int[] firstNbrs(int highestNbr) { int[] nbrs = new int[highestNbr];
	 * for (int i=0; i < nbrs.length; i++) { nbrs[i] = i+1; } return nbrs; }
	 */

}
