package com.cvm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cvm.dao.SlotDao;
import com.cvm.entities.Slot;
import com.cvm.exceptions.NoSlotsFoundException;
import com.cvm.exceptions.SlotIdNotFoundException;


@Service("ss")
public class SlotService {
	@Autowired
	SlotDao sd;
	
//	public String insertSlot(Slot slots) {
//		Slot dbSlot = sd.save(slots);
//		return "Added Successfully with SlotId:" +dbSlot.getSlot_id();
//	}

//	public List<Slot> findAll() throws NoSlotsFoundException  {
//		List<Slot> list = sd.findAll();
//		if (list.isEmpty()) {
//			throw new NoSlotsFoundException("No Slot found");
//
//		}
//		return list;
//	}

	public Slot findBySlotId(long slotId) throws SlotIdNotFoundException  {
		Optional<Slot> op = sd.findById(slotId);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new SlotIdNotFoundException("Slot Not Found For slotId:" + slotId);
		}
	}

	public String updateSlot(long slotId, Slot slots) throws SlotIdNotFoundException  {
		if (slotId == slots.getSlot_id()) {
			Slot upSlot = sd.save(slots);
			return "Updated Successfully for SlotId:" + upSlot.getSlot_id();
		}

		throw new SlotIdNotFoundException("Slot Not Found For slotId:" + slotId);
	}

	public String deleteById(long slotId) throws SlotIdNotFoundException  {
		if (sd.existsById(slotId)) {
			sd.deleteById(slotId);
			return "Deleted Successfully for SlotId:" + slotId;
		}
		throw new SlotIdNotFoundException("Slot Not Found For adminId:" + slotId);
	}

	public Slot findSlotBySlotLocation(String sLocation) throws SlotIdNotFoundException {
		Optional<Slot> op= sd.findSlotBySlotLocation(sLocation);
		if(op.isPresent())
			return op.get();
		else
			throw new SlotIdNotFoundException("Slot Not Found for Location:"+sLocation);
	}

}
