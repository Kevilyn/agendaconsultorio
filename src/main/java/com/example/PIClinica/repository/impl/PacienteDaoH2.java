package com.example.PIClinica.repository.impl;

import com.example.PIClinica.model.Paciente;
import com.example.PIClinica.repository.IDao;
import com.example.PIClinica.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Paciente salvar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            preparedStatement = connection.prepareStatement("INSERT INTO pacientes(nome,sobrenome,endereco,rg,dataAlta) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getSobrenome());
            preparedStatement.setString(3, paciente.getEndereco());
            preparedStatement.setInt(4, paciente.getRg());
            preparedStatement.setDate(5, Util.utilDateToSqlDate(paciente.getDataAlta()));

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                paciente.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT id,nome,sobrenome,endereco,rg,dataAlta  FROM pacientes where id = ?");
            preparedStatement.setInt(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idPaciente = result.getInt("id");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                String endereco = result.getString("endereco");
                int rg = result.getInt("rg");
                java.sql.Date dataAlta = result.getDate("dataAlta");

                paciente = new Paciente(idPaciente,nome,sobrenome,endereco,rg,dataAlta);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return paciente;
    }

    @Override
    public void deletar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM pacientes where id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT *  FROM pacientes");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idPaciente = result.getInt("id");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                String endereco = result.getString("endereco");
                int rg = result.getInt("rg");
                java.sql.Date dataAlta = result.getDate("dataAlta");

                Paciente paciente = new Paciente(idPaciente,nome,sobrenome,endereco,rg,dataAlta);
                pacientes.add(paciente);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("UPDATE pacientes SET nome=?, sobrenome=?, endereco=?, rg=?, dataAlta=?  WHERE id = ?");

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getSobrenome());
            preparedStatement.setString(3, paciente.getEndereco());
            preparedStatement.setInt(4, paciente.getRg());
            preparedStatement.setDate(5, Util.utilDateToSqlDate(paciente.getDataAlta()));

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }
}
