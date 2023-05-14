package com.example.pethelp.sql;

import com.example.pethelp.enums.SqlTables;
import com.example.pethelp.records.Adocao;
import com.example.pethelp.records.Animal;
import com.example.pethelp.sql.MySqlSetup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlAdocao {

    Connection connection;

    public SqlAdocao(){
        MySqlSetup mySqlSetup = new MySqlSetup();
        connection = mySqlSetup.getConnection();
    }

    public boolean createAdocao(Adocao user){
        Date data = user.getData();
        String CPFCliente = user.getCPFCliente();
        String CPFFuncionario = user.getCPFFuncionario();
        String observacoes = user.getObservacoes();
        String codigo = user.getCodigo();
        String codigoAnimal = user.getCodigoAnimal();


        String query = "INSERT INTO (" +
                "Data, " +
                "CPFCliente, " +
                "CPFFuncionario, " +
                "Observacoes," +
                " Codigo, " +
                "CodigoAnimal)values (?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setDate(1, data);
            ps.setString(2,CPFCliente);
            ps.setString(3,CPFFuncionario);
            ps.setString(4,observacoes);
            ps.setString(5,codigo);
            ps.setString(6,codigoAnimal);

            ps.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

        public boolean updateAdocao(Adocao user){

            PreparedStatement ps = null;

            Date data = user.getData();
            String CPFCliente = user.getCPFCliente();
            String CPFFuncionario = user.getCPFFuncionario();
            String observacoes = user.getObservacoes();
            String codigo = user.getCodigo();
            String codigoAnimal = user.getCodigoAnimal();

            String sql = "UPDATE adocao SET data=?, CPFCliente=?, CPFFuncionario=?, " +
                    "observacoes=?, codigo=?, codigoAnimal=?";

            try{
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setDate(1, data);
                ps.setString(2,CPFCliente);
                ps.setString(3,CPFFuncionario);
                ps.setString(4,observacoes);
                ps.setString(5,codigo);
                ps.setString(6,codigoAnimal);
                ps.execute();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        public void deleteAdocao(Adocao user){
            String sql = "DELETE FROM adocao WHERE codigo = ?";

            PreparedStatement ps = null;
            try{
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1, user.getCodigo());
                ps.execute();
            } catch ( Exception e ){
                e.printStackTrace();
            }

        }
        ''
        public Adocao readAdocao(String codigo){
            PreparedStatement ps = null;
            ResultSet results = null;
            Adocao adocao = null;
            String sql = "SELECT * FROM adocao WHERE codigo = ?";
            try {
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1,codigo);
                results = ps.executeQuery();

                Date data = results.getDate(1);
                String CPF_Cliente = results.getString(2);
                String CPF_Funcionario = results.getString(3);
                String observacoes = results.getString(4);
                String codigoAnimal = results.getString(6);
                adocao = new Adocao(data, CPF_Cliente, CPF_Funcionario,
                        observacoes, codigo, codigoAnimal);

            } catch (Exception e){
                e.printStackTrace();
            }




            return adocao;
        }

}
