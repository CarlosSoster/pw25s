package br.edu.utfpr.pb.pw25s;

import br.edu.utfpr.pb.pw25s.model.*;
import br.edu.utfpr.pb.pw25s.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Atividade1Application implements CommandLineRunner {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private LivroRepository livroRepository;

    public static void main(String[] args) {

        SpringApplication.run(Atividade1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        criarRegistros();

        listarLivrosFindByAutorContainsOrderByAno();

        listarLivrosFindByAno();

        listarLivrosFindByGeneroDescricaoOrderByAno();

        listarLivrosFindByValorGreaterThan();

        listarLivrosfindByValorBetween();

        listarLivrosFindByIsbnContainsOrTituloContainsOrderByAno();
    }

    public void criarRegistros(){
        Cidade c1 = new Cidade();
        c1.setNome("Pato Branco");
        salvarCidade(c1);

        Cidade c2 = new Cidade();
        c2.setNome("Vitorino");
        salvarCidade(c2);

        Autor a1 = new Autor();
        a1.setNome("Carlos");
        salvarAutor(a1);

        Autor a2 = new Autor();
        a2.setNome("Felipe");
        salvarAutor(a2);

        Editora e1 = new Editora();
        e1.setNome("Saraiva");
        salvarEditora(e1);

        Editora e2 = new Editora();
        e2.setNome("Abril");
        salvarEditora(e2);

        Genero g1 = new Genero();
        g1.setDescricao("Drama");
        salvarGenero(g1);

        Genero g2 = new Genero();
        g2.setDescricao("Terror");
        salvarGenero(g2);

        Livro l1 = new Livro();
        l1.setTitulo("O Cemitério");
        l1.setEditora(e1);
        l1.setGenero(g1);
        l1.setAutor(a1);
        l1.setAno(2000);
        l1.setIsbn("54654654");
        l1.setCidade(c1);
        l1.setValor(100.0);
        salvarLivro(l1);

        Livro l2 = new Livro();
        l2.setTitulo("O Homem de Giz");
        l2.setEditora(e2);
        l2.setGenero(g2);
        l2.setAutor(a2);
        l2.setAno(2010);
        l2.setIsbn("5465SAASAS4654");
        l2.setCidade(c2);
        l2.setValor(50.0);
        salvarLivro(l2);

    }

    private void salvarCidade(Cidade cidade) {

        this.cidadeRepository.save(cidade);

        System.out.println("Cidade salva com sucesso! \n " + cidade );
    }

    private void salvarAutor(Autor autor) {

        this.autorRepository.save(autor);

        System.out.println("Autor salvo com sucesso! \n " + autor );
    }

    private void salvarEditora(Editora editora) {

        this.editoraRepository.save(editora);

        System.out.println("Editora salva com sucesso! \n " + editora );
    }

    private void salvarGenero(Genero genero) {

        this.generoRepository.save(genero);

        System.out.println("Genero salvo com sucesso! \n " + genero);
    }

    private void salvarLivro(Livro livro) {

        this.livroRepository.save(livro);

        System.out.println("Livro salvo com sucesso! \n " + livro);
    }

    private void listarLivrosFindByAutorContainsOrderByAno(){
        System.out.println("\n *********** LISTA DE LIVROS POR NOME AUTOR CONTAINS ***********");
        this.livroRepository.findByAutorNomeContainsOrderByAno("Car").forEach(l ->
                System.out.println(l)
        );
        System.out.println("\n *********** LISTA DE LIVROS POR NOME AUTOR CONTAINS ***********");
    }

    private void listarLivrosFindByAno(){
        System.out.println("\n *********** LISTA DE LIVROS POR ANO ***********");
        this.livroRepository.findByAno(2000).forEach(l ->
                System.out.println(l)
        );
        System.out.println("\n *********** LISTA DE LIVROS POR ANO ***********");
    }

    private void listarLivrosFindByGeneroDescricaoOrderByAno(){
        System.out.println("\n *********** LISTA DE LIVROS POR GENERO ***********");
        this.livroRepository.findByGeneroDescricaoOrderByAno("Terror").forEach(l ->
                System.out.println(l)
        );
        System.out.println("\n *********** LISTA DE LIVROS POR GENERO ***********");
    }

    private void listarLivrosFindByIsbnContainsOrTituloContainsOrderByAno(){
        System.out.println("\n *********** LISTA DE LIVROS POR ISBN OU TITULO ***********");
        this.livroRepository.findByIsbnContainsOrTituloContainsOrderByAno("%Giz%").forEach(l ->
                System.out.println(l)
        );
        System.out.println("\n *********** LISTA DE LIVROS POR ISBN OU TITULO ***********");
    }

    private void listarLivrosFindByValorGreaterThan(){
        System.out.println("\n *********** LISTA DE LIVROS POR VALOR MAIOR ***********");
        this.livroRepository.findByValorGreaterThan(50.0).forEach(l ->
                System.out.println(l)
        );
        System.out.println("\n *********** LISTA DE LIVROS POR VALOR MAIOR ***********");
    }

    private void listarLivrosfindByValorBetween(){
        System.out.println("\n *********** LISTA DE LIVROS POR VALOR ENTRE ***********");
        this.livroRepository.findByValorBetween(40.0,60.0).forEach(l ->
                System.out.println(l)
        );
        System.out.println("\n *********** LISTA DE LIVROS POR VALOR ENTRE ***********");
    }
}
