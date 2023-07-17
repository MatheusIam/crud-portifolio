package com.matheusiam.crudportifolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusiam.crudportifolio.entities.Usuario;
import com.matheusiam.crudportifolio.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repositorio;

    // ache todos
    public List<Usuario> acheTodos(){
        return repositorio.findAll();
    }

    // ache todos por id
    public Usuario achePorId(Integer id){
        Optional<Usuario> obj = repositorio.findById(id);
        return obj.get();
    }

    // salvar
    public Usuario salvar(Usuario obj){
        return repositorio.save(obj);
    }

    // apagar
    public void apagar(Integer id){
        repositorio.deleteById(id);
    }

    // alterar
    public Usuario alterar(Integer id, Usuario alterado){
        Usuario obj = repositorio.getReferenceById(id);
        alterarDados(obj, alterado);
        return repositorio.save(obj);
    }

    // alterar dados
    public void alterarDados(Usuario obj, Usuario alterado){
        obj.setCpf(alterado.getCpf());
        obj.setDataNascimento(alterado.getDataNascimento());
        obj.setFotoUrl(alterado.getFotoUrl());
        obj.setNome(alterado.getNome());
        obj.setSexo(alterado.getSexo());
    }
}
