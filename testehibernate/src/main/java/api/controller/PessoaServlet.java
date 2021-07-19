package api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.repository.PessoaDAO;
import api.model.Pessoa;
//import api.CommentStoreApplication;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet(name="PessoaServlet",urlPatterns="/pessoa")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PessoaDAO pessoaDAO;
	private String entidade = "Pessoa";
	
	public void init() {
		// CommentStoreApplication.main(null);
		//pessoaDAO = new PessoaDAO();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
 }
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // String action = request.getServletPath();
    String op = request.getParameter("op");

    try {
        switch (op) {
        
        case "teste":
            showTeste(request, response);
            break;
            
        case "new":
            //showNewForm(request, response);
            break;
        case "insert":
            //insertEquipamento(request, response);
            break;
        case "delete":
        	//deleteEquipamento(request, response);
            break;
        case "edit":
            //showEditForm(request, response);
            break;
        case "update":
        	//updateEquipamento(request, response);
            break;
        case "list":
        	//listEquipemanto(request, response);
            break;
        case "home":
        	//showHome(request, response);
            break;
        default:
        	//message(request, response);
            break;
        }
    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 
 private void showTeste(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
	 	// String action = request.getServletPath();
	 PrintWriter imprimir = response.getWriter();
     imprimir.println("<html><body>");
     imprimir.println("Funcionando!!</br>");
     imprimir.println("</body></html>");
}
 
 
}
