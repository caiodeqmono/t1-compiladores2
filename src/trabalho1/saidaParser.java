/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

public class saidaParser {

    StringBuffer conteudo;
    boolean modificado;
    int tipo;

    public saidaParser(int t) {
        conteudo = new StringBuffer();
        tipo = t;
        if(tipo == 0)
            modificado = false;
    }

    public void println(String texto) {
        if(tipo == 0){
            if(!modificado) { 
                modificado = true;
                conteudo.append(texto+"\n");
            }
        }
        else{
            conteudo.append(texto+"\n");
        }
    }
    
    public void close(){
        conteudo.append("Fim da compilacao\n");
    }
    
    public boolean isModificado() {
        return modificado;
    }

    @Override
    public String toString() {
        return conteudo.toString();
    }
}