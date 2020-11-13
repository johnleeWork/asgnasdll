/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.controller;

import dat.daos.UserDAO;
import dat.dto.UserDTO;
import dat.dto.UserErrorDTO;
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
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "login.jsp";

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
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
            String fullName = request.getParameter("txtFullName");
            String gender = request.getParameter("cmbGender");
            String email = request.getParameter("txtEmail");
            String confirm = request.getParameter("txtConfirmPassword");

            boolean flag = true;
            UserErrorDTO error = new UserErrorDTO();
            if (userID.isEmpty()) {
                error.setUserIDError("User ID can not empty!");
                flag = false;
            }
            if (password.isEmpty()) {
                error.setPasswordError("Password can not empty!");
                flag = false;
            }
            if (fullName.isEmpty()) {
                error.setFullNameError("Full name can not empty!");
                flag = false;
            }
            if (gender.equals("")) {
                error.setGenderError("Please choose your gender!");
                flag = false;
            }

            if (!email.matches("^[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z]*[.]?[a-z]*[.]?[a-z]*?$")) {
                error.setEmailError("Email invalid!");
                flag = false;
            }
            if (!password.equals(confirm)) {
                error.setConfirmError("Those passwords didn't match. Try again.");
                flag = false;
            }
            if (flag) {
                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(userID, password, fullName, gender, email, "user");
                int result = dao.create(user);
                if (result != -1) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ERROR", error);
            }
        } catch (Exception e) {
            log("Error at RegisterController " + e.toString());
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
