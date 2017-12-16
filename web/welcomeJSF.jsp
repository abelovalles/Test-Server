<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List,java.util.ArrayList,DataBase.connection,Logic.client" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CRUD Test</title>
            <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.css'>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
        </head>
        <body>
            <div style="margin: 3%;">
            <h1>CRUD Test</h1>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/redirect?From=R&id=0" style="margin-top: 4px;">Crear Cliente</a>
            <div class="table-responsive">
            <table class="table" style="margin-top: 2%;">
                <%
                     connection o = new connection();  
                    o.con();                    
                    ArrayList<client> cleinteList = o.getClientList();                   
                        %>
                        <tr>
                            <td><h3>Cliente</h3></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                            
                             <%
                             for(int i = 1; i<cleinteList.size();i++)
                                { %>
                                <tr>
                                 <td>
                                 <%out.print( cleinteList.get(i).getNamecliente());
                                 %>
                                 </td>
                                 <td>
                                      <a type="button" href="${pageContext.request.contextPath}/redirect?From=C&id=<%out.print( cleinteList.get(i).getIdcliente());
                                 %>" class="btn btn-primary btn-sm">Consultar</a>    
                                 
                                 </td>
                                  <td>
                                      <a type="button" href="${pageContext.request.contextPath}/redirect?From=M&id=<%out.print( cleinteList.get(i).getIdcliente());
                                 %>" class="btn btn-primary btn-sm" >Modificar</a>    
                                 
                                 </td>
                                  <td>
                                      <a type="button" href="${pageContext.request.contextPath}/redirect?From=E&id=<%out.print( cleinteList.get(i).getIdcliente());
                                 %>" class="btn btn-primary btn-sm">Eliminar</a>    
                                 
                                 </td>
                                  </tr>
                            <% 
                                }
                            %>                   
                           
                        <% 
                %>
            </table>
            </div>
            </div>
        </body>
    </html>
