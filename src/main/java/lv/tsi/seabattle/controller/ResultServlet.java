package lv.tsi.seabattle.controller;

import lv.tsi.seabattle.model.Game;
import lv.tsi.seabattle.model.PlayerGameContext;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    @Inject
    private PlayerGameContext playerGameContext;

    @Inject
    private Game game;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(playerGameContext.getPlayer().isWinner()){
            request.getRequestDispatcher("/WEB-INF/winner.jsp")
            .include(request, response);
        }else request.getRequestDispatcher("/WEB-INF/looser.jsp")
                .include(request, response);
    }
}
