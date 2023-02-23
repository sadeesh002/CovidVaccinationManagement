package com.cvm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cvm.dao.AdminDao;
import com.cvm.dao.SlotDao;
import com.cvm.entities.MedicalStaff;
import com.cvm.entities.Slot;
import com.cvm.exceptions.NoSlotsFoundException;
import com.cvm.services.AdminsService;

@SpringBootTest
public class AdminsServiceTest {
	
	@InjectMocks
	AdminsService asss;
	
	@Mock
	SlotDao add;
	
	@Test
	public void insertSlotTest() {
		
		Slot slot=new Slot();
		slot.setSlotId(1);
		slot.setDate(LocalDate.of(2023, 06, 10));
		slot.setSlotLocation("Chennai");
		slot.setCurrentAvailabeSlot(30);
		slot.setBalanceAvailabeSlot(20);
		
		when(add.save(slot)).thenReturn(slot);
		String result = asss.insertSlot(slot);
		assertEquals("Added Successfully with SlotId:"+slot.getSlotId(), result);
	}
	
	@Test
	public void findAllTest() throws NoSlotsFoundException {
		
		Slot slot=new Slot();
		slot.setSlotId(1);
		slot.setDate(LocalDate.of(2023, 06, 10));
		slot.setSlotLocation("Chennai");
		slot.setCurrentAvailabeSlot(30);
		slot.setBalanceAvailabeSlot(20);
		
		List<Slot> list=new ArrayList<>();
		list.add(slot);
		
		when(add.findAll()).thenReturn(list);
		List<Slot> result=new ArrayList<>();
		result = asss.findAll();
		assertEquals(list, result);
		
	}

}
