package kodlama.io.rentACar.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.rentACar.entities.concretes.Model;

public interface ModelRespository extends JpaRepository<Model, Integer>{

}
