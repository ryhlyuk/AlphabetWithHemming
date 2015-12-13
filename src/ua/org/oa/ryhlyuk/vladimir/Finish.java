package ua.org.oa.ryhlyuk.vladimir;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Finish
 */
@WebServlet("/Finish")
public class Finish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Finish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Game.message="adasd";
		pw.print("<html><body><form action=\"Game\" method = \"get\">");
		pw.print(Game.message+"<p>");
		pw.print("If You want to play again, press the button \"Restart game\"<p>");
		Game.numberOfPicture = new LinkedList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26));
		Game.message="";
		pw.print("<input type = \"submit\" name = \"Next\" value = \"Restart game\">");
		pw.print("</form></body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
