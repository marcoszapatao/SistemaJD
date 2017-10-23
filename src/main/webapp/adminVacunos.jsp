<%-- 
    Document   : IngresarVacuno
    Created on : 09-10-2017, 16:37:15
    Author     : Marcosz
--%>
<%@page import="java.util.LinkedList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="cabecera.jsp"%>
  <script>
      function mostrar(id){
          alert("Esta seguro que desea eliminar: "+id);
      }
  </script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <%@ include file="barraSuperior.jsp"%>
  </header>
    
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <%@ include file="barraLateral.jsp"%>

  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Sistema de Gestión de Engorda de Vacunos
      </h1>

    </section>
        <div >

        </div>

    <!-- Main content -->
    <section class="content">
        <br></br>
            <div class="box">
            <div class="box-header">
              <h3 class="box-title">Administrar vacunos</h3>
            </div>
                
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>DIIO</th>
                  <th>Tipo</th>
                  <th>Raza</th> 
                  <th>Fecha Ingreso</th>
                  <th>Editar</th>
                  <th>Eliminar</th>
                </tr>
                </thead>
                <tbody>
                    <% 
                    LinkedList<vacunoTO> list = (LinkedList<vacunoTO>) session.getAttribute("lista");
                    if(list != null)
                        for (int i = 0; i < list.size(); i++) {
                            vacunoTO task = list.get(i);
                    %>
                    <tr> <td><%=task.getDiio()%></td> <td><%=task.getTipo()%></td> <td><%=task.getRaza()%></td> <td><%=task.getFechaIngreso()%></td> <td><a href="vacunoController?action=editarV&id=<%=task.getDiio()%>" class="btn btn-success"><i class="fa fa-edit"> Editar</i></a></td><td><a href="vacunoController?action=deleteVacuno&id=<%=task.getDiio()%>" class="btn btn-danger" onclick="mostrar(<%=task.getDiio()%>);"><i class="fa fa-close"> Eliminar</i></a></td>  </tr>
                    <%} else{%>
                        <h1>No hay datos</h1>
                    <%}%> 
                </tbody>
                <tfoot>
                <tr>
                  <th>DIIO</th>
                  <th>Tipo</th>
                  <th>Raza</th>
                  <th>Fecha Ingreso</th>
                  <th>Editar</th>
                  <th>Eliminar</th>
                  
                </tr>
                </tfoot>
              </table>
              
            </div>
                            <!-- Modal -->
                <div id="myModal" class="modal fade" role="dialog">
                  <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Confirmar</h4>
                      </div>
                      <div class="modal-body">
                          <p>¿Esta seguro que desea eliminar el vacuno ?</p>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary">Confirmar</button>
                      </div>
                    </div>

                  </div>
                </div>
            
            <!-- /.box-body -->
          </div>  
        <div class="col-sm-2">
        <td>
          
            <a href="vacunoController?action=create" class="btn btn-block btn-info"><i class="fa fa-plus"> Agregar</i></a>
        </td>
        </div> 

   
    </section>

    </div>
      

    <!-- /.content -->
  </div>

  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <%@ include file="pieDePagina.jsp"%>
  </footer>


  

  <div class="control-sidebar-bg"></div>

<!-- ./wrapper -->


<%@ include file="scripts.jsp"%>
</body>
</html>
