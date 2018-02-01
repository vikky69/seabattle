package lv.tsi.seabattle.controller;

import lv.tsi.seabattle.model.PlayerGameContext;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WaitEnemyRegisterServlet", urlPatterns = "/waitEnemyRegister")
public class WaitEnemyRegisterServet extends HttpServlet {
    @Inject
    private PlayerGameContext playerGameContext;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (playerGameContext.getGame().isComplete()) { //esli oba igroka zawli, isComplete=true
response.sendRedirect("shipPlacement");
        } else { //esli ne zawli, pokazivaetsja waitpage
            request.getRequestDispatcher("/WEB-INF/waitEnemyRegister.jsp").include(request, response);
        }
    }
}