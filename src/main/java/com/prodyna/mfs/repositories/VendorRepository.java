package com.prodyna.mfs.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prodyna.mfs.model.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, String> {

	List<Vendor> findByName(String name);

}
