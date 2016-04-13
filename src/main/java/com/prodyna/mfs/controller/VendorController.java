/**
 * 
 */
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
import com.prodyna.mfs.model.Vendor;
import com.prodyna.mfs.repositories.CarRepository;
import com.prodyna.mfs.repositories.VendorRepository;

/**
 * @author Peter Kurzok, PRODYNA AG
 *
 */
@RestController
@RequestMapping("/vendors")
public class VendorController {

	@Autowired
	VendorRepository repository;

	@Autowired
	CarRepository carRepo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Vendor> getVendors(@RequestParam(value = "name", required = false) String name) {

		if (name != null) {
			return repository.findByName(name);
		} else {
			return Lists.newArrayList(repository.findAll());
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Vendor getVendor(@PathVariable String id) {
		Vendor vendor = repository.findOne(id);
		return vendor;
	}

	@RequestMapping(value = "/{id}/createCar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Car createCar(@PathVariable String id, @RequestBody Car car) {

		Vendor vendor = repository.findOne(id);
		car.setVendor(vendor);

		Car saved = carRepo.save(car);
		return saved;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vendor createVendor(@RequestBody Vendor vendor) {
		Vendor save = repository.save(vendor);
		return save;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteVendor(@PathVariable String id) {
		repository.delete(id);
	}

}
