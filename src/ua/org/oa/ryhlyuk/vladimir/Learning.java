package ua.org.oa.ryhlyuk.vladimir;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Learning
 */
@WebServlet("/Learning")
public class Learning extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int numberOfLetter = 65;
    public static HashMap<Character, Double[]> vocabulary = new HashMap<Character, Double[]>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Learning() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("<html><body><form action=\"Learning\" method = \"post\"> Symbol " +(char)numberOfLetter+"<table border = 1>"
				+ "<tr><td>");
		new Learning().fillBoxes((char)numberOfLetter,pw, false);
		pw.print("</td><td style=\"font-size:60pt\">"+(char)numberOfLetter+"</td></tr></table>"
				+ "<input type=\"submit\" value = \"Next Letter\">"+"</form></body></html>");
		pw.close();
	}

	protected void fillBoxes(char number, PrintWriter pw, boolean flag){
		Double[] checkBox = new Vocabulary().getDefaultVocabulary(number);
		pw.print("<table><tr>");
		for (int i = 0; i < checkBox.length; i++) {
			if(checkBox[i]>0&&flag==false)
				pw.print("<td><input type = \"checkbox\" checked name = \"chkbx"+i+"\" value = \"chkbx"+i+"\" ></td>");
			else
				pw.print("<td><input type = \"checkbox\" name = \"chkbx"+i+"\" value = \"chkbx"+i+"\" ></td>");
			if((i+1)%5==0&&i!=0)
				pw.print("</tr><tr>");
		}
		pw.print("</tr></table>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Double[] letter = new Double[25];
		for (int i = 0; i < 25; i++) {
			if(request.getParameter("chkbx"+i)!=null)
				letter[i]=0.5;
			else 
				letter[i]=-0.5;
			}
	        vocabulary.put((char)numberOfLetter, letter);
	      	if(++numberOfLetter>90)
				response.sendRedirect("Game");
			pw.print("<html><body>");
			pw.print("<form action=\"Learning\" method = \"post\"> Symbol " +(char)numberOfLetter+"<table border = 1>"
					+ "<tr><td>");
			new Learning().fillBoxes((char)numberOfLetter, pw, false);
			pw.print("</td><td style=\"font-size:60pt\">"+(char)numberOfLetter+"</td></tr></table>"
					+ "<input type=\"submit\" value = \"Next Letter\">"+"</form></body></html>");
			pw.close();
	}
	}
