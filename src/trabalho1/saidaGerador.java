/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

/**
 *
 * @author caiodeqmono
 */
public class saidaGerador {
    
    StringBuffer conteudo;
    int scope;

    public saidaGerador() {
        conteudo = new StringBuffer();
    }

    public void enterScope() {
        scope++;
    }
    
    public void exitScope() {
        scope--;
    }
    
    public void addCommand(String texto) {
        for(int i = 0; i < scope; i++){
            conteudo.append("    ");
        }
        conteudo.append(texto);
    }
    
    public void addCode(String texto){
        conteudo.append(texto);
    }
    
    public void nl() {
        conteudo.append("\n");
    }

    @Override
    public String toString() {
        return conteudo.toString();
    }
}
