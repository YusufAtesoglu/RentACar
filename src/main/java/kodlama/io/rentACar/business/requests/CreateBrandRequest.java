package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
    //Brand create et ; id veremezsin verilen name ile brand create et
	@NotNull //Boş bırakılamaz
	@NotBlank //Boşluk bırakılamaz
	@Size(min=3, max=20) 
	private String name;
}
