/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 727334
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logout = request.getParameter("logout");
        HttpSession session = request.getSession();
        if(logout != null){
            request.setAttribute("logoutMessage", "Logged Out");
             // forward the request back to index.jsp
            session.removeAttribute("username");
            session.removeAttribute("items");
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
        }else if(session.getAttribute("username") != null){
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String item = request.getParameter("item");
        HttpSession session = request.getSession();
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                session.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                break;
            case "add":

                

                if (items != null) {
                    items.add(item);
                    session.setAttribute("items", items);
                }else{
                    items = new ArrayList<String>();
                    items.add(item);
                    session.setAttribute("items", items);
                }
                

                break;
            case "delete":
                
                String list = request.getParameter("list");
                if (list != null) {
                    items.remove(Integer.parseInt(list));
                    session.setAttribute("items", items);
                }
                break;
            case "logout":
                break;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

    }

}
