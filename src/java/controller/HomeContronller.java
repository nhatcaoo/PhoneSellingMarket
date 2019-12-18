/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.CatalogueModel;
import Model.NumberPagination;
import Model.ProductModel;
import dal.DataDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author This PC
 */
public class HomeContronller extends HttpServlet {

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
//        try {
//              /* TODO output your page here. You may use following sample code. */
//            List<CatalogueModel> catalogues = new ArrayList<>();
//           
//            List<ProductModel> products = new ArrayList<>();
//            DataDAO daoProduct = new DataDAO();
//            //catalogues = daoProduct.get
//            int page = 1;
//            try {
//                page = Integer.parseInt(request.getParameter("page"));
//            } catch (Exception e) {
//                page = 1;
//            }
//            int tempPageNumber = daoProduct.getNumberProduct();//lay so san pham
//            int numberOfPage = tempPageNumber / 5;
//            if (tempPageNumber % 5 != 0) {
//                numberOfPage++;
//            }
//            int temp = 5 * page - 4;
//
//            products = daoProduct.getProduct();   
//            request.setAttribute("Products", products);
//            request.setAttribute("Page", page);
//            request.setAttribute("NumberOfPage", numberOfPage);
//            getServletContext().getRequestDispatcher("/PhoneSellingMarket/Web-Content/OverView.jsp").forward(request, response);
//        } catch (Exception e) {
//            System.out.println(e);
//            response.sendRedirect("ErrorPage.jsp");
//        }
//        
//    }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                String text = (String) request.getParameter("CurrentPage");
                if (text == null) {
                    text = "1";
                }
                ArrayList<ProductModel> products;
                int currentPage = Integer.parseInt(text);
                int totalPage;
                ArrayList<NumberPagination> arrNumPagin = new ArrayList<NumberPagination>();
                if (currentPage > 0) {
                    DataDAO dataController = new DataDAO();
                    int tempPageNumber = dataController.getNumberProduct();
                    int numberOfPage = tempPageNumber / 5;
                    if (tempPageNumber % 5 != 0) {
                        numberOfPage++;
                    }
                    int temp = 5 * currentPage - 4;
                  
                    products = dataController.getProduct(currentPage);
                    if (!products.isEmpty()) {
                        for (int i = 1; i <= numberOfPage; i++) {
                            if (i == currentPage) {
                                arrNumPagin.add(new NumberPagination(1, Integer.toString(i)));
                            } else {
                                arrNumPagin.add(new NumberPagination(2, Integer.toString(i)));
                            }
                        }
                    }
                    request.setAttribute("Products", products);
                    request.setAttribute("arrNumPagination", arrNumPagin);
                    request.getRequestDispatcher("/Web-Content/OverView.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.getRequestDispatcher("/Web-Content/Error.jsp").forward(request, response);
            }
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
