package lv.tsi.seabattle.controller;

import lv.tsi.seabattle.model.Game;
import lv.tsi.seabattle.model.GameManager;
import lv.tsi.seabattle.model.Player;
import lv.tsi.seabattle.model.PlayerGameContext;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Inject
    private PlayerGameContext playerGameContext; //vstavljaet ispoljzovanie nuzhnogo klassa, a s nego nuzhnuju sessiju
    @Inject
    private GameManager gameManager; //

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("player-name");
        System.out.println("Player:" + name);
        Player player = new Player();
        player.setName(name);

        playerGameContext.setPlayer(player);

        Game game = gameManager.register(player);
        playerGameContext.setGame(game);




        response.sendRedirect("waitEnemyRegister");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("/WEB-INF/register.jsp").include(request, response);

    }
}
