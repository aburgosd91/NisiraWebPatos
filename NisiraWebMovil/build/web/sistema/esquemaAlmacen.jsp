<%-- 
    Document   : esquemaAlmacen
    Created on : 02-nov-2015, 9:14:59
    Author     : aburgos
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.nisira.core.dao.DZonaDiagramaDao"%>
<%@page import="com.nisira.core.entity.DZonaDiagrama"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRO ESQUEMA DE PLANTA</title>
        <!--<script src="../js/jquery-per.js"></script>--> 
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="../css/colorpicker.css" type="text/css" />
        <link rel="stylesheet" media="screen" type="text/css" href="../css/layout.css" />
        
        <!--<script type="text/javascript" src="../js/color/jquery.js"></script>-->
	<script type="text/javascript" src="../js/color/colorpicker.js"></script>
        <script type="text/javascript" src="../js/color/eye.js"></script>
        <script type="text/javascript" src="../js/color/utils.js"></script>
        <script type="text/javascript" src="../js/color/layout.js?ver=1.0.2"></script>
        
        <style type="text/css">
            .casilla{
                width:150px;
                height:30px;
                text-align: center;
                position:relative;
            }
            .casilla b{
                font-size: 11px;
                text-align: center;
            }
            .cuadro{
                width:700px;
            }
            .botones{
                width:100%;
                height:100%;
                background-color: rgb(255, 255, 255);
                font-size: 8px;
                text-align: center;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <script type="text/javascript">
        //<![CDATA[    
        var tamanio=200;
        var matrizHorario=new Array(100);
        //var colorActivo="#F70107";
        //var colorInactivo="#FFF8F8";
        var colorActivo="rgb(223, 0, 6)";
        var colorInactivo="rgb(255, 255, 255)";
        
        for (var i = 0; i < 100; i++) {
          matrizHorario[i] = new Array(12);
        }
        function _click(x){
            var pro=$(x);
            /*alert("Id: "+pro.attr("id"));
            alert("Color: "+pro.css("background-color").replace(/^\s+|\s+$/g, ""));*/
            //alert("#"+$('#colorpickerField1').val());
            colorActivo="#"+$('#colorpickerField1').val();
            MarcarCurso(pro,pro.css("background-color").replace(/^\s+|\s+$/g, ""),colorActivo,colorInactivo); 
        };
        function limpiar(colorInactivo){
            $('.botones').css('background-color',colorInactivo);
            $('.botones').attr("value","");
            $('.botones').prop( "disabled", false);
        }
        function MarcarCurso(objeto,colorReal,colorActivo,colorInactivo)//Marcar Curso 
        {
            if (colorReal === colorInactivo) {
                objeto.css('background-color',colorActivo);
            } else {
                objeto.attr('value',"");
                objeto.css('background-color',colorInactivo);
                deSeleccion(objeto);
            }
        }
        /*MODAL PARA INSERTAR COLORES*/
        function abrir_dialog(){
            alert("entre");
            $( "#dialog" ).dialog();
        }   
        //]]>
        </script>
        <div style="width: 15%;">
            <button onclick="abrir_dialog()">Color</button>
        </div>
        <div class="wrapper">
            <p><input type="text" maxlength="6" size="6" id="colorpickerField1" value="00ff00" /></p>
        </div>
        <br/><br/>
        <div style="alignment-adjust: central">
            <h2>ALMACEN MATERIA PRODUCCIÓN</h2>
        </div>
        <table class="cuadro"> 
            <thead>
                <tr>
                    <%
                       List<DZonaDiagrama> listDzonaDiagrama= new ArrayList<DZonaDiagrama>();
                       DZonaDiagrama dzd =new DZonaDiagrama();
                       DZonaDiagramaDao dzdDao =new DZonaDiagramaDao();
                       //dzdDao.findAll(e1, e2, e3);
                        int tamanio = 80;
                        for(int i=0;i<tamanio;i++){
                    %>
                        <th class="casilla">C-<%=i%></th>
                    <%
                        }    
                    %>
                </tr>
            </thead>
            <tbody>
            <%
                for(int i=0;i<tamanio;i++){
            %>
            <tr> 
                <%
                    for(int j=0;j<tamanio;j++){
                %>
                <td class="casilla">
                    <input type="button" value="" class="botones" name="F-<%=i%>-<%=j%>"  id="C-<%=i%>-<%=j%>" onclick="_click(this)"/>
                </td>
                <%
                    }    
                %>
            </tr> 
            <%
                }    
            %>
            </tbody>
        </table>
        <div id="dialog" title="Titulo dialog" style="display: none;">
            <p>FORMULARIO VENTANA</p>
            <p><input type="text" maxlength="6" size="6" id="colorpickerField1" value="00ff00" /></p>
            <p><input type="text" maxlength="6" size="6" id="colorpickerField3" value="0000ff" /></p>
            <p><input type="text" maxlength="6" size="6" id="colorpickerField2" value="ff0000" /></p>
        </div>
    </body>
</html>
