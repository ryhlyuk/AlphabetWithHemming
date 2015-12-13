package ua.org.oa.ryhlyuk.vladimir;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected static LinkedList<Integer> numberOfPicture = new LinkedList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26));
    int index;
    static String message ="";
    
    
    public Game() {
    	super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (numberOfPicture.size()<=1) {
			response.sendRedirect("Finish");
		}
		PrintWriter pw = response.getWriter();
		pw.print("<html><body><form action=\"Game\" method = \"post\">");
		index = (int)(Math.random()*(numberOfPicture.size()-1));
		index = numberOfPicture.get(index);
		pw.print("<img src = \""+index+".png\"> "+message);
		new Learning().fillBoxes('A', pw, true);
		pw.print("<input type = \"submit\" name = \"Next\" value = \"Next Image\">");
		pw.print("</form></body></html>");
		numberOfPicture.remove(numberOfPicture.indexOf(index));
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double[] letter = new Double[25];
		for (int i = 0; i < 25; i++) {
			if(request.getParameter("chkbx"+i)!=null)
				letter[i]=1.0;
			else 
				letter[i]=-1.0;
			}
		boolean flag = new HemmingAlgo().HemmingAlgorithm(letter,index);
		
		if(flag)
			response.sendRedirect("Game");
	}

}
