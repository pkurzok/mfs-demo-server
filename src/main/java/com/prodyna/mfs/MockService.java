package com.prodyna.mfs;

import com.prodyna.mfs.model.Car;
import com.prodyna.mfs.model.Vendor;
import com.prodyna.mfs.repositories.CarRepository;
import com.prodyna.mfs.repositories.VendorRepository;

public class MockService {

	private CarRepository carRepo;
	private VendorRepository vendorRepo;

	public MockService(CarRepository carRepo, VendorRepository vendorRepo) {

		this.carRepo = carRepo;
		this.vendorRepo = vendorRepo;
	}

	public void init() {
		Vendor vendor = vendorRepo.save(new Vendor("Olli's Gebrauchtwagen Markt"));

		carRepo.save(new Car("Volkswagen", "Passat", "Schwarz", 2010, 140, vendor));
		carRepo.save(new Car("Audi", "A6", "Silber", 2015, 320, vendor));
		carRepo.save(new Car("BMW", "320d", "Weiß", 2015, 240, vendor));
	}
}
