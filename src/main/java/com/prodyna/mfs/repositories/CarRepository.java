package com.prodyna.mfs.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prodyna.mfs.model.Car;

public interface CarRepository extends CrudRepository<Car, String> {

	List<Car> findByMake(String make);

	List<Car> findByModel(String model);

	List<Car> findByColor(String color);

	List<Car> findByMakeAndModel(String make, String model);

	List<Car> findByMakeAndModelAndYear(String make, String model, int year);

}
