package br.edu.insper.biblioteca.editora.controller;


import br.edu.insper.biblioteca.editora.model.Editora;
import br.edu.insper.biblioteca.editora.dto.EditoraLivrosDTO;
import br.edu.insper.biblioteca.editora.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @PostMapping("/editora")
    @ResponseStatus(HttpStatus.CREATED)
    public Editora criarEditora(@RequestBody Editora editora) {
        return editoraService.criar(editora);
    }

    @GetMapping("/editora/{id}")
    public Object getEditora(@PathVariable String id) {
        return editoraService.buscar(id);
    }

    @DeleteMapping("/editora/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEditora(@PathVariable String id) {
        editoraService.excluir(id);
    }

    @GetMapping("/editora")
    public ArrayList<Editora> getEditoras(@RequestParam(required = false) String nome) {
        return editoraService.listar(nome);
    }

    @GetMapping("/editora/conta-livros")
    public ArrayList<EditoraLivrosDTO> getContaLivros() {
        return editoraService.getNumeroLivrosEditora();
    }


}
