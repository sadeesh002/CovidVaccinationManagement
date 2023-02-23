package com.cvm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvm.dao.SlotDao;
import com.cvm.entities.Slot;
import com.cvm.exceptions.NoSlotsFoundException;
import com.cvm.exceptions.SlotIdNotFoundException;

@Service("ass")
public class AdminsService {
	
	@Autowired
	SlotDao sd;
	
	public String insertSlot(Slot slots) {
		Slot dbSlot = sd.save(slots);
		return "Added Successfully with SlotId:" +dbSlot.getSlotId();
	}
	
	public List<Slot> findAll() throws NoSlotsFoundException  {
		List<Slot> list = sd.findAll();
		if (list.isEmpty()) {
			throw new NoSlotsFoundException("No Slot found");

		}
		return list;
	}

}
