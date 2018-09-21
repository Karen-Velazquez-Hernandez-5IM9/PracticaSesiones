/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;
public class Conexion {
    String url;
    String usu;
    String contra;
    Connection con;
    Statement sta;
    ResultSet res;
    
    public Conexion(){
        
        url= "jdbc:mysql://localhost/Usuarios";
        usu= "root";
        contra= "n0m3l0";
    }
    
    public String Con(String nombre, String ape){
        String bien = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, usu, contra);
            sta=con.createStatement();
            
            res=sta.executeQuery("select * from Usuario where usuario='"+nombre+"' and passw='"+ape+"';");
            if(res.next()){
                bien="Todo correcto";
            }
            else{
                bien="Falso";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return bien;
    }
}
