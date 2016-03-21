/**
 * 
 */
package com.prodyna.mfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.prodyna.mfs.model.Vendor;
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

}
