import java.awt.*;

/**
	Esta classe representa os jogadores (players) do jogo. A classe princial do jogo (Pong)
	instancia dois objetos deste tipo quando a execução é iniciada.
*/

public class Player {
	private double px, py, largura, altura, velocidade;
	private Color cor;
	private String n;
	private double[] limite = new double[2];
	private boolean up = false;
	private boolean down = false;
	
	
	/**
		Construtor da classe Player.

		@param cx coordenada x da posição inicial do player (centro do retangulo que o representa).
		@param cy coordenada y da posição inicial do player (centro do retangulo que o representa).
		@param width largura do retangulo que representa o player.
		@param height altura do retangulo que representa o player.
		@param color cor do player.
		@param id uma string que identifica o player
		@param v_limit um array de double contendo dois valores (em pixels) que determinam os limites verticais da área útil da quadra.   
		@param speed velocidade do movimento vertical do player (em pixels por millisegundo).
	*/

	public Player(double cx, double cy, double width, double height, Color color, String id, double [] v_limit, double speed){ // O Método é chamado duas vezes, pois cria dois jogadores.
		this.px = cx; // px1 = 80; px2 = 720;
		this.py = cy; // py1 = 300; py2 = 300;
		this.largura = width; // width1 = width2 = 20;
		this.altura = height; // heigth1 = heigth2 = 100;
		this.cor = color;
		this.velocidade = speed; // velocidade1 = velocidade2 = 0.5
		this.limite[0] = v_limit[0]; // Limite = 120
		this.limite[1] = v_limit[1]; // Limite = 580
		this.n = id; // id1 =  "Player 1" ; id2 = "Player 2". 
		
		
		
		
	
	}

	/**
		Método chamado sempre que o player precisa ser (re)desenhado.
	*/

	public void draw(){

		GameLib.setColor(this.cor);
		GameLib.fillRect(this.px, this.py, this.largura, this.altura);
		
	}

	/**
		Método chamado quando se deseja mover o player para cima. 
		Este método é chamado sempre que a tecla associada à ação 
		de mover o player para cima estiver pressionada.

		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/
	
	public void moveUp(long delta){
		/* switch(this.n) {
			case "Player 1":
				if(GameLib.isKeyPressed(6)&& ((this.py - (this.altura / 2)) >= this.limite[0])) this.py -= this.velocidade;
				break;
			case "Player 2":	
				if(GameLib.isKeyPressed(8)&& ((this.py - (this.altura / 2)) >= this.limite[0])) this.py -= this.velocidade;
				break;
		} */
		switch(this.n) {
			case "Player 1":
				if((this.py - (this.altura / 2)) >= this.limite[0]) this.py -= (delta * this.velocidade);
				break;
			case "Player 2":	
				if((this.py - (this.altura / 2)) >= this.limite[0]) this.py -= (delta * this.velocidade);
				break;
		}
	}

	/**
		Método chamado quando se deseja mover o player para baixo. 
		Este método é chamado sempre que a tecla associada à ação 
		de mover o player para baixo estiver pressionada.

		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
		GameLib.isKeyPressed(6) = Letra A!
		GameLib.isKeyPressed(7) = Letra Z!
		GameLib.isKeyPressed(8) = Letra K!
		GameLib.isKeyPressed(9) = Letra M!
	*/
	
	public void moveDown(long delta){
		switch(this.n) {
			case "Player 1":
				if((this.py + (this.altura / 2)) <= this.limite[1]) this.py += (delta * this.velocidade);
				break;
			case "Player 2":	
				if((this.py + (this.altura / 2)) <= this.limite[1]) this.py += (delta * this.velocidade);
				break;
		}
		
	}

	/**
		Método que devolve a string de identificação do player.
		@return a String de indentificação.
	*/

	public String getId() { 

		return this.n; 
	}

	/**
		Método que devolve a largura do retangulo que representa o player.
		@return um double com o valor da largura.
	*/

	public double getWidth() { 

		return this.largura; 
	}

	/**
		Método que devolve a algura do retangulo que representa o player.
		@return um double com o valor da altura.
	*/

	public double getHeight() { 

		return this.altura;
	}

	/**
		Método que devolve a coordenada x do centro do retangulo que representa o player.
		@return o valor double da coordenada x.
	*/

	public double getCx() { 
		if (this.n == "Player 1") return (this.px + 20);
		if (this.n == "Player 2") return (this.px - 20);
		return this.px;
	}

	/**
		Método que devolve a coordenada y do centro do retangulo que representa o player.
		@return o valor double da coordenada y.
	*/

	public double getCy() { 
	
		return this.py;
	}
}

