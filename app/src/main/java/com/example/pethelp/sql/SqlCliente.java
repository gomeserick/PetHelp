package com.example.pethelp.sql;

import android.util.Log;

import com.example.pethelp.enums.SqlTables;
import com.example.pethelp.records.Cliente;
import com.example.pethelp.sql.MySqlSetup;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlCliente {

    Connection connection;

    public SqlCliente(){
        MySqlSetup mySqlSetup = new MySqlSetup();
        connection = mySqlSetup.getConnection();
    }

    public boolean createCliente(Cliente user){
        String nome = user.getNome();
        String CPF = user.getCPF();
        String RG = user.getRG();
        String senha = user.getSenha();
        String email = user.getEmail();
        boolean notificacoes = user.isNotificacao();
        String endereco = user.getEndereco();


        String query = "INSERT INTO (" +
                "Nome, " +
                "CPF, " +
                "RG, " +
                "Senha," +
                " Email, " +
                "Notificacao, " +
                "Endereco) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2,CPF);
            ps.setString(3,RG);
            ps.setString(4,senha);
            ps.setString(5,email);
            ps.setBoolean(6,notificacoes);
            ps.setString(7,endereco);

            ps.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

        public boolean updateCliente(Cliente user){

            PreparedStatement ps = null;

            String nome = user.getNome();
            String CPF = user.getCPF();
            String RG = user.getRG();
            String senha = user.getSenha();
            String email = user.getEmail();
            boolean notificacoes = user.isNotificacao();
            String endereco = user.getEndereco();

            String sql = "UPDATE cliente SET nome=?, CPF=?, RG=?, " +
                    "senha=?, email=?, Notificacao=?, Endereco=?";

            try{
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2,CPF);
                ps.setString(3,RG);
                ps.setString(4,senha);
                ps.setString(5,email);
                ps.setBoolean(6,notificacoes);
                ps.setString(7,endereco);
                ps.execute();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        public void deleteCliente(Cliente user){
            String sql = "DELETE FROM cliente WHERE CPF = ?";

            PreparedStatement ps = null;
            try{
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1, user.getCPF());
                ps.execute();
            } catch ( Exception e ){
                e.printStackTrace();
            }

        }

    public Cliente readClientCPF(String user){
        PreparedStatement ps = null;
        ResultSet results = null;
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE CPF = ?";
        try {
            ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1,user);
            results = ps.executeQuery();

            String nome = results.getString(1);
            String CPF = results.getString(2);
            String RG = results.getString(3);
            String senha = results.getString(4);
            String email = results.getString(5);
            boolean notificao = results.getBoolean(6);
            String endereco = results.getString(7);

            Log.d("teste",nome);
            cliente = new Cliente(nome, CPF, RG, senha, email, notificao, endereco);

        } catch (Exception e){
            e.printStackTrace();
        }

        return cliente;
    }

    public Cliente readClienteEmail(String user){
        PreparedStatement ps = null;
        ResultSet results = null;
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE Email = ?";
        try {
            ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1,user);
            results = ps.executeQuery();

            String nome = results.getString(1);
            String CPF = results.getString(2);
            String RG = results.getString(3);
            String senha = results.getString(4);
            String email = results.getString(5);
            boolean notificao = results.getBoolean(6);
            String endereco = results.getString(7);

            cliente = new Cliente(nome, CPF, RG, senha, email, notificao, endereco);

        } catch (Exception e){
            e.printStackTrace();
        }

        return cliente;
    }

}
