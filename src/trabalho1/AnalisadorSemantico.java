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
        String nomeVar;
        String tipoVar;
        //caso: 'constante' IDENT ':' tipo_basico '=' valor_constante
        if(ctx.tipo_basico() != null){
            nomeVar = ctx.IDENT().getText();
            tipoVar = ctx.tipo_basico().getText();
            if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
            }
            else{
                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
            }
        }
        //caso: 'tipo' IDENT ':' tipo;
        if(ctx.tipo() != null){
            nomeVar = ctx.IDENT().getText();
            //ja eh feita a verificacao se existe ou nao o IDENT do tipo
            tipoVar = ctx.tipo().getText();
            
            if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
            }
            else{
                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
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
            if(!pilhaDeTabelas.existeSimbolo(ctx.IDENT().getText()))
                sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": tipo " + ctx.IDENT().getText() + " nao declarado");
        }
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitParcela(gramaticaLAParser.ParcelaContext ctx) { 
        String nomeVar;

        //caso: op_unario parcela_unario
        if(ctx.parcela_unario() != null){  
            //caso: '^' IDENT outros_ident dimensao | IDENT chamada_partes
            if(ctx.parcela_unario().IDENT() != null){
                nomeVar = ctx.parcela_unario().IDENT().getText();
                if(!pilhaDeTabelas.existeSimbolo(nomeVar)){
                    sp.println("Linha "+ctx.parcela_unario().IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
                }
            }
        }
        //caso: parcela_nao_unario
        if(ctx.parcela_nao_unario() != null){
            //caso: '&' IDENT outros_ident dimensao
            if(ctx.parcela_nao_unario().IDENT() != null){
                nomeVar = ctx.parcela_unario().IDENT().getText();
                if(!pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                    sp.println("Linha "+ctx.parcela_unario().IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
                }
            }
        }
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitDeclaracao_global(gramaticaLAParser.Declaracao_globalContext ctx) { 
        //ambos casos tem somente um IDENT
        String nomeVar = ctx.IDENT().getText();
        
        String tipoVar;
        //caso: procedimento
        if(ctx.tipo_estendido() == null){
            tipoVar = "procedimento";
        }
        //caso: funcao
        else{
            //caso IDENT
            if(ctx.tipo_estendido().tipo_basico_ident().IDENT() != null){
                tipoVar = ctx.tipo_estendido().tipo_basico_ident().IDENT().getText();
            }
            //caso tipo_basico
            else{
                tipoVar = ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText();
            }
        }
        if(pilhaDeTabelas.existeSimbolo(nomeVar)){
           sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
        }
        else{
            pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
        }
        
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitVariavel(gramaticaLAParser.VariavelContext ctx) { 
        String nomeVar = ctx.IDENT().getText();
        String tipoVar = ctx.tipo().getText();
        if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
            sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
        }
        else{
            pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
        }
        
        //caso tenha mais_vars com IDENT (precisa ser no visitorVariavel para poder pegar o tipo)
        gramaticaLAParser.Mais_varContext auxCtx = ctx.mais_var();
        while(auxCtx.IDENT() != null) {
            nomeVar = auxCtx.IDENT().getText();
            if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                sp.println("Linha "+auxCtx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
            }
            else{
                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
            }
            auxCtx = auxCtx.mais_var();
        }
        
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitCmd(gramaticaLAParser.CmdContext ctx) { 
        //caso tenha IDENT
        if(ctx.IDENT() != null){
            String nomeVar = ctx.IDENT().getText();
            if(!pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
            }
        }
        super.visitChildren(ctx);
        return null;
    }
}
