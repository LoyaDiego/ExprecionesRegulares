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
        listaejer.getItems().addAll("Ejercicio 1","Ejercicio 2","Validar no comienze con db","termine con count","dos nombres","validar MAC","Mayuscula y minuscula","binario de 8 digitos","Hexadecimal","Operacion de un digito","Numero de control","Validar Curp");

    }

    public void procesar(ActionEvent event){
        int seleccion=listaejer.getSelectionModel().getSelectedIndex();
        String texto=txttexto.getText();
        String expresion="";
        switch(seleccion) {
            case 0: {
               expresion=("^[_][^p]([a-zA-z0-9]{3,})[q]$");
                break;
            }
            case 1:{
                expresion=("[a-zA-z]+");
                break;
            }
            case 2:{
                expresion=("[^db][a-zA-Z]+");
                break;
            }
            case 3:{
                expresion=("[a-zA-Z]+(count)$");
                break;
            }
            case 4:{
                expresion=("([a-zA-Z]+)[: :]([a-zA-Z]+)");
                break;
            }
            case 5:{
                expresion=("(([a-zA-Z]+([1-9]))-([a-zA-Z]+([1-9]))-([a-zA-Z]+([1-9]))-([a-zA-Z]+([1-9]))-([a-zA-Z]+([1-9]))-([a-zA-Z]+([1-9])))|((([1-9])[a-zA-Z]+)-(([1-9])[a-zA-Z]+)-(([1-9])[a-zA-Z]+)-(([1-9])[a-zA-Z]+)-(([1-9])[a-zA-Z]+)-(([1-9])[a-zA-Z]+))|(([1-9][1-9])-([1-9][1-9])-([1-9][1-9])-([1-9][1-9])-([1-9][1-9])-([1-9][1-9]))");
                break;
            }
            case 6:{
                expresion=("(^([A-Z]))[a-zA-Z]+([A-Z])$");
                break;
            }
            case 7:{
                expresion=("[0-1][0-1][0-1][0-1][0-1][0-1][0-1][0-1]");
                break;
            }
            case 8:{
                expresion=("([0-9]+)|([a-fA-F]+)|(([0-9]+)([a-fA-F]+))|(([a-fA-F]+)([0-9]+))");
                break;
            }
            case 9:{
                expresion=("[0-9][+|-|*|/][0-9]");
                break;
            }
            case 10:{
                expresion= ("([0-9][0-9])(CG)([0-9]{1,4})");
                break;
            }
            case 11:{
                expresion=("[A-Z][AEIOU][A-Z][A-Z]([0-9]{6})[HM][A-Z][A-Z]([BCDFGHJKLMÑPQRSTVWXYZ]{3})([0-9]|[A-Z])[0-9]");
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
