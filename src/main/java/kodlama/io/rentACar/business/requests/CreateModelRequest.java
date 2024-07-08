package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data            //REQUEST POST İÇİN RESPONSE GET İÇİN
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

		@NotNull //Boş bırakılamaz
		@NotBlank //Boşluk bırakılamaz
		@Size(min=3, max=20) //min3 max20 karakter olacak
		private String name;
		
		@NotNull
		@NotBlank
		private int brandId;
}
