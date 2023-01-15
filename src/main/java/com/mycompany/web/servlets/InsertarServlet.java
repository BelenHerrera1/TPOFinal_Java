package com.mycompany.web.servlets;

import java.io.IOException;

import com.mycompany.web.models.AccionesCliente;
import com.mycompany.web.models.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nuevocliente")
public class InsertarServlet extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String a, b, c;

      a = req.getParameter("nombre");
      b = req.getParameter("apellido");
      c = req.getParameter("correo");
      
      Cliente nuevoCliente = new Cliente();

      nuevoCliente.setNombre(a);
      nuevoCliente.setApellido(b);
      nuevoCliente.setCorreo(c);

      int estado = AccionesCliente.registrarCliente(nuevoCliente);

      if(estado ==1){
         resp.sendRedirect("exito.jsp");
      } else {
         resp.sendRedirect("error.jsp");
      }

   } 
}
