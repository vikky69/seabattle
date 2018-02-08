package lv.tsi.seabattle.controller;

import lv.tsi.seabattle.model.Field;
import lv.tsi.seabattle.model.Player;
import lv.tsi.seabattle.model.PlayerGameContext;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShipPlacementServlet", urlPatterns = "/shipPlacement")
public class ShipPlacementServlet extends HttpServlet {
    @Inject
    private PlayerGameContext playerGameContext;





    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String[] addresses = request.getParameterValues("addr");
        Player p =playerGameContext.getPlayer();
        Field f = p.getMyField();

        f.clear();
        if (addresses != null) {
            for (String a : addresses) {
                f.setShip(a);
            }
        }

        f.validate();

        if (f.isInvalid()) {
            request.getRequestDispatcher("/WEB-INF/shipPlacement.jsp")
                    .include(request, response);
        } else {
            p.setReady(true);
            response.sendRedirect("waitEnemyPlacement");
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/shipPlacement.jsp")
                .include(request, response);
    }
}
