package br.com.rs.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rs.forum.model.Topico;

/*
 * Interface que representa o banco com a ajuda do JPA e do Spring.
*/
public interface TopicRepository extends JpaRepository<Topico, Long> {

	/*
	 * Método de busca gerenciado pelo JPA e Spring, devido a nomenclatura
	 * Padrão parecido com o DAO, mas gerenciado pelo JPA e Spring.
	 * findByCurso -> Vai buscar dentro do Topico o Curso
	 * findByCursoNome -> CursoNome -> vai buscar dentro do Curso o nome
	 * Com esse padrão de nomenclatura o JPA e o Spring regencia as consultas, podemos fazer quantos niveis quizermos.
	 * Podemos também colocar outro nome no metodo, porém precisamos passar a query para o Spring realizar a busca.
	 */
	List<Topico> findByCursoNome(String nomeCurso);

}
