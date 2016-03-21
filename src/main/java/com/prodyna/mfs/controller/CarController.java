package com.prodyna.mfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.prodyna.mfs.model.Car;
import com.prodyna.mfs.repositories.CarRepository;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Car> getCars(@RequestParam(value = "make", required = false) String make,
			@RequestParam(value = "model", required = false) String model,
			@RequestParam(value = "year", required = false) Integer year) {

		if (make != null || model != null || year != null) {
			return repository.findByMakeAndModelAndYear(make, model, year);
		} else {
			return Lists.newArrayList(repository.findAll());
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Car getCar(@PathVariable String id) {
		Car car = repository.findOne(id);
		return car;
	}
}
