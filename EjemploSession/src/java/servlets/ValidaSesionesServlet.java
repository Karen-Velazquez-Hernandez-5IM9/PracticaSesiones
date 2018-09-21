/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import clases.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidaSesionesServlet extends HttpServlet {
   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

      response.setContentType("text/html");
      HttpSession sesion = request.getSession();
      String titulo = null;
      
      Conexion cone= new Conexion();
      
      //Pedimos el atributo, y verificamos si existe
      String claveSesion = (String) sesion.getAttribute("claveSesion");
      String user=(String) sesion.getAttribute("Nombre");
      String contra=(String) sesion.getAttribute("Contra");
      
      if(cone.Con(user, contra).equals("Todo correcto")){
        PrintWriter out = response.getWriter();
        out.println("Cuenta Valida");
        out.println("<br>");
      }
      else{
        PrintWriter out = response.getWriter();
        out.println("Cuenta no Valida");
        out.println("<br>");
      }

      cone.Con(titulo, claveSesion);

      //Mostramos los  valores en el cliente
      PrintWriter out = response.getWriter();
      out.println("¿Continua la Sesion y es valida?: " + titulo);
      out.println("<br>");
      out.println("ID de la sesi&oacute;n JSESSIONID: " + sesion.getId());
  
    }

}
