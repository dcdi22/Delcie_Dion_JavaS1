package com.company.DelcieDionCoffeeInventoryJpaRepository.dao;

import com.company.DelcieDionCoffeeInventoryJpaRepository.dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

    List<Coffee> findByRoasterId(int roasterId);
    List<Coffee> findByType(String type);
    List<Coffee> findByRoasterIdAndType(int roasterId, String type);

}
