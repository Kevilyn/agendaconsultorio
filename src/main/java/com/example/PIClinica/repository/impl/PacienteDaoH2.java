package com.example.PIClinica.repository.impl;

import com.example.PIClinica.model.Paciente;
import com.example.PIClinica.repository.IDao;

import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Paciente salvar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscar(Integer id) {
        return null;
    }

    @Override
    public void deletar(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        return null;
    }
}
