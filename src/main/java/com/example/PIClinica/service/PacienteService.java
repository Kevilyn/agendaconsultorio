package com.example.PIClinica.service;

import com.example.PIClinica.model.Paciente;
import com.example.PIClinica.repository.IDao;

import java.util.Date;
import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente paciente){
        paciente.setDataAlta(new Date());
        return pacienteIDao.salvar(paciente);
    }

    public Paciente buscar(int id){
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }

    public void deletar(int id){
        pacienteIDao.deletar(id);
    }

    public Paciente atualizar(Paciente paciente){
        return pacienteIDao.atualizar(paciente);
    }
}
