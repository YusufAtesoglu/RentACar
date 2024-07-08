package kodlama.io.rentACar.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {  //GetAll işlemi için brand listele id ve name dönder
	private int id;
	private String name;
	
}
