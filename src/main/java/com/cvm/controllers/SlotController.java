package com.cvm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cvm.entities.Slot;
import com.cvm.exceptions.NoSlotsFoundException;
import com.cvm.exceptions.SlotIdNotFoundException;
import com.cvm.services.SlotService;


@RestController
public class SlotController {
	@Autowired
	SlotService ss;

//	@PostMapping("/slots")
//	public ResponseEntity<String> addSlot(@Valid @RequestBody Slot slots) {
//		String msg = ss.insertSlot(slots);
//		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
//		return rEntity;
//	}

//	@GetMapping("/slots")
//	public List<Slot> fetchAllSlots() throws NoSlotsFoundException {
//		return ss.findAll();
//	}

	@GetMapping("/slots/{slotId}")
	public ResponseEntity<Slot> fetchSlotById(@PathVariable("slotId") long slotId) throws SlotIdNotFoundException {
		Slot msg = ss.findBySlotId(slotId);
		ResponseEntity<Slot> rEntity = new ResponseEntity<Slot>(msg, HttpStatus.FOUND);
		return rEntity;
	}
	

	@GetMapping("/slots/byLocation/{slotLocation}")
	public ResponseEntity<Slot> findSlotBySlotLocation(@PathVariable("slotLocation") String sLocation)
			throws SlotIdNotFoundException {
		Slot msg = ss.findSlotBySlotLocation(sLocation);
		ResponseEntity<Slot> rEntity = new ResponseEntity<Slot>(msg, HttpStatus.FOUND);
		return rEntity;
	}

	@PutMapping("/slots/{slotId}")
	public String modifySlot(@PathVariable("slotId") long slotId, @Valid @RequestBody Slot slots)
			throws SlotIdNotFoundException {
		return ss.updateSlot(slotId, slots);
	}

	@DeleteMapping("/slots/{slotId}")
	public ResponseEntity<String> deleteSlotById(@PathVariable("slotId") long slotId) throws SlotIdNotFoundException {
		String msg = ss.deleteById(slotId);
		ResponseEntity<String> rEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return rEntity;
	}
	
	

}
