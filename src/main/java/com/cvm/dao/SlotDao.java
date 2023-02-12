package com.cvm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvm.entities.Slot;

@Repository("sd")
public interface SlotDao extends JpaRepository<Slot,Long>{

	Optional<Slot> findSlotBySlotLocation(String sLocation);

}
