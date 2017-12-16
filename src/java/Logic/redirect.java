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
@WebServlet("/redirect")
public class redirect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        connection connnect = new connection();
//       connnect.con();
       String from=request.getParameter("From");
        String id="";
        response.setContentType("text/html");
        switch (from) {
            case "R":  
            case "M":
            case "C":   
               request.getRequestDispatcher("/RMCClient.jsp").forward(request, response);
            break;
            case "E": 
                request.getRequestDispatcher("/eliminateClient").forward(request, response);
            break;
                     
        }
       
       
    }
    
}
