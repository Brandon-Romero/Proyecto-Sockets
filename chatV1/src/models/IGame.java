package models;

import java.awt.*;
import java.net.UnknownHostException;

public interface IGame {
	String getIp() throws UnknownHostException; // traer la ip para el servidor, fotter panel register

	String getTittLeClient();

	String getTittLeServer();
}
