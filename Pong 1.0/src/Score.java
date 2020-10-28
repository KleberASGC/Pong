import java.awt.*;

/**
	Esta classe representa um placar no jogo. A classe princial do jogo (Pong)
	instancia dois objeto deste tipo, cada um responsável por gerenciar a pontuação
	de um player, quando a execução é iniciada.
*/

public class Score {
	private String jogadorId;
	private int placar;
	/**
		Construtor da classe Score.

		@param playerId uma string que identifica o player ao qual este placar está associado.
	*/

	public Score(String playerId){
	this.jogadorId = playerId; // playerId1 = "Player 1"; playerId2 = "Player 2";
	this.placar = 0;
	}

	/**
		Método de desenho do placar.
	*/

	public void draw(){
		if (this.jogadorId == "Player 1") {
			GameLib.setColor(Color.GREEN);
			GameLib.drawText(this.jogadorId + ": " + this.placar, 70, GameLib.ALIGN_LEFT);
		}
		if (this.jogadorId == "Player 2"){
			GameLib.setColor(Color.BLUE);
			GameLib.drawText(this.jogadorId + ": " + this.placar, 70, GameLib.ALIGN_RIGHT);
		}
				
	}

	/**
		Método que incrementa em 1 unidade a contagem de pontos.
	*/

	public void inc(){
		this.placar++;
	}

	/**
		Método que devolve a contagem de pontos mantida pelo placar.

		@return o valor inteiro referente ao total de pontos.
	*/

	public int getScore(){

		return this.placar;
	}
}
