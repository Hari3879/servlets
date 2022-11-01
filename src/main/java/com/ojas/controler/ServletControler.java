package com.ojas.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.Dao.ProductDao;
import com.ojas.Dao.ProductDaoImpl;
import com.ojas.model.Products;

/**
 * Servlet implementation class ServletControler
 */


public class ServletControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ProductDao dao = new ProductDaoImpl();
		Products p = new Products();
		p.setPid(Integer.parseInt(request.getParameter("pid")));
		p.setPname(request.getParameter("pname"));
		p.setQty(Integer.parseInt(request.getParameter("qty")));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		String message = dao.createProduct(p);
		if(message!=null) {
			out.println("<h2 style=color:green>"+message+"</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("./index.html");
			rd.include(request, response);
		}else {
			out.println("<h2 style=color:red>"+message+"</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("./index.html");
			rd.include(request, response);
		}
	}
	
	


	

}
