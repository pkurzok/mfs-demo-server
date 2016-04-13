package com.prodyna.mfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Car createCar(@RequestBody Car car) {

		Car saved = repository.save(car);
		return saved;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCar(@PathVariable String id) {
		repository.delete(id);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void changeColor(@PathVariable String id, @RequestParam(value = "color", required = false) String color) {

		Car car = repository.findOne(id);
		if (color != null && car != null) {
			car.setColor(color);
			repository.save(car);
		}

		System.out.println("changed color to: " + color);

	}
}
