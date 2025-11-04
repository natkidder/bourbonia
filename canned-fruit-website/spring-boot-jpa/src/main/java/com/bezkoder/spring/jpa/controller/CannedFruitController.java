package com.bezkoder.spring.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.model.CannedFruit;
import com.bezkoder.spring.jpa.model.CannedFruitNoOrders;
import com.bezkoder.spring.jpa.model.Fruit;
import com.bezkoder.spring.jpa.repository.CannedFruitNoOrderRepository;
import com.bezkoder.spring.jpa.repository.CannedFruitRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api2")
public class CannedFruitController {

	@Autowired
	CannedFruitRepository cannedFruitRepository;
	
	@Autowired
	CannedFruitNoOrderRepository cannedFruitNoOrderRepository;

	@GetMapping("/cannedFruit")
	public ResponseEntity<List<CannedFruit>> getAllCannedFruits(@RequestParam(required = false) String fruit) {
		try {
			List<CannedFruit> cannedFruits = new ArrayList<CannedFruit>();

			if (fruit == null)
				cannedFruitRepository.findAll(Sort.by(Sort.Direction.ASC, "fruit").and(Sort.by(Sort.Direction.ASC, "unitType"))).forEach(cannedFruits::add);
			else
				cannedFruitRepository.findByFruitContainingIgnoreCase(fruit).forEach(cannedFruits::add);
			System.out.println(this.getClass().getCanonicalName()+" 10:"+ cannedFruits.size()); ////////

			if (cannedFruits.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			//CannedFruitCollection cannedFruitCollection = new CannedFruitCollection(cannedFruits);
			return new ResponseEntity<>(cannedFruits, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/cannedFruitNoOrders")
	public ResponseEntity<List<CannedFruitNoOrders>> getCannedFruitsNoOrder(@RequestParam(required = false) String fruit) {
		try {
			List<CannedFruitNoOrders> cannedFruitsNoOrders = new ArrayList<CannedFruitNoOrders>();

			if (fruit == null)
				cannedFruitNoOrderRepository.findAll(Sort.by(Sort.Direction.ASC, "fruit").and(Sort.by(Sort.Direction.ASC, "unitType"))).forEach(cannedFruitsNoOrders::add);
			else
				cannedFruitNoOrderRepository.findByFruitContainingIgnoreCase(fruit).forEach(cannedFruitsNoOrders::add);
			System.out.println(this.getClass().getCanonicalName()+" 10:"+ cannedFruitsNoOrders.size()); ////////

			if (cannedFruitsNoOrders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			//CannedFruitCollection cannedFruitCollection = new CannedFruitCollection(cannedFruits);
			return new ResponseEntity<>(cannedFruitsNoOrders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/cannedFruit/{id}")
	public ResponseEntity<CannedFruit> getCannedFruitById(@PathVariable("id") long id) {
		Optional<CannedFruit> cannedFruitData = cannedFruitRepository.findById(id);
		//CannedFruit cannedFruitData = cannedFruitRepository.findById(id).get();

		if (cannedFruitData.isPresent()) {
			return new ResponseEntity<>(cannedFruitData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/cannedFruitIdCollection")
	public ResponseEntity<List<CannedFruit>> getCannedFruitByIds(@RequestParam(value = "id") List<Long> ids) {
		try {
			List<CannedFruit> cannedFruits = new ArrayList<CannedFruit>();
			cannedFruitRepository.findByIdIn(ids).forEach(cannedFruits::add);
			//CannedFruit cannedFruitData = cannedFruitRepository.findById(id).get();
			if (cannedFruits.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(cannedFruits, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/cannedFruit")
	public ResponseEntity<CannedFruit> createCannedFruit(@RequestBody CannedFruit cannedFruit) {
		try {
			System.out.println(this.getClass().getCanonicalName()+"createCannedFruit 10: "+cannedFruit.getMedium().getMediumName()); ///////////
			CannedFruit _cannedFruit = cannedFruitRepository.save(new CannedFruit(cannedFruit.getFruit(), cannedFruit.getMedium(), cannedFruit.getUnitType(), cannedFruit.getVolume(), cannedFruit.getContainer(), cannedFruit.getPricePer()));
			System.out.println(this.getClass().getCanonicalName()+"createCannedFruit 20: "+_cannedFruit.getMedium().getMediumName());
			return new ResponseEntity<>(_cannedFruit, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/cannedFruit/{id}")
	public ResponseEntity<CannedFruit> updateCannedFruit(@PathVariable("id") long id, @RequestBody CannedFruit cannedFruit) {
		Optional<CannedFruit> cannedFruitData = cannedFruitRepository.findById(id);

		if (cannedFruitData.isPresent()) {
			CannedFruit _cannedFruit = cannedFruitData.get();
			_cannedFruit.setFruit(cannedFruit.getFruit());
			_cannedFruit.setMedium(cannedFruit.getMedium());
			_cannedFruit.setUnitType(cannedFruit.getUnitType());
			_cannedFruit.setVolume(cannedFruit.getVolume());
			_cannedFruit.setContainer(cannedFruit.getContainer());
			_cannedFruit.setPricePer(cannedFruit.getPricePer());
			return new ResponseEntity<>(cannedFruitRepository.save(_cannedFruit), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/cannedFruit/{id}")
	public ResponseEntity<HttpStatus> deleteCannedFruit(@PathVariable("id") long id) {
		try {
			cannedFruitRepository.deleteById(id);
			System.out.println("deleteById OK"); ////////
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/cannedFruit")
	public ResponseEntity<HttpStatus> deleteAllCannedFruits() {
		try {
			cannedFruitRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/distinctFruits")
	public ResponseEntity<SortedSet<String>> getDistinctFruits(@RequestParam(required = false) String fruit) {
		try {
			System.out.println("CannedFruitController.getDistinctFruits 01"); ///////
			List<CannedFruit> cannedFruits = new ArrayList<CannedFruit>();
			List<String> fruits = new ArrayList<String>();

			cannedFruitRepository.findAll(Sort.by(Sort.Direction.ASC, "fruit")).forEach(cannedFruits::add);

			if (cannedFruits.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			fruits = cannedFruits.stream().map(CannedFruit::getFruit).collect(Collectors.toList());
			SortedSet<String> distinctFruits = new TreeSet<String>(fruits);
			return new ResponseEntity<>(distinctFruits, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
