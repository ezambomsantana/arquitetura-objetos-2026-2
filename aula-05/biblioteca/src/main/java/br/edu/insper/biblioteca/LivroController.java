package br.edu.insper.biblioteca;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LivroController {

    private LivroService livroService = new LivroService();

    @PostMapping("/livro")
    @ResponseStatus(HttpStatus.CREATED)
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroService.criar(livro);
    }

    @GetMapping("/livro/{isbn}")
    public Livro getLivro(@PathVariable String isbn) {
        return livroService.buscar(isbn);
    }

    @DeleteMapping("/livro/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLivro(@PathVariable String id) {
        livroService.excluir(id);
    }

    @GetMapping("/livro")
    public ArrayList<Livro> getLivros(@RequestParam(required = false) String nome) {
        return livroService.listar(nome);
    }


}
