package com.bezkoder.spring.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.bezkoder.spring.jpa.model.Medium;
import com.bezkoder.spring.jpa.repository.MediumRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api2")
public class MediumController {

	@Autowired
	MediumRepository mediumRepository;

	@GetMapping("/medium")
	public synchronized ResponseEntity<List<Medium>> getAllMediums(@RequestParam(required = false) String mediumName) {
		try {
			System.out.println("getAllMediums 010"); /////////
			List<Medium> mediums = new ArrayList<Medium>();
			System.out.println("getAllMediums 020"); /////////

			if (mediumName == null) {
				Thread.sleep(1000);  // TODO remove if needed
				System.out.println("getAllMediums 030"); /////////
				mediumRepository.findAll(Sort.by(Sort.Direction.DESC, "mediumName")).forEach(mediums::add);
			} else {
				mediumRepository.findByMediumNameContainingIgnoreCase(mediumName).forEach(mediums::add);
			}
			System.out.println("getAllMediums 040"); /////////

			if (mediums.isEmpty()) {
				System.out.println("getAllMediums 045"); /////////
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			//MediumCollection mediumCollection = new MediumCollection(mediums);
			System.out.println("getAllMediums 050"); /////////
			return new ResponseEntity<>(mediums, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("getAllMediums 060"); /////////
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/medium/{id}")
	public ResponseEntity<Medium> getMediumById(@PathVariable("id") long id) {
		Optional<Medium> mediumData = mediumRepository.findById(id);

		if (mediumData.isPresent()) {
			return new ResponseEntity<>(mediumData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/* for whatever reason, the correct json format is    "[mediumName eg. water]": {}   */
	@PostMapping("/medium")
	public ResponseEntity<Medium> createMedium(@RequestBody Medium medium) {
		System.out.println("createMedium 10:"+medium.getMediumName());
		try {
			Medium _medium = mediumRepository.save(new Medium(medium.getMediumName()));
			return new ResponseEntity<>(_medium, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/medium/{id}")
	public ResponseEntity<Medium> updateMedium(@PathVariable("id") long id, @RequestBody Medium medium) {
		Optional<Medium> mediumData = mediumRepository.findById(id);

		if (mediumData.isPresent()) {
			Medium _medium = mediumData.get();
			_medium.setMediumName(medium.getMediumName());
			return new ResponseEntity<>(mediumRepository.save(_medium), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/medium/{id}")
	public ResponseEntity<HttpStatus> deleteMedium(@PathVariable("id") long id) {
		try {
			mediumRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/medium")
	public ResponseEntity<HttpStatus> deleteAllMediums() {
		try {
			mediumRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
