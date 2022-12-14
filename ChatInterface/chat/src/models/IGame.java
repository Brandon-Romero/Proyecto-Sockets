package models;

import java.awt.*;

public interface IGame {
	
	Dimension getPosition(); /// posicion de la esfera para identificar cuando choque 
	String getIp(); // traer la ip para el servidor, fotter panel register
	String option(); // para la barra superior
	Color colorSelected(); // cambio de color de la interfaz

}
