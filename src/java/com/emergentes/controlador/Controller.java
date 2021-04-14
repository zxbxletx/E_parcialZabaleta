package com.emergentes.controlador;

import com.emergentes.modelo.GestorDatos;
import com.emergentes.modelo.Datos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Datos objDatos = new Datos();
        int id;
        int pos;
        String op = request.getParameter("op");
        
        if(op.equals("nuevo")){
            HttpSession ses = request.getSession();
            GestorDatos registro = (GestorDatos) ses.getAttribute("registro");
            objDatos.setId(registro.obtieneId());
            
            request.setAttribute("op", op);
            request.setAttribute("miTarea", objDatos);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("modificar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorDatos registro = (GestorDatos) ses.getAttribute("registro");
            pos = registro.ubicarDatos(id);
            objDatos = registro.getLista().get(pos);
            
            request.setAttribute("op", op);
            request.setAttribute("miTarea", objDatos);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorDatos registro = (GestorDatos) ses.getAttribute("registro");
            pos = registro.ubicarDatos(id);
            registro.eliminarDatos(pos);
            ses.setAttribute("registro", registro);
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Datos objDatos = new Datos();
        int pos;
        String op = request.getParameter("op");
        
        if(op.equals("guardar")){
            objDatos.setId(Integer.parseInt(request.getParameter("id")));
            objDatos.setNombre(request.getParameter("nombre"));
            objDatos.setPeso(Double.parseDouble(request.getParameter("peso")));
            objDatos.setTalla(Double.parseDouble(request.getParameter("talla")));
            objDatos.setVacunado(request.getParameter("vacunado"));
            
            
            HttpSession ses = request.getSession();
            GestorDatos registro = (GestorDatos) ses.getAttribute("registro");
            
            String opg = request.getParameter("opg");
            if(opg.equals("nuevo")){
                registro.insertarDatos(objDatos);
            }
            else{
                pos = registro.ubicarDatos(objDatos.getId());
                registro.modificarDatos(pos, objDatos);
            }
            ses.setAttribute("registro", registro);
            response.sendRedirect("index.jsp");
        }
    }

}
