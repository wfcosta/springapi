package br.com.rs.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rs.forum.model.Curso;

/*
 * Interface que representa o banco com a ajuda do JPA e do Spring.
*/
public interface CurseRepository extends JpaRepository<Curso, Long> {

	/*
	 * Método de busca gerenciado pelo JPA e Spring, devido a nomenclatura
	 * Descrição na classe TopicoRepository
	 */
	Curso findByNome(String nome);

}
