/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Limitadores;

import javafx.scene.control.Alert;

/**
 *
 * @author Usuario
 */
public class Alertas {
    
    public static void showAlert(String title, String header, String content, Alert.AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
}