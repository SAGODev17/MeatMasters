/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergio
 */
public class SoloMayusculas {

    
   
    public void may(java.awt.event.KeyEvent evt, char e) {
        if (Character.isLowerCase(e)) {
            String cad = ("" + e).toUpperCase();
            e = cad.charAt(0);
            evt.setKeyChar(e);
        }
    }

    public void min(java.awt.event.KeyEvent evt, char e) {
        if (Character.isUpperCase(e)) {
            String cad = ("" + e).toLowerCase();
            e = cad.charAt(0);
            evt.setKeyChar(e);
        }
    }
          
    public void num (java.awt.event.KeyEvent evt, char   key){

    boolean numeros = key >= 48 && key <= 57;
        
    if (!numeros)
    {
        evt.consume();
    }

    }
        
     public void notNum (java.awt.event.KeyEvent evt, char   key){

    boolean numeros = key >= 48 && key <= 57;
        
    if (numeros)
    {
        evt.consume();
    }

    }
     
     
     public boolean validarCorreo(String correo) {
        // Patrón para validar correos electrónicos
        String patronCorreo = "^[A-Za-z0-9+_.-]+@(.+)$";
        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(patronCorreo);
        // Crear un objeto Matcher para el correo
        Matcher matcher = pattern.matcher(correo);
        // Verificar si el correo coincide con el patrón
        return matcher.matches();
    }
     
     
     
     
}

     




