package kodlama.io.rentACar.entities.concretes;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="brands")                           //@Data getter setter ve parametresiz constructor için
@Getter
@Setter
@AllArgsConstructor //parametrei constructor için
@NoArgsConstructor //parametresiz kullanabilmek için
@Entity
public class Brand { 
 
	@Id //sen primary keysin
	@GeneratedValue(strategy=GenerationType.IDENTITY) //primary key olduu için otomatik artansın
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="brand")
	private List<Model> models;
	
	
}
