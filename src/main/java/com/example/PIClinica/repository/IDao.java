package com.example.PIClinica.repository;

import java.util.List;

public interface IDao <T>{

    T salvar(T t);
    T buscar(Integer id);
    Boolean deletar(Integer id);
    List<T> buscarTodos();
    T atualizar(T t);

}
