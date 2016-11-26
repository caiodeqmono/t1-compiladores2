/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import org.antlr.v4.runtime.RuleContext;

/**
 *
 * @author caiodeqmono
 */
public class AnalisadorSemantico extends gramaticaLABaseVisitor<Void> {  
    PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
//    TabelaDeSimbolos ts = new TabelaDeSimbolos("declaracao local");
    saidaParser sp = new saidaParser(1);

    public AnalisadorSemantico(saidaParser sp) {
        this.sp = sp;
    }

    @Override
    public Void visitPrograma(gramaticaLAParser.ProgramaContext ctx) {
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));
        super.visitPrograma(ctx); //To change body of generated methods, choose Tools | Templates.
        pilhaDeTabelas.desempilhar();
        return null;
    }
  
    
    
    @Override
    public Void visitDeclaracao_local(gramaticaLAParser.Declaracao_localContext ctx) {
        if(ctx.variavel() != null) {
            String nomeVar = ctx.variavel().IDENT().getText();
            if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
            }
            else{
                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, "VARIAVEL");
            }
            
            gramaticaLAParser.Mais_varContext auxCtx = ctx.variavel().mais_var();
            //adiciona mais_vars enquanto houver mais_vars
            while(auxCtx.IDENT() != null) {
                nomeVar = auxCtx.IDENT().getText();
                if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                    sp.println("Linha "+auxCtx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
                }
                else{
                    pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, "VARIAVEL");
                }
                auxCtx = auxCtx.mais_var();
            }
        }
        
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitIdentificador(gramaticaLAParser.IdentificadorContext ctx) {
        if(!pilhaDeTabelas.existeSimbolo(ctx.IDENT().getText())){
            sp.println("Linha " +ctx.IDENT().getSymbol().getLine()+ ": identificador " +ctx.IDENT().getText()+ " nao declarado");
        }
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitTipo_basico_ident(gramaticaLAParser.Tipo_basico_identContext ctx) { 
        if(ctx.IDENT() != null){
            if(!pilhaDeTabelas.topo().existeSimbolo(ctx.getText()))
                sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": tipo " + ctx.IDENT().getText() + " nao declarado");
        }
        super.visitChildren(ctx);
        return null;
    }
    
}
