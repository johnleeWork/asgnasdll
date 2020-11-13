/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author macbook
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "invalid.html";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String CREATE = "CreateController";
    private static final String REGISTER = "register.jsp";
    private static final String VIEW_LOGIN = "login.jsp";
    private static final String SEARCH = "SearchController";
    private static final String VIEW = "viewCart.jsp";
    private static final String ADD = "AddController";
    private static final String DELETE = "DeleteController";
    private static final String SAVE = "SaveController";
    private static final String DELETE_ROOM = "DeleteRoomController";
    private static final String UPDATE_ROOM = "UpdateRoomController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("btnAction");
            if ("Login".equals(action)) {
                url = LOGIN;
            } else if ("Logout".equals(action)) {
                url = LOGOUT;
            } else if ("Create".equals(action)) {
                url = CREATE;
            } else if ("Register".equals(action)) {
                url = REGISTER;
            } else if ("ViewLogin".equals(action)) {
                url = VIEW_LOGIN;
            } else if ("Search".equals(action)) {
                url = SEARCH;
            } else if ("View".equals(action)) {
                url = VIEW;
            } else if ("Add".equals(action)) {
                url = ADD;
            } else if ("Delete".equals(action)) {
                url = DELETE;
            } else if("Save".equals(action)){
                url = SAVE;
            } else if("DeleteRoom".equals(action)){
                url = DELETE_ROOM;
            } else if("UpdateRoom".equals(action)){
                url = UPDATE_ROOM;
            } else if("LoginFirst".equals(action)){
                url = VIEW_LOGIN;
            }
        } catch (Exception e) {
            log("Error at maincontroller" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
