<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.util.ArrayList,DataBase.connection,Logic.client" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Test</title>
         <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.css'>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div style="margin-top: 5%; margin-left: 5% ; margin-right: 5%; ">
             <h1>Datos Client</h1>
             <div  style="margin-top: 5%;">
                  <%
                     connection o = new connection();  
                    o.con();   
                    client Client= new client();
                    int id= Integer.parseInt(request.getParameter("id"));
                    if(id!=0){
                    Client= o.getspecificlient(id);
                    }
                        %>
                <form action="${pageContext.request.contextPath}/registerClient?id=<%out.print(id);%>" method="post"> 
                   <div class="form-row">
                     <div class="form-group col-md-6">
                       <label for="inputClient">Razon Social</label>
                       <input type="text" class="form-control" id="inputClient" name="inputClient" value="<%out.print( Client.getNamecliente()); %>" placeholder="Client">
                     </div>
                   </div>
                   <div class="form-group">
                     <label for="inputRUC">RUC</label>
                     <input type="text" class="form-control" id="inputRUC"  name="inputRUC" value="<%out.print( Client.getRuc()); %>" placeholder="84498 Dv 64">              
                   </div>
                   <div class="form-group">
                     <label for="inputAddress">Address</label>
                     <input type="text" class="form-control" id="inputAddress"  name="inputAddress" value="<%out.print( Client.getAddressCleint()); %>" placeholder="Apartment, studio, or floor">
                   </div>
                   <div class="form-group">
                     <label for="inputPhoneNumber">Phone Number</label>
                     <input type="text" class="form-control" id="inputPhoneNumber"  name="inputPhoneNumber" value="<%out.print( Client.getPhonecleinte()); %>" placeholder="6322-1215">
                   </div><% if(!request.getParameter("From").equals(("C"))){ %>
                   <button type="submit" class="btn btn-primary">Salvar</button>
                   <% } %>
               </form>
            </div>
        </div>
    </body>
</html>
