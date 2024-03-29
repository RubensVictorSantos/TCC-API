package godinner.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import godinner.app.model.Restaurante;
import godinner.app.model.RestauranteExibicao;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

	@Query("SELECT COUNT(r.id) FROM Restaurante r WHERE r.email = ?1")
	public int validarEmailUnico(String email);

	@Query("SELECT COUNT(r.id) FROM Restaurante r WHERE r.cnpj = ?1 ")
	public int validarCnpjUnico(String cnpj);

	@Query("SELECT r FROM Restaurante r WHERE r.id = ?1 ")
	public Restaurante getPorId(int id);

	@Query("SELECT r FROM Restaurante r WHERE r.email = ?1")
	public Restaurante getRestauranteByEmail(String email);

	@Query("SELECT r FROM Restaurante r WHERE r.email = ?1 and r.senha = ?2")
	public Restaurante getRestauranteByEmailAndPass(String email, String senha);

	@Query(value = "SELECT *"
			+ "FROM" 
			+"    tbl_restaurante AS r" 
			+"        INNER JOIN" 
			+"    tbl_endereco AS e ON e.id_endereco = r.id_endereco" 
			+"        INNER JOIN" 
			+"    tbl_cidade AS c ON c.id_cidade = e.id_cidade" 
			+"        INNER JOIN" 
			+"    tbl_estado AS es ON es.id_estado = c.id_estado" 
			+" WHERE" 
			+"		c.cidade = ?1 limit 10", nativeQuery = true)
	public List<Restaurante> getRestauranteExibicao(String cidade);

}
