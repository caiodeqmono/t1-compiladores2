/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.util.ArrayDeque;
import java.util.Queue;
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
        super.visitPrograma(ctx);
        pilhaDeTabelas.desempilhar();
        return null;
    }
    
    @Override
    public Void visitDeclaracao_local(gramaticaLAParser.Declaracao_localContext ctx) {
        //caso: 'declare' variavel
        if(ctx.variavel() != null){
            Queue<String> nomeBase = new ArrayDeque<String>();
            Queue<Integer> linhas = new ArrayDeque<Integer>();
            String nomeVar = ctx.variavel().IDENT().getText();
            nomeBase.add(nomeVar);
            linhas.add(ctx.variavel().IDENT().getSymbol().getLine());
            gramaticaLAParser.Mais_varContext auxCtx = ctx.variavel().mais_var();
            while(auxCtx.IDENT() != null) {
                nomeBase.add(auxCtx.IDENT().getText());
                linhas.add(auxCtx.IDENT().getSymbol().getLine());
                auxCtx = auxCtx.mais_var();
            }
            //caso: IDENT dimensao mais_var ':' tipo -> registro            
            if(ctx.variavel().tipo().registro() != null){
                while(nomeBase.peek() != null){
                    if(pilhaDeTabelas.topo().existeSimbolo(nomeBase.peek())){
                        sp.println("Linha "+linhas.peek()+": identificador "+ nomeBase.peek() +" ja declarado anteriormente");
                    }
                    else{
                        pilhaDeTabelas.topo().adicionarSimbolo(nomeBase.peek(), "registro");
                    }
                    String tipoVar = "";
                    gramaticaLAParser.VariavelContext auxCtx2 = ctx.variavel().tipo().registro().variavel();
                    //apenas para o caso: tipo_estendido (estou considerando que não é possivel ter tipo registro de registro)
                    if(ctx.variavel().tipo().registro().variavel().tipo().tipo_estendido() != null){
                        gramaticaLAParser.Ponteiros_opcionaisContext auxCtx3 = auxCtx2.tipo().tipo_estendido().ponteiros_opcionais().ponteiros_opcionais();
                        while(auxCtx3 != null){    
                            tipoVar += "ponteiro para ";
                            auxCtx3 = auxCtx3.ponteiros_opcionais();
                        }
                        if(auxCtx2.tipo().tipo_estendido().tipo_basico_ident().IDENT() != null)
                            tipoVar += auxCtx2.tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                        if(auxCtx2.tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null)
                            tipoVar += auxCtx2.tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();

                        nomeVar = nomeBase.peek()+"."+auxCtx2.IDENT().getText();
                        if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                            sp.println("Linha "+auxCtx2.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
                        }
                        else{
                                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
                        }
                        
                        //trata mais_vars
                        gramaticaLAParser.Mais_varContext auxCtx4 = auxCtx2.mais_var();
                        while(auxCtx4.IDENT() != null) {
                            nomeVar = nomeBase.peek() +"."+ auxCtx4.IDENT().getText();
                            if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                                sp.println("Linha "+auxCtx4.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
                            }
                            else{
                                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
                            }
                            auxCtx4 = auxCtx4.mais_var();
                        }
                    }
                    nomeBase.poll();
                    linhas.poll();
                }
            }
            //caso: IDENT dimensao mais_var ':' tipo -> tipo_estendido -> ponteiros_opcionais tipo_basico_ident
            else{
                String tipoVar = "";
                gramaticaLAParser.Ponteiros_opcionaisContext auxCtx2 = ctx.variavel().tipo().tipo_estendido().ponteiros_opcionais().ponteiros_opcionais();
                while(auxCtx2 != null){    
                    tipoVar += "ponteiro para ";
                    auxCtx2 = auxCtx2.ponteiros_opcionais();
                }
                //nao esta tratando se IDENT for tipo registro
                if(ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT() != null)
                    tipoVar += ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                if(ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null)
                    tipoVar += ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();

                while(nomeBase.peek() != null){
                    if(pilhaDeTabelas.topo().existeSimbolo(nomeBase.peek())){
                        sp.println("Linha "+linhas.peek()+": identificador "+ nomeBase.peek() +" ja declarado anteriormente");
                    }
                    else{
                        pilhaDeTabelas.topo().adicionarSimbolo(nomeBase.peek(), tipoVar);
                    }
                    nomeBase.poll();
                    linhas.poll();
                }
            }
        }
        else{
            //ambos tem IDENT, entao ja verifica antes
            String nomeVar = ctx.IDENT().getText();
            if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                    sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
            }
            else{  
                //caso: 'constante' IDENT ':' tipo_basico '=' valor_constante
                if(ctx.tipo_basico() != null){
                    String tipoVar = ctx.tipo_basico().getText();
                    boolean isTiposIguais = false;

                    if(ctx.valor_constante().CADEIA() != null){
                        if(tipoVar.equals("literal"))
                            isTiposIguais = true;
                    }
                    else if(ctx.valor_constante().NUM_INT() != null){
                        if(tipoVar.equals("inteiro"))
                            isTiposIguais = true;
                    }
                    else if(ctx.valor_constante().NUM_REAL() != null){
                        if(tipoVar.equals("real"))
                            isTiposIguais = true;
                    }
                    else{
                        if(tipoVar.equals("logico"))
                            isTiposIguais = true;
                    }

                    if(isTiposIguais){
                        pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
                    }else{
                        sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": atribuicao nao compativel para "+nomeVar);
                    }
                }
                //caso: 'tipo' IDENT ':' tipo;
                else{
                    //IDENT ja foi verificado se existe!
                    String nomeTipo = nomeVar;
                    //caso: registro
                    if(ctx.tipo().registro() != null){
                            pilhaDeTabelas.topo().adicionarSimbolo(nomeTipo, "registro", new TabelaDeSimbolos(nomeTipo));
                            
                            //PEGA O TIPO da primeira variavel
                            String tipoVar = "";
                            gramaticaLAParser.Ponteiros_opcionaisContext auxCtx = ctx.tipo().registro().variavel().tipo().tipo_estendido().ponteiros_opcionais().ponteiros_opcionais();
                            while(auxCtx != null){    
                                tipoVar += "ponteiro para ";
                                auxCtx = auxCtx.ponteiros_opcionais();
                            }
                            if(ctx.tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT() != null)
                                tipoVar += ctx.tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                            if(ctx.tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null)
                                tipoVar += ctx.tipo().registro().variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                            
                            nomeVar = ctx.tipo().registro().variavel().IDENT().getText();
                            if(pilhaDeTabelas.topo().existeSimbolo(nomeVar, nomeTipo)){
                                sp.println("Linha "+ctx.tipo().registro().variavel().IDENT().getSymbol().getLine()+": identificador "+nomeVar+" ja declarado anteriormente");
                            }
                            else{
                                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar, nomeTipo);
                            }
                            
                            gramaticaLAParser.Mais_varContext auxCtx2 = ctx.tipo().registro().variavel().mais_var();
                            while(auxCtx2.mais_var() != null){
                                nomeVar = auxCtx2.IDENT().getText();
                                if(pilhaDeTabelas.topo().existeSimbolo(nomeVar, nomeTipo)){
                                    sp.println("Linha "+auxCtx2.IDENT().getSymbol().getLine()+": identificador "+nomeVar+" ja declarado anteriormente");
                                }
                                else{
                                    pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar, nomeTipo);
                                }
                                auxCtx2 = auxCtx2.mais_var();
                            }
                            //tratar mais_variaveis
                            
                    }//fim caso registro
                    
                    //caso: tipo_estendido
                    else{
                        String tipoTipo = "";
                        gramaticaLAParser.Ponteiros_opcionaisContext auxCtx = ctx.tipo().tipo_estendido().ponteiros_opcionais().ponteiros_opcionais();
                        while(auxCtx != null){    
                            tipoTipo += "ponteiro para ";
                            auxCtx = auxCtx.ponteiros_opcionais();
                        }
                        if(ctx.tipo().tipo_estendido().tipo_basico_ident().IDENT() != null)
                            tipoTipo += ctx.tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                        if(ctx.tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null)
                            tipoTipo += ctx.tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();

                        pilhaDeTabelas.topo().adicionarSimbolo(nomeTipo, tipoTipo);
                    }
                    
                }//FIM caso: 'tipo' IDENT ':' tipo;
            }
        }
        System.out.println(pilhaDeTabelas.topo().toString());
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
            if(ctx.parcela_unario().outros_ident() != null || ctx.parcela_unario().chamada_partes() != null){
                nomeVar = ctx.parcela_unario().IDENT().getText();
                //outros_ident
                if(ctx.parcela_unario().outros_ident() != null){
                    if(ctx.parcela_unario().outros_ident().identificador() != null){
                        nomeVar += "."+ctx.parcela_unario().outros_ident().identificador().IDENT().getText();
                    }
                }
                //chamada_partes
                else{
                    if(ctx.parcela_unario().chamada_partes().outros_ident() != null){
                        if(ctx.parcela_unario().chamada_partes().outros_ident().identificador() != null){
                            nomeVar += "."+ctx.parcela_unario().chamada_partes().outros_ident().identificador().IDENT().getText();
                        }
                    }
                }
                if(!pilhaDeTabelas.existeSimbolo(nomeVar)){
                    sp.println("Linha "+ctx.parcela_unario().IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
                }
            }
        }
        //caso: parcela_nao_unario
        if(ctx.parcela_nao_unario() != null){
            //caso: '&' IDENT outros_ident dimensao
            if(ctx.parcela_nao_unario().outros_ident() != null){
                nomeVar = ctx.parcela_nao_unario().IDENT().getText();
                if(ctx.parcela_nao_unario().outros_ident().identificador() != null){
                    nomeVar += "."+ctx.parcela_nao_unario().outros_ident().identificador().IDENT().getText();
                }
                if(!pilhaDeTabelas.existeSimbolo(nomeVar)){
                    sp.println("Linha "+ctx.parcela_nao_unario().IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
                }
            }
        }
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitDeclaracao_global(gramaticaLAParser.Declaracao_globalContext ctx) {
        //apenas um IDENT
        String nomeVar = ctx.IDENT().getText();
        String tipoVar;
        
        if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
            sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
        }
        else{
            //caso: funcao
            if(ctx.tipo_estendido() == null){
                tipoVar = "funcao";
            }
            //caso: procedimento
            else{
                tipoVar = "procedimento";
            }
            pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
            pilhaDeTabelas.empilhar(new TabelaDeSimbolos(nomeVar));
            super.visitChildren(ctx);
            pilhaDeTabelas.desempilhar();
            return null;
        }
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitCmd(gramaticaLAParser.CmdContext ctx) { 
        //caso leia
        if(ctx.identificador() != null){
            String nomeVar = ctx.identificador().IDENT().getText();
            if(!pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                    sp.println("Linha "+ctx.identificador().IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
            }
            gramaticaLAParser.Mais_identContext auxCtx = ctx.mais_ident();
            while(auxCtx.identificador() != null){
                nomeVar = auxCtx.identificador().IDENT().getText();
                
                if(auxCtx.identificador().outros_ident().identificador() != null){
                    nomeVar += "."+auxCtx.identificador().outros_ident().identificador().IDENT().getText();
                }
                
                if(!pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                    sp.println("Linha "+auxCtx.identificador().IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
                }
                auxCtx = auxCtx.mais_ident();
            }
        }

        //caso tenha IDENT
        if(ctx.IDENT() != null){
            String nomeVar = ctx.IDENT().getText();
            if(ctx.outros_ident() != null){
                if(ctx.outros_ident().identificador() != null){
                    nomeVar += "."+ctx.outros_ident().identificador().IDENT().getText();
                }    
            }
            
            if(ctx.chamada_atribuicao() != null){
                if(ctx.chamada_atribuicao().outros_ident() != null){
                    if(ctx.chamada_atribuicao().outros_ident().identificador() != null){
                        nomeVar += "."+ctx.chamada_atribuicao().outros_ident().identificador().IDENT().getText();
                    }
                }
            }
            
            if(!pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                    sp.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
            }
        }
        super.visitChildren(ctx);
        return null;
    }
}
