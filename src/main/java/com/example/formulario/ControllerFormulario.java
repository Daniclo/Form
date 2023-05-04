package com.example.formulario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class ControllerFormulario {
    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private ColorPicker color;

    @FXML
    private DatePicker fecha;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Label textoError;

    @FXML
    protected void onClickGuardaDatos(ActionEvent event) throws IOException {
        String guardaNombre = nombre.getText();
        String guardaApellido = apellidos.getText();
        String guardaColor = String.valueOf(color.getValue());
        String guardaFecha = String.valueOf(fecha.getValue());
        File f = new File("src/main/resources/com/example/formulario/datos.txt");
        FileWriter salida = new FileWriter(f);
        salida.write(guardaNombre + "\n" + guardaApellido + "\n" + guardaColor + "\n" + guardaFecha);
        salida.close();
        root = FXMLLoader.load((AppFormulario.class.getResource("Fin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onClickIniciarSesion(ActionEvent event){
        try {
            File f = new File("src/main/resources/com/example/formulario/datos.txt");
            Scanner leer = new Scanner(f);
            String guardarNombre = leer.nextLine();
            String guardarApellidos = leer.nextLine();
            FXMLLoader loader = new FXMLLoader(AppFormulario.class.getResource("Sesion.fxml"));
            root = loader.load();
            ControllerSesion controllerSesion = loader.getController();
            controllerSesion.mostrarNombre(guardarNombre,guardarApellidos);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            textoError.setText("Error, no se encontraron datos de inicio de sesión");
        }
    }
}