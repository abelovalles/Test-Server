/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import DataBase.connection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abelricardo
 */
@WebServlet("/eliminateClient")
public class eliminateClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        connection connnect = new connection();
       connnect.con();
       String id = request.getParameter("id");
       if(!id.isEmpty())
       connnect.deleteClient(Integer.parseInt(id));
       
        response.sendRedirect("/WebServerCrud/");
       
    }
}
