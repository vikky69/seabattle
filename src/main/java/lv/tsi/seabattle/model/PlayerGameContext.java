package lv.tsi.seabattle.model;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named // mozhno nazvatj i togda ego nazvanie potom ukazatj, esli ne nazivatj, to po umolchaniju berjot pervij klass i menjaet PlayerGameContext na playerGameContext. Eto u nas ukazano na stranice waitEnemy, 4tobi u waitEnemy bil dostup k etomu java klassu
public class PlayerGameContext implements Serializable{
    private Player player;
    private Game game;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
