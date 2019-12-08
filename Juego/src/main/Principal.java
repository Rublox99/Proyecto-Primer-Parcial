package main;

import java.util.ArrayList;
import java.util.HashMap;

import clases.EnemigoAnimado;
import clases.ItemAnimado;
import clases.JugadorAnimado;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Principal extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private JugadorAnimado jugadorAnimado;
	private EnemigoAnimado enemigoAnimado;
	private ItemAnimado monedaAnimada;
	private ItemAnimado aguaAnimada;
	private int numeroAleatorioX= (int)(Math.random()*(100-670+1) + 670);
	//int numero = (int)(Math.random()*(X-Y+1)+Y; para intervarlo entre X y Y
	private int numeroAleatorioY= (int)(Math.random()*(260-400+1) + 400);
	
	private int numeroAleatorioX2= (int)(Math.random()*(100-670+1) + 670);
	private int numeroAleatorioY2= (int)(Math.random()*(260-380+1) + 380);

	private int numeroAleatorioX3= (int)(Math.random()*(200-670+1) + 670);
	private int numeroAleatorioY3= (int)(Math.random()*(260-380+1) + 380);
	
	//private Item monedaAnimada;
	
	public static HashMap<String, Image> imagenes; 
	private ArrayList<Tile> tiles;
	
	private int[][] mapa= {
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},
			{0,0,0,1,1, 1, 1,1},

	};
	
	
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	
	private int x= 700;
	private int y= 425;
	

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos= canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("Runnin Bolt");
		gestionarEventos();
		ventana.show();
		cicloJuego();
	}
	
	public void inicializarComponentes() {
		jugadorAnimado= new JugadorAnimado(0, 300, "pikachu", 3, "descanso");
		enemigoAnimado= new EnemigoAnimado(numeroAleatorioX3, numeroAleatorioY3,"gengar", 0, "gengar");
		monedaAnimada= new ItemAnimado(numeroAleatorioX, numeroAleatorioY,"moneda", 0, "moneda");
		aguaAnimada= new ItemAnimado(numeroAleatorioX2, numeroAleatorioY2,"agua", 0, "agua");
		
		//monedaAnimada= new Item(300, 300, "moneda", "girar");
		
		root= new Group();
		escena= new Scene(root, x, y);
		canvas= new Canvas(x, y);
		//moneda = new Item(numeroAleatorioX, numeroAleatorioY,"moneda");
		//agua = new Item(numeroAleatorioX2,numeroAleatorioY2,"agua");
		//221, 345
		imagenes= new HashMap<String, Image>();
		
		cargarImagenes();
		cargarTiles();
		
	}
	
	public void cargarImagenes() {
		imagenes.put("pikachu", new Image("pikachu.png"));
		imagenes.put("terreno", new Image("terreno.png"));
		imagenes.put("fondo", new Image("fondo.png"));
		imagenes.put("arboles", new Image("arboles.png"));
		imagenes.put("moneda", new Image("moneda.png"));
		imagenes.put("agua", new Image("agua.png"));
		imagenes.put("puntos", new Image("puntos.png"));
		imagenes.put("gengar", new Image("gengar.png"));
	}
	
	public void cargarTiles() {
		tiles= new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*72, j*71, "terreno"));
			}
		}
		
		
	}
	
	public void pintarFondo() {
		graficos.setFill(Color.WHITE);
		graficos.fillRect(0, 0, x, y);
		graficos.setFill(Color.BLACK);
		graficos.drawImage(new Image("fondo.png"), 0,-100);
		graficos.drawImage(imagenes.get("puntos"), 10, 5);
		graficos.drawImage(new Image("vidaEjemplo.png"), 4, 10);
		
		for (int i=0;i<tiles.size();i++)
			tiles.get(i).pintarGraficos(graficos);
		
		
		for(int i=0; i<10; i++) 
			graficos.drawImage(imagenes.get("arboles"), i*71, 160);//("arboles.png", i*71, 160);
		
		enemigoAnimado.pintar(graficos);
		monedaAnimada.pintar(graficos);
		aguaAnimada.pintar(graficos);

		jugadorAnimado.pintar(graficos);
	}

	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "D": //derecha
							jugadorAnimado.setAnimacionActual("correr");
							derecha=true;
							break;
						case "A": //izquierda
							jugadorAnimado.setAnimacionActual("correr");
							jugadorAnimado.setVelocidad(2);		
							izquierda=true;
						break;
						case "W":
							jugadorAnimado.setAnimacionActual("correr");
							arriba=true;
							break;
						case "S":
							jugadorAnimado.setAnimacionActual("correr");
							abajo=true;
							break;
						case "SPACE":
							if(izquierda) {
							jugadorAnimado.setVelocidad(2);
							}
							else {
							jugadorAnimado.setVelocidad(5);
								}
							break;
					}
			}			
		});
		
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "D": //derecha
					if(izquierda|| arriba || abajo){
						jugadorAnimado.setAnimacionActual("correr");
					}
					else
						jugadorAnimado.setAnimacionActual("descanso");
					derecha=false;
					break;
				case "A": //izquierda
					if(derecha || arriba || abajo){
						jugadorAnimado.setAnimacionActual("correr");
					}
					else
						jugadorAnimado.setAnimacionActual("descanso");
					izquierda=false;
				break;
				case "W":
					if(izquierda || derecha || abajo)
						jugadorAnimado.setAnimacionActual("correr");
					else
						jugadorAnimado.setAnimacionActual("descanso");
					arriba=false;
					break;
				case "S":
					if(derecha || izquierda || arriba)
						jugadorAnimado.setAnimacionActual("correr");
					else
						jugadorAnimado.setAnimacionActual("descanso");
					abajo=false;
					break;
				case "SPACE":
					if(izquierda) 
						jugadorAnimado.setVelocidad(2);
					
					else 
						jugadorAnimado.setVelocidad(3);
					
					break;
			}
				
			}
			
		});
		
	
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintarFondo();
				actualizar(t);
				
			}
			
		};
		animationTimer.start(); //Inicia el ciclo
	}
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		enemigoAnimado.actualizarAnimacion(t);
		monedaAnimada.actualizarAnimacion(t);
		aguaAnimada.actualizarAnimacion(t);
		
		jugadorAnimado.verificarColisiones(aguaAnimada);
		jugadorAnimado.verificarColisiones(monedaAnimada);
		jugadorAnimado.verificarColisiones(enemigoAnimado);
		
	}
	
	
}
