package lv.tsi.seabattle.model;

public class Game {
    private Player player1;
    private Player player2;
    private boolean player1Move = true;

    public Player getCurrentPlayer(){
        if (player1Move==true) {
            return player1;
        }else{
            return player2;
        }
    }

    public Player getOppositePlayer(){

        //return player1Move ? player2:player1;
        if (player1Move==true) {
            return player2;
        }else{
            return player1;
        }
    }



    public boolean isComplete(){
        return player1 !=null && player2 !=null; // eto virazhenie - true.
    }

    public boolean isReadyToStart() {
        return isComplete() && player1.isReady() && player2.isReady();
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void fire(String addr) {
        CellContent c= getOppositePlayer().getMyField().getCell(addr);
        if (c == CellContent.SHIP){
            getOppositePlayer().getMyField().setCell (addr, CellContent.HIT); //esli drugoj igrok popal v moj korablj
            getCurrentPlayer().getEnemyField().setCell(addr, CellContent.HIT); //esli ti popal v ego korablj
            return;
        }

        if (c == CellContent.EMPTY){
            getOppositePlayer().getMyField().setCell (addr, CellContent.MISS); //esli drugoj igrok popal v moj korablj
            getCurrentPlayer().getEnemyField().setCell(addr, CellContent.MISS); //esli ti popal v ego korablj

        }

        player1Move = !player1Move; //xod perexodit k drugomu igroku
    }
}
