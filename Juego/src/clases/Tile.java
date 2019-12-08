package clases;

import javafx.scene.canvas.GraphicsContext;
import main.Principal;

public class Tile {
	private int x;
	private int y;
	
	private int altoImagen;
	private int anchoImagen;
	private int xImagen;
	private int yImagen;
	private String indiceImagen;
	
	public Tile(int x, int y, int anchoImagen, int altoImagen, int xImagen, int yImagen, String indiceImagen) {
		super();
		this.x = x;
		this.y = y;
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.indiceImagen = indiceImagen;
	}
	
	public Tile (int tipoTile, int x, int y, String indiceImagen) {
		this.x= x;
		this.y= y;
		this.indiceImagen= indiceImagen;
		
		switch(tipoTile) {
		case 1: 
			this.anchoImagen= 72;
			this.altoImagen= 71;
			this.xImagen= 398;
			this.yImagen= 5;
			break;
			
		case 2:
			this.anchoImagen= 79;
			this.altoImagen= 63;
			this.xImagen= 7;
			this.yImagen= 73;
			break;
			
		case 3:
			this.anchoImagen= 79;
			this.altoImagen= 63;
			this.xImagen= 6;
			this.yImagen= 5;
			break;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAltoImagen() {
		return altoImagen;
	}

	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}

	public int getAnchoImagen() {
		return anchoImagen;
	}

	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}

	public int getxImagen() {
		return xImagen;
	}

	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}

	public int getyImagen() {
		return yImagen;
	}

	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}

	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}

	public void pintarGraficos(GraphicsContext graficos) {
		graficos.drawImage(
				Principal.imagenes.get(this.indiceImagen),
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen, 
				this.x, this.y,
				this.anchoImagen, this.altoImagen
				);
	}
	
}
