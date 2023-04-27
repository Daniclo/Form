package com.example.formulario;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class HelloController {
    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private ColorPicker color;

    @FXML
    private DatePicker fecha;

    @FXML
    protected void onClickGuardaDatos() throws IOException {
        String guardaNombre = nombre.getText();
        String guardaApellido = apellidos.getText();
        String guardaColor = String.valueOf(color.getValue());
        String guardaFecha = String.valueOf(fecha.getValue());
        File f = new File("C:\\Users\\Daniel\\Desktop\\datos.txt");
        FileWriter salida = new FileWriter(f);
        salida.write("Nombre: " + guardaNombre + "\nApellidos: " + guardaApellido + "\nColor favorito: " + guardaColor + "\nFecha de nacimiento: " + guardaFecha);
        salida.close();
    }
}