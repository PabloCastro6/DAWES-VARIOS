package com.pablo.foreachapp.controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pablo.foreachapp.bean.ComboDTO;
import com.pablo.foreachapp.bean.Persona;

@WebServlet("/obtenpersonas")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		listaPersonas.add( new Persona("Pepe", 2000));
		listaPersonas.add(new Persona("kike",100000));
		listaPersonas.add(new Persona("Juanita",5000));
		listaPersonas.add(new Persona("Pablo",3000));
		
		request.setAttribute("personas", listaPersonas);
		
		
		List<ComboDTO> listaProvincias = new ArrayList<ComboDTO>();
		ComboDTO c1 = new ComboDTO(1, "Alicante");
		ComboDTO c2 = new ComboDTO(2, "Bizkaia");
		ComboDTO c3 = new ComboDTO(3, "Salamanca");
		
		listaProvincias.add(c1);
		listaProvincias.add(c2);
		listaProvincias.add(c3);
		
		request.setAttribute("listaProvincias", listaProvincias);
		
		RequestDispatcher dispachador = getServletContext().getRequestDispatcher("/WEB-INF/vistas/lista.jsp");
		dispachador.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
