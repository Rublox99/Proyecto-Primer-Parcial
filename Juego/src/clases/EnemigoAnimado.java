package clases;

import java.util.HashMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import main.Principal;

public class EnemigoAnimado extends JugadorAnimado{

	private HashMap<String, Animacion> animacionesEnemigo;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private boolean capturado;
	

	public EnemigoAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super(x, y, indiceImagen, velocidad, animacionActual);
		inicializarAnimacionesEnemigo();
	}
	
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animacionesEnemigo.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public boolean isCapturado() {
		return capturado;
	}				
	
	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
	public void pintar(GraphicsContext graficos) {
			graficos.drawImage(
				Principal.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
	}
	
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, 37, 37);
	}
	
	
	public void inicializarAnimacionesEnemigo() {
		animacionesEnemigo = new HashMap<String, Animacion>();
		Rectangle coordenadasGengar[]= {
				new Rectangle(0,183, 43,49),
				new Rectangle(43,183, 48,49),
				new Rectangle(91, 183, 53,49),	
				new Rectangle(148, 183, 53,49),
		};
		
		Animacion animacionGengar = new Animacion("gengar",coordenadasGengar,0.20);
		animacionesEnemigo.put("gengar",animacionGengar);
		}
	
}
	
