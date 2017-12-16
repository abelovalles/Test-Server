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
@WebServlet("/registerClient")
public class registerclient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       String id = request.getParameter("id");
       if("0".equals(id) && !id.isEmpty()){
           registerCleint(request);
       }else if(!"0".equals(id) && !id.isEmpty()){
           updateClient(request,Integer.parseInt(id));
       }
       response.sendRedirect("/WebServerCrud/");
    }
    
    private void registerCleint(HttpServletRequest request){
         connection connnect = new connection();
       connnect.con();
       String name=request.getParameter("inputClient");
       String ruc= request.getParameter("inputRUC");
       String address=request.getParameter("inputAddress");
       String phone=request.getParameter("inputPhoneNumber");
       if(!name.isEmpty()&&!ruc.isEmpty()&&!address.isEmpty()&&!phone.isEmpty()){
       connnect.createClient(name, ruc,address , phone);  
       }
    }
    
     private void updateClient(HttpServletRequest request,int id){
         connection connnect = new connection();
       connnect.con();
       String name=request.getParameter("inputClient");
       String ruc= request.getParameter("inputRUC");
       String address=request.getParameter("inputAddress");
       String phone=request.getParameter("inputPhoneNumber");
       if(!name.isEmpty()&&!ruc.isEmpty()&&!address.isEmpty()&&!phone.isEmpty()){
       connnect.updateClient(id,name, ruc,address , phone);  
       }
    }
    
}
