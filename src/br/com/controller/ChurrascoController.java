package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.ChurrascoBO;
import br.com.model.ChurrascoModel;

/**
 * Servlet implementation class ChurrascoController
 */
@WebServlet("/ChurrascoController")
public class ChurrascoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChurrascoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao;
		acao = request.getParameter("acao");
		
		
		switch(acao){
			case "insert":
				insert(request,response);
				break;
			case "listAll":
				listAll(request, response);
				break;
			case "listById":
				listById(request, response);
				break;
			case "formAlterar":
				formAlterar(request, response);
				break;
			case "update":
				update(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
		}
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoChurrasco;
		int qtdeChurrasco;
		double valorChurrasco;
		ChurrascoBO churrascoBO = new ChurrascoBO();
		tipoChurrasco = request.getParameter("tipoChurrasco");
		qtdeChurrasco = Integer.parseInt(request.getParameter("qtdeChurrasco"));
		valorChurrasco = Double.parseDouble(request.getParameter("valorChurrasco"));
		churrascoBO.insertChurrasco(new ChurrascoModel(tipoChurrasco, valorChurrasco, qtdeChurrasco));
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void listById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		ChurrascoBO churrascoBO = new ChurrascoBO();
		id = Integer.parseInt(request.getParameter("pesquisar"));
		ChurrascoModel churrasco = churrascoBO.getChurrascoById(id);
		request.setAttribute("churrascoById", churrasco);
		request.getRequestDispatcher("listaChurrasco.jsp").forward(request, response);
	}
	
	protected void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ChurrascoModel> churrascoLista = new ArrayList<ChurrascoModel>();
		ChurrascoBO churrascoBO = new ChurrascoBO();
		churrascoLista = churrascoBO.getAllChurrasco();
		request.setAttribute("churrascoLista", churrascoLista);
		request.getRequestDispatcher("listaChurrasco.jsp").forward(request, response);
	}
	
	protected void formAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		ChurrascoBO churrascoBO = new ChurrascoBO();
		id = Integer.parseInt(request.getParameter("idChurrasco"));
		ChurrascoModel filter = churrascoBO.getChurrascoById(id);
		request.setAttribute("idChurrasco", filter.getId_churrasco());
		request.setAttribute("tipoChurrasco", filter.getTipoChurrasco());
		request.setAttribute("qtdeChurrasco", filter.getQtdeChurrasco());
		request.setAttribute("valorChurrasco", filter.getValorChurrasco());
		//churrascoBO.updateChurrascoById(new ChurrascoModel(tipoChurrasco, valorChurrasco, qtdeChurrasco, id));
		request.getRequestDispatcher("formAlterarChurrasco.jsp").forward(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoChurrasco;
		int qtdeChurrasco, id;
		double valorChurrasco;
		ChurrascoBO churrascoBO = new ChurrascoBO();
		tipoChurrasco = request.getParameter("tipoChurrasco");
		qtdeChurrasco = Integer.parseInt(request.getParameter("qtdeChurrasco"));
		valorChurrasco = Double.parseDouble(request.getParameter("valorChurrasco"));
		id = Integer.parseInt(request.getParameter("idChurrasco"));
		ChurrascoModel novo = new ChurrascoModel(tipoChurrasco, valorChurrasco, qtdeChurrasco, id);
		churrascoBO.updateChurrascoById(novo);
		listAll(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		ChurrascoBO churrascoBO = new ChurrascoBO();
		id = Integer.parseInt(request.getParameter("idChurrasco"));
		churrascoBO.deleteChurrasco(id);
		listAll(request, response);
	}
}
