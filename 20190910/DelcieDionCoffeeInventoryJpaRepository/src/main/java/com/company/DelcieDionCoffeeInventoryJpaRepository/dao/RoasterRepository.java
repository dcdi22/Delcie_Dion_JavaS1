package com.company.DelcieDionCoffeeInventoryJpaRepository.dao;

import com.company.DelcieDionCoffeeInventoryJpaRepository.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoasterRepository extends JpaRepository<Roaster, Integer> {
}
