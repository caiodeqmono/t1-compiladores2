/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.util.ArrayList;

/**
 *
 * @author caiodeqmono
 */
public class Formatador {
    
    public static String tipo(String tipo){
        switch(tipo){
            case "inteiro":
                tipo = "int";
                break;
            case "^inteiro":
                tipo = "int*";
                break;
            case "real":
                tipo = "float";
                break;
            case "literal":
                tipo = "char";
                break;
            case "logico":
                tipo = "int";
                break;
            default:
        }
        return tipo;
    }
    
    public static String ioFormat(String tipo){
        String format = null;
        
        switch(tipo){
            case "int":
                format = "%d";
                break;
            case "float":
                format = "%f";
                break;
            case "char":
                format = "%s";
                break;
            default:
        }
        return format;
    }
    
    public static String format(String texto){
        texto = texto.replace("=", "==");
        texto = texto.replace("<-", "=");
        texto = texto.replace("nao", "!");
        texto = texto.replace("^", "*");
        return texto;
    }
    
}
