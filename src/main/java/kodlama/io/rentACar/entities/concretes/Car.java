package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="cars")                           //@Data getter setter ve parametresiz constructor için
@Getter
@Setter
@AllArgsConstructor //parametrei constructor için
@NoArgsConstructor //parametresiz kullanabilmek için
@Entity
public class Car {
	@Id //sen primary keysin
	@GeneratedValue(strategy=GenerationType.IDENTITY) //primary key olduu için otomatik artansın
	@Column(name="id")
	private int id;
	
	@Column(name="plate", unique=true)
	private String plate;
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name="modelyear")
	private int modelyear;
	
	@Column(name="state")
	private String state; //1-Avalable 2-Rented  3-Maintenance
	
	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
	
}
