package kodlama.io.rentACar.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer> { //ınteger primary key in türü
	//List<Brand> getAll();   spring jpa yı yaptıktan sonra buna gerek yok
	
	boolean existsByName(String name); //jpa exist kelimesini görünce hemen kontrol ediyor (özel keywords sunuyor)
}
