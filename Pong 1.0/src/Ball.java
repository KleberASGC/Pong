import java.awt.*;

/**
	Esta classe representa a bola usada no jogo. A classe princial do jogo (Pong)
	instancia um objeto deste tipo quando a execução é iniciada.
*/

public class Ball {
	private double px, py, largura, altura, velocidade, velocidadeY;
	private Color cor;
	private long tJogo;
	// private double[] campo = [800,600];
	
	/**
		Construtor da classe Ball. Observe que quem invoca o construtor desta classe define a velocidade da bola 
		(em pixels por millisegundo), mas não define a direção deste movimento. A direção do movimento é determinada 
		aleatóriamente pelo construtor.

		@param cx coordenada x da posição inicial da bola (centro do retangulo que a representa).
		@param cy coordenada y da posição inicial da bola (centro do retangulo que a representa).
		@param width largura do retangulo que representa a bola.
		@param height altura do retangulo que representa a bola.
		@param color cor da bola.
		@param speed velocidade da bola (em pixels por millisegundo).
	*/

	public Ball(double cx, double cy, double width, double height, Color color, double speed){ // cx = 400; cy = 300; Width = 20.0; height = 20.0; velocidade = 0.5;
		this.px = cx;
		this.py = cy;
		this.largura = width;
		this.altura = height;
		this.cor = color;
		this.velocidade = speed;
		this.velocidadeY = speed;
		
	
	}


	/**
		Método chamado sempre que a bola precisa ser (re)desenhada.
	*/

	public void draw(){ 

		GameLib.setColor(this.cor);
		GameLib.fillRect(this.px, this.py, this.largura, this.altura);
	}

	/**
		Método chamado quando o estado (posição) da bola precisa ser atualizado.
		
		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/


	public void update(long delta){ 
		this.px +=  (delta * this.velocidade);
		this.py +=  (delta * this.velocidadeY);
		
		
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com um jogador.
	
		@param playerId uma string cujo conteúdo identifica um dos jogadores.
	*/

	public void onPlayerCollision(String playerId){ 
		if (playerId == "Player 1"){
			this.velocidade = (Math.abs(this.velocidade));
		}	
		if (playerId == "Player 2"){ 
			this.velocidade = (- Math.abs(this.velocidade));
		}
	
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com uma parede.

		@param wallId uma string cujo conteúdo identifica uma das paredes da quadra.
	*/

	public void onWallCollision(String wallId){
		 switch(wallId) {
			case "Left":
				this.velocidade = (Math.abs(this.velocidade)); 
				break;
			case "Right":
				this.velocidade = (- Math.abs(this.velocidade));
				break;
			case "Top":
				this.velocidadeY = Math.abs(this.velocidadeY);
				break;
			case "Bottom":
				this.velocidadeY = (- Math.abs(this.velocidadeY));
				break;
		 }
		 
	}

	/**
		Método que verifica se houve colisão da bola com uma parede.

		@param wall referência para uma instância de Wall contra a qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/
	
	public boolean checkCollision(Wall wall){		
		switch(wall.getId()) {
			case "Left":
				if((this.px - (this.largura / 2)) <= wall.getWidth()) { // wall.getWidth() = 20;
				return true;
				} else {
					return false;
				}	
			case "Right":
				if((this.px + (this.largura / 2)) >= (wall.getCx() - (wall.getWidth() / 2))){ // (wall.getCx() - (wall.getWidth() / 2)) = 780;
				return true;
				} else {
					return false;
				}
			case "Top":
				if((this.py - (this.altura / 2)) <= (wall.getCy() + (wall.getHeight() / 2))){ // (wall.getCy() + (wall.getHeight() / 2)) = 120;
					return true;
				} else {
					return false;
				}
			case "Bottom":
				if((this.py + (this.altura / 2)) >= (wall.getCy() - (wall.getHeight() / 2))){ //(wall.getCy() - (wall.getHeight() / 2)) = 580;
					return true;
				} else {
					return false;
				}
		}
		return false;	
	}
	

	/**
		Método que verifica se houve colisão da bola com um jogador.

		@param player referência para uma instância de Player contra o qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/	

	public boolean checkCollision(Player player){
		int aux = (int) this.px;
		switch(player.getId()) {
			case "Player 1":
				if((this.px <= player.getCx()) && (this.px > (player.getCx() - (player.getWidth() / 2))) && (((this.py + (this.altura / 2)) >= player.getCy() - 50) && ((this.py - (this.altura / 2)) <= player.getCy() + 50))) return true;
				break;
			case "Player 2":
				if((this.px >= player.getCx()) && (this.px < (player.getCx() + (player.getWidth() / 2))) && (((this.py + (this.altura / 2)) >= player.getCy() - 50) && ((this.py - (this.altura / 2)) <= player.getCy() + 50))) return true;
				break;
		}
		 /* if(aux == player.getCx() && ((this.py >= player.getCy() - 50) && (this.py <= player.getCy() + 50))) {
			return true;
		} */

		return false;
	}

	/**
		Método que devolve a coordenada x do centro do retângulo que representa a bola.
		@return o valor double da coordenada x.
	*/
	
	public double getCx(){

		return this.px;
	}

	/**
		Método que devolve a coordenada y do centro do retângulo que representa a bola.
		@return o valor double da coordenada y.
	*/

	public double getCy(){

		return this.py;
	}

	/**
		Método que devolve a velocidade da bola.
		@return o valor double da velocidade.

	*/

	public double getSpeed(){

		return this.velocidade;
	}


}
