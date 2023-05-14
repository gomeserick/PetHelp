package com.example.pethelp.sql;

import com.example.pethelp.enums.SqlTables;
import com.example.pethelp.records.Animal;
import com.example.pethelp.sql.MySqlSetup;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlAnimal {

    Connection connection;

    public SqlAnimal(){
        MySqlSetup mySqlSetup = new MySqlSetup();
        connection = mySqlSetup.getConnection();
    }

    public boolean createAnimal(Animal user){
        String raca = user.getRaca();
        String cor = user.getCor();
        String genero = user.getGenero();
        String temperamento = user.getTemperamento();
        String foto = user.getFoto();
        boolean castrado = user.isCastrado();
        String codigo = user.getCodigo();

        String query = "INSERT INTO (" +
                "Raca, " +
                "Cor, " +
                "Genero, " +
                "Temperamento," +
                "Foto, " +
                "Castrado, " +
                "Codigo)values (?,?,?,?,?,?,?)";
               
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, raca);
            ps.setString(2,cor);
            ps.setString(3,genero);
            ps.setString(4,temperamento);
            ps.setString(5,foto);
            ps.setBoolean(6,castrado);
            ps.setString(7,codigo);
            
            ps.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

        public boolean updateAnimal(Animal user){

            PreparedStatement ps = null;

        String raca = user.getRaca();
        String cor = user.getCor();
        String genero = user.getGenero();
        String temperamento = user.getTemperamento();
        String foto = user.getFoto();
        boolean castrado = user.isCastrado();
        String codigo = user.getCodigo();

            String sql = "UPDATE animal SET raca=?, cor=?, genero=?, " +
                    "temperamento=?, foto=?, castrado=?,codigo = ?";

            try{
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1, raca);
                ps.setString(2,cor);
                ps.setString(3,genero);
                ps.setString(4,temperamento);
                ps.setString(5,foto);
                ps.setBoolean(6,castrado);
                ps.setString(7,codigo);
                ps.execute();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        public void deleteAnimal(Animal user){
            String sql = "DELETE FROM animal WHERE codigo = ?";

            PreparedStatement ps = null;
            try{
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1, user.getCodigo());
                ps.execute();
            } catch ( Exception e ){
                e.printStackTrace();
            }

        }

        public Animal readAnimal(String codigo){
            PreparedStatement ps = null;
            ResultSet results = null;
            Animal animal = null;
            String sql = "SELECT * FROM animal WHERE codigo = ?";
            try {
                ps = (PreparedStatement) connection.prepareStatement(sql);
                ps.setString(1,codigo);
                results = ps.executeQuery();
                animal = new Animal(results.getString(1), //raça
                                    results.getString(2), //cor
                                    results.getString(3), //genero
                                    results.getString(4), //temperamento
                                    results.getString(5), // Codigo
                                    null,
                                    results.getBoolean(7));

            } catch (Exception e){
                e.printStackTrace();
            }

            return animal;
        }

}
