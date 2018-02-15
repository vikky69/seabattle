package lv.tsi.seabattle.controller;

import lv.tsi.seabattle.model.PlayerGameContext;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "StateFilter", urlPatterns = "/*")
public class StateFilter implements Filter {
    @Inject
    private PlayerGameContext playerGameContext;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;//servletresponse - roditelj httresponsa. http response extends servletresponse; mi perepisivaem peremennuju.
        HttpServletRequest request = (HttpServletRequest) req;

        String path = request.getServletPath();

        if (playerGameContext.getGame()==null &&
                !path.equals("/register")) {             //esli igra ne zapuwena, i mi ne na stranice registracii, to mozhno zaxoditj toljko na stranicu registracii, na drugie neljzja. esli budut kartinki, css i jsp, to ix nado tozhe tut propisatj, naprimer path.endsWith(".png")
            response.sendRedirect("register");
        }else if (playerGameContext.getGame()!= null
                && playerGameContext.getGame().isCancelled()){
            request.getSession().invalidate();
        }else


        {


            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
