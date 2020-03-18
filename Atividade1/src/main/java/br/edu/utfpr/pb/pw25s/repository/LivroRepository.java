package br.edu.utfpr.pb.pw25s.repository;

import br.edu.utfpr.pb.pw25s.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByAutorNomeContainsOrderByAno(String nome);

    List<Livro> findByAno(Integer ano);

    List<Livro> findByGeneroDescricaoOrderByAno(String nome);

    @Query(value = "Select l from Livro l Where l.isbn Like :parametro Or l.titulo Like :parametro")
    List<Livro> findByIsbnContainsOrTituloContainsOrderByAno(@Param("parametro") String parametro);

    List<Livro> findByValorGreaterThan(Double valor);

    List<Livro> findByValorBetween(Double valor1, Double valor2);
}
