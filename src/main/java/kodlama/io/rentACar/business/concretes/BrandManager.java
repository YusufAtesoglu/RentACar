package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service // Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	@Override
	public List<GetAllBrandsResponse> getAll() {

		
//		List<GetAllBrandsResponse> brandResponse = new ArrayList<GetAllBrandsResponse>();
//
//		for (Brand brand : brands) {
//			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//			responseItem.setId(brand.getId());
//			responseItem.setName(brand.getName());
//			brandResponse.add(responseItem);
//		}
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandResponse= brands.stream()
		.map(brand->this.modelMapperService.forResponse()    //(brand-> her bir brand için demek
				.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		// iş kuralları
		return brandResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		//bir marka oluşturuyorum ve gelen marakayı ona set ediyorum
		//Brand brand = new Brand();
		//brand.setName(createBrandRequest.getName());
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
Brand brand=this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);

	}

	@Override
	public GetByIdBrandResponse getById(int id) {     //brand bulamazsan hata ver
		Brand brand=this.brandRepository.findById(id).orElseThrow();
			
		GetByIdBrandResponse response=this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);	
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
	}

}
