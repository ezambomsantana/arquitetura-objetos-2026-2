package br.edu.insper.biblioteca;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EditoraController {

    private EditoraService editoraService = new EditoraService();

    @PostMapping("/editora")
    @ResponseStatus(HttpStatus.CREATED)
    public Editora criarEditora(@RequestBody Editora editora) {
        return editoraService.criar(editora);
    }

    @GetMapping("/editora/{id}")
    public Editora getEditora(@PathVariable String id) {
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


}
