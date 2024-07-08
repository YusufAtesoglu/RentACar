package kodlama.io.rentACar.entities.concretes;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="models")                           //@Data getter setter ve parametresiz constructor için
@Getter
@Setter
@AllArgsConstructor //parametrei constructor için
@NoArgsConstructor //parametresiz kullanabilmek için
@Entity
public class Model {

	@Id //sen primary keysin
	@GeneratedValue(strategy=GenerationType.IDENTITY) //primary key olduğu için otomatik artansın
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@OneToMany(mappedBy="model")
	private List<Car> cars;
}
