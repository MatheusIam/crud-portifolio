package com.matheusiam.crudportifolio.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusiam.crudportifolio.entities.Usuario;
import com.matheusiam.crudportifolio.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRC {
    
    @Autowired UsuarioService service;

    // GetMappings para leitura de dados
    @GetMapping
    public ResponseEntity<List<Usuario>> acheTodos(){
		List<Usuario> usuarios = service.acheTodos();
		return ResponseEntity.ok().body(usuarios); 
	}

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> achePorId(@PathVariable Integer id){
        Usuario obj = service.achePorId(id);
        return ResponseEntity.ok().body(obj);
    }

    // GetMappings para gravação e deleção de dados
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario obj){
		obj = service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // 
		return ResponseEntity.created(uri).body(obj);
	}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Usuario> deletar (@PathVariable Integer id) {
        service.apagar(id);
        return ResponseEntity.noContent().build();
    }

    // PutMapping para alteração de dados existentes no banco de dados
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> alterar (@PathVariable Integer id, @RequestBody Usuario obj) {
        service.alterar(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
