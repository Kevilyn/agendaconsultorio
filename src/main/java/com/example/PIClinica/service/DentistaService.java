package com.example.PIClinica.service;

import com.example.PIClinica.model.Dentista;
import com.example.PIClinica.repository.IDao;
import org.apache.catalina.LifecycleState;

import java.util.List;

public class DentistaService {

    private IDao<Dentista> dentistaDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaDao = dentistaIDao;
    }

    public Dentista salvarDentista(Dentista dentista){
        return dentistaDao.salvar(dentista);
    }

    public Dentista buscarDentista(int id){
        return dentistaDao.buscar(id);
    }

    public List<Dentista> buscarTodosDentistas(){
        return dentistaDao.buscarTodos();
    }

    public void deletarDentista(int id){
        dentistaDao.deletar(id);
    }

    public Dentista atualizarDentista(Dentista dentista){
        return dentistaDao.atualizar(dentista);
    }
}
