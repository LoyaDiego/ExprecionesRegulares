package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    @FXML
    TextField txttexto;
    @FXML
    ListView listaejer;
    @FXML
    Label lblres;
    @FXML protected void initialize(){
        listaejer.getItems().addAll("Ejercicio 1","Ejercicio 2");

    }

    public void procesar(ActionEvent event){
        int seleccion=listaejer.getSelectionModel().getSelectedIndex();
        String texto=txttexto.getText();
        String expresion="";
        switch(seleccion) {
            case 0: {
               expresion=("^[^_][^p]([a-zA-z0-9]{3,})[q]$");
                break;
            }
            case 1:{
                expresion=("[a-zA-z]+");
                break;
            }
        }

        Pattern patron=Pattern.compile(expresion);
        Matcher matcher=patron.matcher(texto);
        if (matcher.matches()){
            lblres.setText("Si se pudo");
        }else {
            lblres.setText("No se pudo :(");
        }
    }

}
