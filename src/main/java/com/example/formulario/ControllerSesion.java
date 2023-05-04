package com.example.formulario;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerSesion {

    @FXML
    private Label textoInicio;

    @FXML
    protected void mostrarNombre(String nombre, String apellidos){
        textoInicio.setText("Bienvenido: " + nombre + " " + apellidos);
    }
}
