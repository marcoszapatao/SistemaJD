package com.proyecto.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.proyecto.transferObject.vacunoTO;

public class vacunoDAO {
    private static final String INSERT_QUERY ="insert into vacunos(id_vacuno,tipo,raza,fechaI) values(?,?,?,?)";
    private static final String DELETE_QUERY="DELETE FROM vacunos WHERE id_vacuno=?";
    private static final String UPDATE_QUERY="UPDATE vacunos SET id_vacuno = ?,tipo = ?,raza = ?,fechaI = ? WHERE id_vacuno=?";
    private static final String READ_QUERY="select * from vacunos where id_vacuno=?";
    private static final String READ_ALL ="select * from vacunos";
    private static final String READ_PEND ="select * from task WHERE estado = FALSE";
    private static final String DB_NAME="jd";
    private static final String PORT="3306";
    private static final String URL="jdbc:mysql://localhost/"+DB_NAME;    
    private static final String USER="root";
    private static final String PASSWORD="";
    private static Connection conexion = null;
    
    public int createVacuno(vacunoTO vacuno) throws SQLException{
        int result =0;
        try{
        conexion = getConnection();
        PreparedStatement ps = conexion.prepareStatement(INSERT_QUERY);
        ps.setString(1, vacuno.getDiio());
        ps.setString(2,vacuno.getTipo());
        ps.setString(3, vacuno.getRaza());
        Date fe =vacuno.getFechaIngreso();
        System.out.println("GFecha..........."+fe);
        ps.setDate(4, fe);
        ps.executeUpdate();
        result = 1;
        }catch(SQLException e){
            System.out.println("Error aquiiii");
            System.out.println(e);
        }finally{
            if(conexion!=null)
                conexion.close();
        }
        return result;
    }
    
        public LinkedList<vacunoTO> readAllV() throws SQLException{
        LinkedList<vacunoTO> lista = new LinkedList<>();
        vacunoTO result = null;
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(READ_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                result= new vacunoTO();
                result.setDiio(rs.getString("id_vacuno"));
                result.setTipo(rs.getString("tipo"));
                result.setRaza(rs.getString("raza"));
                result.setFechaIngreso(rs.getDate("fechaI"));
                System.out.println("paso aqui");
                lista.add(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(vacunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conn.close();
        }
        return lista;
    }
        public vacunoTO read(String id) throws SQLException{
         vacunoTO result = null;
        
        try {
            getConnection();
            PreparedStatement ps = conexion.prepareStatement(READ_QUERY);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                result= new vacunoTO();
                result.setDiio(rs.getString("id_vacuno"));
                result.setTipo(rs.getString("tipo"));
                result.setRaza(rs.getString("raza"));
                result.setFechaIngreso(rs.getDate("fechaI"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(vacunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            //conexion.close();
        }
        return result;
    }
        
        
    public boolean update(vacunoTO vacuno) throws SQLException{
        boolean resultado = false;
        try{
          conexion = getConnection();
          PreparedStatement ps = conexion.prepareStatement(UPDATE_QUERY);
          ps.setString(1,vacuno.getDiio());
          ps.setString(2,vacuno.getTipo());
          ps.setString(3,vacuno.getRaza());
          ps.setDate(4, vacuno.getFechaIngreso());
          ps.setString(5,vacuno.getDiio());
          ps.executeUpdate();
          resultado = true;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            if(conexion!=null)
                conexion.close();
        }
        return resultado;
    
    }
    
    
        public boolean delete(vacunoTO vacuno) throws SQLException{
        boolean resultado = false;
        try{
          conexion = getConnection();
          PreparedStatement ps = conexion.prepareStatement(DELETE_QUERY);
          ps.setString(1,vacuno.getDiio());
          ps.executeUpdate();
          resultado = true;
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            if(conexion!=null)
                conexion.close();
        }
       return resultado;
    }
    
    private static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=(Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(ClassNotFoundException | SQLException e1){
            e1.printStackTrace();
            System.err.println("Error en BDD!!!");
        }
        return conexion;
    }
}
