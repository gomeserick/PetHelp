package com.example.pethelp.sql;

import com.example.pethelp.enums.SqlTables;
import com.example.pethelp.records.Animal;
import com.example.pethelp.records.Funcionario;
import com.example.pethelp.sql.MySqlSetup;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlFuncionario {

    Connection connection;

    public SqlFuncionario(){
        MySqlSetup mySqlSetup = new MySqlSetup();
        connection = mySqlSetup.getConnection();
    }

    public boolean createFuncionario(Funcionario user){
        String nome = user.getNome();
        String CPF = user.getCPF();
        String RG = user.getRG();
        String senha = user.getSenha();
        String email = user.getEmail();
        String endereco = user.getEndereco();


        String query = "INSERT INTO (" +
                "Nome, " +
                "CPF, " +
                "RG, " +
                "Senha," +
                " Email, " +
                "Endereco) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2,CPF);
            ps.setString(3,RG);
            ps.setString(4,senha);
            ps.setString(5,email);
            ps.setString(6,endereco);

            ps.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

        public boolean updateFuncionario(Funcionario user){

            PreparedStatement ps = null;

            String nome = user.getNome();
            String CPF = user.getCPF();
            String RG = user.getRG();
            String senha = user.getSenha();
            String email = user.getEmail();
            String endereco = user.getEndereco();

            String sql = "UPDATE funcionario SET nome=?, CPF=?, RG=?, " +
                    "senha=?, email=?, Endereco=?";

            try{
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2,CPF);
                ps.setString(3,RG);
                ps.setString(4,senha);
                ps.setString(5,email);
                ps.setString(6,endereco);
                ps.execute();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        public void deleteFuncionario(Funcionario user){
            String sql = "DELETE FROM funcionario WHERE CPF = ?";

            PreparedStatement ps = null;
            try{
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1, user.getCPF());
                ps.execute();
            } catch ( Exception e ){
                e.printStackTrace();
            }

        }

        public Funcionario readFuncionario(String user){
            PreparedStatement ps = null;
            ResultSet results = null;
            Funcionario funcionario = null;
            String sql = "SELECT * FROM funcionario WHERE CPF = ?";
            try {
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1,user);
                results = ps.executeQuery();
                funcionario = new Funcionario(results.getString(1), //raça
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getString(5),
                        results.getString(6));
            } catch (Exception e){
                e.printStackTrace();
            }

            return funcionario;
        }

}
