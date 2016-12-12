/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author caiodeqmono
 */
public class Gerador extends gramaticaLABaseVisitor<Void> {  
    PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
    saidaGerador sg = new saidaGerador();

    public Gerador(saidaGerador sg) {
        this.sg = sg;
    }
    
    public String getTipo(gramaticaLAParser.Parcela_unarioContext ctx) {
        //^' IDENT outros_ident dimensao
        if(ctx.outros_ident() != null){
            if(ctx.outros_ident().identificador() != null){
                String tipo = pilhaDeTabelas.getTipo("^"+ctx.IDENT().getText()+"."+ctx.outros_ident().identificador().IDENT().getText());
                return tipo;
            }
            String tipo = pilhaDeTabelas.getTipo("^"+ctx.IDENT().getText());
            return tipo;
        }
        //IDENT chamada_partes
        if(ctx.chamada_partes() != null){
            if(ctx.chamada_partes().outros_ident() != null){
                if(ctx.chamada_partes().outros_ident().identificador() != null){
                    String tipo = pilhaDeTabelas.getTipo(ctx.IDENT().getText()+"."+ctx.chamada_partes().outros_ident().identificador().IDENT().getText());
                    return tipo;
                }
                String tipo = pilhaDeTabelas.getTipo(ctx.IDENT().getText());
                return tipo;
            }
            if(ctx.chamada_partes().expressao() != null){
                return pilhaDeTabelas.getTipo(ctx.IDENT().getText());
            }
            
        }
        //NUM_INT
        if(ctx.NUM_INT() != null)
            return "int";
        //NUM_REAL
        if(ctx.NUM_REAL() != null)
            return "float";
        //'(' expressao ')'
        if(ctx.expressao() != null)
            return getTipo(ctx.expressao());
        
        return null;
    }
    
    public String getTipo(gramaticaLAParser.Parcela_nao_unarioContext ctx){
        //'&' IDENT outros_ident dimensao
        if(ctx.IDENT() != null){
            /*if(ctx.outros_ident().identificador() != null){
                String tipo = pilhaDeTabelas.getTipo(ctx.IDENT().getText()+"."+ctx.outros_ident().identificador().IDENT().getText());
                if(tipo.equals("real") || tipo.equals("inteiro"))
                    return "numero";
                return tipo;
            }*/
            String tipo = pilhaDeTabelas.getTipo(ctx.IDENT().getText());
            //if(tipo.equals("real") || tipo.equals("inteiro"))
            //      return "numero";
            return "^"+tipo;
        }
        //CADEIA
        if(ctx.CADEIA() != null)
            return "char";
        
        return null;
    }
    
    public String getTipo(gramaticaLAParser.ParcelaContext ctx){
        //op_unario parcela_unario
        if(ctx.parcela_unario() != null){
            return getTipo(ctx.parcela_unario());
        }
        //parcela_nao_unario
        return getTipo(ctx.parcela_nao_unario());
        
        
    }
    
    public String getTipo(gramaticaLAParser.Outras_parcelasContext ctx){
        String tipoParcela = getTipo(ctx.parcela());
        //'%' parcela outras_parcelas
        if(ctx.outras_parcelas().parcela() != null){
            String tipoOutros = getTipo(ctx.outras_parcelas());
            if(tipoParcela != null && tipoParcela.equals(tipoOutros))
                return tipoParcela;
            return null;
        }
        return tipoParcela;    
    }
    
    public String getTipo(gramaticaLAParser.FatorContext ctx) {
        String tipoParcela = getTipo(ctx.parcela());
        //parcela outras_parcelas
        if(ctx.outras_parcelas().parcela() != null){
            String tipoOutros = getTipo(ctx.outras_parcelas());
            if(tipoParcela != null && tipoParcela.equals(tipoOutros))
                return tipoParcela;
            return null;
        }
        return tipoParcela;
    }
    
    public String getTipo(gramaticaLAParser.Outros_fatoresContext ctx){
        String tipoFator = getTipo(ctx.fator());
        //op_multiplicacao fator outros_fatores
        if(ctx.outros_fatores().fator() != null){
            String tipoOutros = getTipo(ctx.outros_fatores());
            if(tipoFator != null && tipoFator.equals(tipoOutros))
                return tipoFator;
            if(tipoFator != null && tipoOutros != null && (tipoFator.equals("float") || tipoFator.equals("int")) && (tipoOutros.equals("float") || tipoOutros.equals("int")))
                return "float";
            return null;
        }
        return tipoFator;
    }
    
    public String getTipo(gramaticaLAParser.TermoContext ctx){
        String tipoFator = getTipo(ctx.fator());
        //fator outros_fatores;
        if(ctx.outros_fatores().fator() != null){
            String tipoOutros = getTipo(ctx.outros_fatores());
            if(tipoFator != null && tipoFator.equals(tipoOutros))
                return tipoFator;
            if(tipoFator != null && tipoOutros != null && (tipoFator.equals("float") || tipoFator.equals("int")) && (tipoOutros.equals("float") || tipoOutros.equals("int")))
                return "float";
            return null;
        }
        return tipoFator;
    }
    
    public String getTipo(gramaticaLAParser.Outros_termosContext ctx){
        String tipoTermo = getTipo(ctx.termo());
        //op_adicao termo outros_termos
        if(ctx.outros_termos().termo() != null){
            String tipoOutros = getTipo(ctx.outros_termos());
            if(tipoTermo != null && tipoTermo.equals(tipoOutros))
                return tipoTermo;
            return null;
        }
        return tipoTermo; 
    }
    
    public String getTipo(gramaticaLAParser.Exp_aritmeticaContext ctx){
        String tipoTermo = getTipo(ctx.termo());
        //termo outros_termos
        if(ctx.outros_termos().termo() != null){
            String tipoOutros = getTipo(ctx.outros_termos());
            if(tipoTermo != null && tipoTermo.equals(tipoOutros))
                return tipoTermo;
            return null;
        }
        return tipoTermo;
    }
    
    public String getTipo(gramaticaLAParser.Exp_relacionalContext ctx){
        String tipoExp_aritmetica = getTipo(ctx.exp_aritmetica());
        
        //exp_aritmetica op_opcional
        if(ctx.op_opcional().op_relacional() != null){
            if(tipoExp_aritmetica != null && tipoExp_aritmetica.equals(getTipo(ctx.op_opcional().exp_aritmetica())))
                return "logico";
            
            return null;
        }
        return tipoExp_aritmetica;
    }
    
    public String getTipo(gramaticaLAParser.Parcela_logicaContext ctx){
        //'verdadeiro' | 'falso' | exp_relacional
        if(ctx.exp_relacional() != null)
            return getTipo(ctx.exp_relacional());
        return "logico";
    }
    
    public String getTipo(gramaticaLAParser.Fator_logicoContext ctx){
        //op_nao parcela_logica
        return getTipo(ctx.parcela_logica());
    }
    
    public String getTipo(gramaticaLAParser.Outros_fatores_logicosContext ctx){
        String tipoFator_logico = getTipo(ctx.fator_logico());
        //'e' fator_logico outros_fatores_logicos
        if(ctx.outros_fatores_logicos().fator_logico() != null){
            String tipoOutros = getTipo(ctx.outros_fatores_logicos());
            if(tipoFator_logico != null && tipoFator_logico.equals(tipoOutros))
                return tipoFator_logico;
            return null;
        }
        return tipoFator_logico;
    }
    
    public String getTipo(gramaticaLAParser.Termo_logicoContext ctx){
        String tipoFator_logico = getTipo(ctx.fator_logico());
        //fator_logico outros_fatores_logicos
        if(ctx.outros_fatores_logicos().fator_logico() != null){
            String tipoOutros = getTipo(ctx.outros_fatores_logicos());
            if(tipoFator_logico != null && tipoFator_logico.equals(tipoOutros))
                return tipoFator_logico;
            return null;
        }
        return tipoFator_logico;
    }
    
    public String getTipo(gramaticaLAParser.Outros_termos_logicosContext ctx){
        String tipoTermo_logico = getTipo(ctx.termo_logico());
        //'ou' termo_logico outros_termos_logicos
        if(ctx.outros_termos_logicos().termo_logico() != null){
            String tipoOutros = getTipo(ctx.outros_termos_logicos());
            if(tipoTermo_logico != null && tipoTermo_logico.equals(tipoOutros))
                return tipoTermo_logico;
            return null;
        }
        return tipoTermo_logico;
    }
    
    public String getTipo(gramaticaLAParser.ExpressaoContext ctx){
        String tipoTermo_logico = getTipo(ctx.termo_logico());
        //termo_logico outros_termos_logicos
        if(ctx.outros_termos_logicos().termo_logico() != null){
            String tipoOutros = getTipo(ctx.outros_termos_logicos());
            if(tipoTermo_logico != null && tipoTermo_logico.equals(tipoOutros))
                return tipoTermo_logico;
            return null;
        }
        return tipoTermo_logico;
    }
    

    @Override
    public Void visitPrograma(gramaticaLAParser.ProgramaContext ctx) {
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));
        sg.addCommand("#include <stdio.h>\n");
        sg.addCommand("#include <stdlib.h>\n\n");
        super.visitPrograma(ctx);
        pilhaDeTabelas.desempilhar();
        return null;
    }
    
    @Override
    public Void visitDeclaracao_local(gramaticaLAParser.Declaracao_localContext ctx) {
        //caso: 'declare' variavel
        if(ctx.variavel() != null){
            ArrayDeque<String> nomeBase = new ArrayDeque<String>();
            ArrayDeque<Integer> linhas = new ArrayDeque<Integer>();
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
                    
                    sg.addCommand("struct {\n");
                    sg.enterScope();


                    pilhaDeTabelas.topo().adicionarSimbolo(nomeBase.peek(), "reg");

                    
                    gramaticaLAParser.VariavelContext auxCtx2 = ctx.variavel().tipo().registro().variavel();
                    gramaticaLAParser.Mais_variaveisContext auxCtx5 = ctx.variavel().tipo().registro().mais_variaveis();
                    
                    while(auxCtx5 != null){
                        String tipoVar = "";
                        
                        //apenas para o caso: tipo_estendido (estou considerando que não é possivel ter tipo registro de registro)
                        if(auxCtx2.tipo().tipo_estendido() != null){
                            gramaticaLAParser.Ponteiros_opcionaisContext auxCtx3 = auxCtx2.tipo().tipo_estendido().ponteiros_opcionais().ponteiros_opcionais();
                            while(auxCtx3 != null){    
                                tipoVar += "^";
                                auxCtx3 = auxCtx3.ponteiros_opcionais();
                            }
                            if(auxCtx2.tipo().tipo_estendido().tipo_basico_ident().IDENT() != null)
                                tipoVar += auxCtx2.tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                            if(auxCtx2.tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null)
                                tipoVar += auxCtx2.tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();

                            nomeVar = nomeBase.peek()+"."+auxCtx2.IDENT().getText();
                            
                            tipoVar = Formatador.tipo(tipoVar);
                            if(tipoVar.equals("char")){
                                sg.addCommand(tipoVar+" "+auxCtx2.IDENT().getText()+"[80];\n");
                            }else{
                                sg.addCommand(tipoVar+" "+auxCtx2.IDENT().getText()+";\n");
                            }
                            pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);


                            //trata mais_vars
                            gramaticaLAParser.Mais_varContext auxCtx4 = auxCtx2.mais_var();
                            while(auxCtx4.IDENT() != null) {
                                nomeVar = nomeBase.peek() +"."+ auxCtx4.IDENT().getText();

                                if(tipoVar.equals("char")){
                                    sg.addCommand(tipoVar+" "+auxCtx4.IDENT().getText()+"[80];\n");
                                }else{
                                    sg.addCommand(tipoVar+" "+auxCtx4.IDENT().getText()+";\n");
                                }
                                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
                                
                                auxCtx4 = auxCtx4.mais_var();
                            }
                        }
                        auxCtx2 = auxCtx5.variavel();
                        auxCtx5 = auxCtx5.mais_variaveis();
                    }
                    sg.exitScope();
                    sg.addCommand("}"+nomeBase.peek()+";\n");
                    nomeBase.poll();
                    linhas.poll();
                }
            }
            //caso: IDENT dimensao mais_var ':' tipo -> tipo_estendido -> ponteiros_opcionais tipo_basico_ident
            else{
                String tipoVar = "";
                gramaticaLAParser.Ponteiros_opcionaisContext auxCtx2 = ctx.variavel().tipo().tipo_estendido().ponteiros_opcionais().ponteiros_opcionais();
                while(auxCtx2 != null){    
                    tipoVar += "^";
                    auxCtx2 = auxCtx2.ponteiros_opcionais();
                }
                
                //trata se o IDENT do tipo_basico_ident for do tipo registro ou tipo basico
                if(ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT() != null){
                    String nomeTipo = ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                    if(pilhaDeTabelas.getTipo(nomeTipo) != null && pilhaDeTabelas.getTipo(nomeTipo).equals("registro")){
                        String preTipo = tipoVar;
                        while(nomeBase.peek() != null){
                            sg.addCommand(nomeTipo+" "+nomeBase.peek()+";\n");
                            pilhaDeTabelas.topo().adicionarSimbolo(nomeBase.peek(), nomeTipo);
                            for(String var: pilhaDeTabelas.getSimbolos(nomeTipo)){
                                tipoVar = preTipo + pilhaDeTabelas.topo().getTipo(var, nomeTipo);
                                nomeVar = nomeBase.peek()+"."+var;
                                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
                            }

                            nomeBase.poll();
                            linhas.poll();
                        }
                    }
                    else{
                        tipoVar += pilhaDeTabelas.getTipo(nomeTipo);
                    }
                }
                if(ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null)
                    tipoVar += ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                
                tipoVar = Formatador.tipo(tipoVar);

                while(nomeBase.peek() != null){
                    if(tipoVar.equals("char")){
                        sg.addCommand(tipoVar+" "+nomeBase.peek()+"[80];");
                    }
                    else{
                    sg.addCommand(tipoVar+" "+nomeBase.peek()+ctx.variavel().dimensao().getText()+";");
                    }
                    sg.nl();
                    pilhaDeTabelas.topo().adicionarSimbolo(nomeBase.peek(), tipoVar);
                    
                    nomeBase.poll();
                    linhas.poll();
                }
            }
        }
        else{
            //ja verifica antes para os dois casos
            String nomeVar = ctx.IDENT().getText();
            if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                //sg.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
            }
            else{
                //caso: 'constante' IDENT ':' tipo_basico '=' valor_constante
                if(ctx.tipo_basico() != null){
                    String tipoVar = ctx.tipo_basico().getText();
                    boolean isTiposIguais = false;

                    if(ctx.valor_constante().CADEIA() != null){
                        if(tipoVar.equals("char"))
                            isTiposIguais = true;
                    }
                    else if(ctx.valor_constante().NUM_INT() != null){
                        if(tipoVar.equals("int") || tipoVar.equals("float"))
                            isTiposIguais = true;
                    }
                    else if(ctx.valor_constante().NUM_REAL() != null){
                        if(tipoVar.equals("float"))
                            isTiposIguais = true;
                    }
                    else{
                        if(tipoVar.equals("int"))
                            isTiposIguais = true;
                    }

                    if(isTiposIguais){
                        pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
                    }else{
                        sg.addCommand("#define "+nomeVar+" "+ctx.valor_constante().getText()+"\n");
                    }
                }
                //caso: 'tipo' IDENT ':' tipo;
                else{
                    //verificou antes o ident, pois se ja exisitr o tipo, nem ve o resto
                    String nomeTipo = nomeVar;
                    //caso: registro
                    if(ctx.tipo().registro() != null){
                        pilhaDeTabelas.topo().adicionarSimbolo(nomeTipo, "registro", new TabelaDeSimbolos(nomeTipo));
                        
                        sg.addCommand("typedef struct{\n");
                        sg.enterScope();
                        
                        gramaticaLAParser.VariavelContext auxCtx = ctx.tipo().registro().variavel();
                        gramaticaLAParser.Mais_variaveisContext auxCtx2 = ctx.tipo().registro().mais_variaveis();
                        
                        //faz para cada variavel
                        while(auxCtx2 != null) {
                            //pega o tipo
                            String tipoVar = "";
                            gramaticaLAParser.Ponteiros_opcionaisContext auxCtx3 = auxCtx.tipo().tipo_estendido().ponteiros_opcionais().ponteiros_opcionais();
                            while(auxCtx3 != null){    
                                tipoVar += "^";
                                auxCtx3 = auxCtx3.ponteiros_opcionais();
                            }
                            if(auxCtx.tipo().tipo_estendido().tipo_basico_ident().IDENT() != null)
                                tipoVar += auxCtx.tipo().tipo_estendido().tipo_basico_ident().IDENT().getText();
                            if(auxCtx.tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null)
                                tipoVar += auxCtx.tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText();

                            //verifica se ja existe
                            nomeVar = auxCtx.IDENT().getText();
                            if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                                //sg.println("Linha "+auxCtx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
                            }
                            else{
                                tipoVar = Formatador.tipo(tipoVar);
                                
                                pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar, nomeTipo);
                                
                            }
                            
                            if(tipoVar.equals("char")){
                                sg.addCommand(tipoVar+" "+nomeVar+"[80];\n");
                            }
                            else{
                                sg.addCommand(tipoVar+" "+nomeVar+";\n");
                            }
                            
                            
                            //verifica mais_vars
                            gramaticaLAParser.Mais_varContext auxCtx4 = auxCtx.mais_var();
                            while(auxCtx4.mais_var() != null){
                                nomeVar = auxCtx4.IDENT().getText();
                                if(pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                                    //sg.println("Linha "+auxCtx4.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
                                }
                                else{
                                    pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar, nomeTipo);
                                }
                                auxCtx4 = auxCtx4.mais_var();
                            }
                            auxCtx = auxCtx2.variavel();
                            auxCtx2 = auxCtx2.mais_variaveis();
                        }
                        sg.exitScope();
                        sg.addCommand("}"+nomeTipo+";\n");
                    }
                    //caso: tipo_estendido
                    else{
                        String tipoTipo = "";
                        gramaticaLAParser.Ponteiros_opcionaisContext auxCtx = ctx.tipo().tipo_estendido().ponteiros_opcionais().ponteiros_opcionais();
                        while(auxCtx != null){    
                            tipoTipo += "^";
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
        //System.out.println(pilhaDeTabelas.topo().toString());
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitTipo_basico_ident(gramaticaLAParser.Tipo_basico_identContext ctx) { 
        if(ctx.IDENT() != null){
            if(!pilhaDeTabelas.existeSimbolo(ctx.IDENT().getText())){
                //sg.println("Linha "+ctx.IDENT().getSymbol().getLine()+": tipo " + ctx.IDENT().getText() + " nao declarado");
            }
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
                    //sg.println("Linha "+ctx.parcela_unario().IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
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
                    //sg.println("Linha "+ctx.parcela_nao_unario().IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
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
            //sg.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" ja declarado anteriormente");
        }
        else{
            //caso: funcao
            if(ctx.tipo_estendido() != null){
                tipoVar = ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                tipoVar = Formatador.tipo(tipoVar);
            }
            //caso: procedimento
            else{
                tipoVar = "procedimento";
                String comandos = ctx.comandos().getText();
                if(comandos.contains("retorne")){
                    //sg.println("Linha "+ctx.comandos().getStop().getLine()+": comando retorne nao permitido nesse escopo");
                }
            }
            pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar, new TabelaDeSimbolos(nomeVar));
            
            if(tipoVar.equals("procedimento")){
                sg.addCommand("void "+nomeVar+"(");
            }
            else{
                sg.addCommand(tipoVar+" "+nomeVar+"(");
            }
            
            String escopo = nomeVar;
            
            if(ctx.parametros_opcional().parametro() != null){
            
                gramaticaLAParser.ParametroContext auxCtx = ctx.parametros_opcional().parametro();

                while(auxCtx != null){
                    nomeVar = auxCtx.identificador().IDENT().getText();
                    if(auxCtx.tipo_estendido().tipo_basico_ident().IDENT() != null)
                        tipoVar = auxCtx.tipo_estendido().tipo_basico_ident().IDENT().getText();
                    if(auxCtx.tipo_estendido().tipo_basico_ident().tipo_basico() != null)
                        tipoVar = auxCtx.tipo_estendido().tipo_basico_ident().tipo_basico().getText();
                    
                    tipoVar = Formatador.tipo(tipoVar);
                    pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar, escopo);
                    if(tipoVar.equals("char")){
                        sg.addCode(tipoVar+"* "+nomeVar);
                    }
                    else{
                        sg.addCode(tipoVar+" "+nomeVar);
                    }
                    
                    auxCtx = auxCtx.mais_parametros().parametro();
                }
            }
            sg.addCode("){\n");
            sg.enterScope();
            
            pilhaDeTabelas.empilhar(new TabelaDeSimbolos(nomeVar));
            super.visitChildren(ctx);
            sg.exitScope();
            sg.addCommand("}\n");
            pilhaDeTabelas.desempilhar();
            return null;
        }
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitCmd(gramaticaLAParser.CmdContext ctx) { 
        //caso 'se' expressao 'entao' comandos senao_opcional 'fim_se'
        if(ctx.getText().contains("fim_se")){
            String conteudo = ctx.expressao().getText();
            sg.addCommand("if("+Formatador.format(conteudo)+"){\n");
            sg.enterScope();
            super.visitComandos(ctx.comandos());
            sg.exitScope();
            sg.addCommand("}\n");
            if(ctx.senao_opcional().comandos() != null){
                sg.addCommand("else{\n");
                sg.enterScope();
                super.visitComandos(ctx.senao_opcional().comandos());
                sg.exitScope();
                sg.addCommand("}\n");
            }
            return null;
        }
        
        //caso 'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' comandos 'fim_para'
        if(ctx.getText().contains("fim_para")){
            sg.addCommand("for(int i = "+ctx.exp_aritmetica(0).getText()+"; i <= "+ctx.exp_aritmetica(1).getText()+"; i++){\n");
            sg.enterScope();
            super.visitComandos(ctx.comandos());
            sg.exitScope();
            sg.addCommand("}\n");
            return null;
        }
        
        //caso 'enquanto' expressao 'faca' comandos 'fim_enquanto'
        if(ctx.getText().contains("fim_enquanto")){
            sg.addCommand("while("+ctx.expressao().getText()+"){\n");
            sg.enterScope();
            super.visitComandos(ctx.comandos());
            sg.exitScope();
            sg.addCommand("}\n");
            return null;
        }
        
        //caso 'faca' comandos 'ate' expressao
        if(ctx.getText().contains("ate") && ctx.expressao() != null){
            sg.addCommand("do{\n");
            sg.enterScope();
            super.visitComandos(ctx.comandos());
            sg.exitScope();
            sg.addCommand("}while("+Formatador.format(ctx.expressao().getText())+");\n");
            return null;
        }
        
        //caso 'leia' '(' identificador mais_ident ')'
        if(ctx.identificador() != null){
            String nomeVar = ctx.identificador().IDENT().getText();
            String tipoVar = pilhaDeTabelas.getTipo(nomeVar);
            tipoVar = Formatador.tipo(tipoVar);
            
            //caso char
            if(tipoVar.equals("char")){
                sg.addCommand("gets("+nomeVar);
            }
            //caso int e float
            else{
            sg.addCommand("scanf(\""+Formatador.ioFormat(tipoVar)+"\", &"+ nomeVar);
            }
            gramaticaLAParser.Mais_identContext auxCtx = ctx.mais_ident();
            while(auxCtx.identificador() != null){
                nomeVar = auxCtx.identificador().IDENT().getText();
                
                if(auxCtx.identificador().outros_ident().identificador() != null){
                    nomeVar += "."+auxCtx.identificador().outros_ident().identificador().IDENT().getText();
                }
                
                if(!pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                    //sg.println("Linha "+auxCtx.identificador().IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
                }
                auxCtx = auxCtx.mais_ident();
            }
            
            sg.addCode(");");
            sg.nl();
        }

        //caso 'escreva' '(' expressao mais_expressao ')'
        if(ctx.mais_expressao() != null){
            String conteudo = ctx.expressao().getText()+ctx.mais_expressao().getText();
            
            //caso tenha aspas
            if(ctx.getText().contains("\"")){
                String tipoVar = pilhaDeTabelas.getTipo(ctx.expressao().getText()+ctx.mais_expressao().getText());
                //caso seja apenas uma variavel
                if(tipoVar != null){
                    tipoVar = Formatador.tipo(tipoVar);
                    
                    sg.addCommand("printf(\""+Formatador.ioFormat(tipoVar)+"\","+ctx.expressao().getText()+");");
                }
                else{
                    //caso tenha texto e variaveis
                    if(ctx.getText().contains(",")){
                        String[] text = (conteudo).split(",");
                        int i = 0;
                        while(i < text.length){
                            if(text[i].contains("\"")){
                                sg.addCommand("printf("+text[i]+");\n");
                            }
                            else{
                                tipoVar = Formatador.tipo(pilhaDeTabelas.getTipo(text[i]));
                                sg.addCommand("printf(\""+Formatador.ioFormat(tipoVar)+"\", "+text[i]+");\n");
                            }
                            i++;
                        }
                    }
                    //caso soh texto
                    else{
                        sg.addCommand("printf("+conteudo+");");
                    }

                }
            }
            else{
                
                if(conteudo.contains("+")){

                    String[] nomeVar = conteudo.split("\\+");

                    String tipoVar = pilhaDeTabelas.getTipo(nomeVar[0]);
                    sg.addCommand("printf(\""+Formatador.ioFormat(tipoVar)+"\","+conteudo+");\n");
                }
                else if(conteudo.contains("(")){
                    
                    String[] nomeFuncao = conteudo.split("\\(");
                    
                    String tipoVar = pilhaDeTabelas.getTipo(nomeFuncao[0]);
                    sg.addCommand("printf(\""+Formatador.ioFormat(tipoVar)+"\","+conteudo+");\n");
                }
                else if(conteudo.contains("[")){
                    String[] nomeVar = conteudo.split("\\[");

                    String tipoVar = pilhaDeTabelas.getTipo(nomeVar[0]);
                    sg.addCommand("printf(\""+Formatador.ioFormat(tipoVar)+"\","+conteudo+");\n");
                }
                else{
                    String tipoVar = pilhaDeTabelas.getTipo(conteudo);
                    sg.addCommand("printf(\""+Formatador.ioFormat(tipoVar)+"\","+conteudo+");\n");
                }
                
            }
        }
        
        //caso 'caso' exp_aritmetica 'seja' selecao senao_opcional 'fim_caso'
        if(ctx.getText().contains("fim_caso")){
            sg.addCommand("switch ("+ctx.exp_aritmetica(0).getText()+") {\n");
            sg.enterScope();
            super.visitChildren(ctx);
            sg.exitScope();
            sg.addCommand("}\n");
            return null;
        }
        
        //caso tenha IDENT
        if(ctx.IDENT() != null){
            String nomeVar = ctx.IDENT().getText();
            //'^' IDENT outros_ident dimensao '<-' expressao
            if(ctx.outros_ident() != null){
                if(ctx.outros_ident().identificador() != null){
                    nomeVar += "."+ctx.outros_ident().identificador().IDENT().getText();
                }
                String tipoExpressao = getTipo(ctx.expressao());
                String tipoVar = pilhaDeTabelas.getTipo(nomeVar);
                sg.addCommand(Formatador.format(ctx.getText())+";\n");
            }
            
            if(ctx.chamada_atribuicao() != null){
                //outros_ident dimensao '<-' expressao
                if(ctx.chamada_atribuicao().outros_ident() != null){
                    if(ctx.chamada_atribuicao().outros_ident().identificador() != null){
                        nomeVar += "."+ctx.chamada_atribuicao().outros_ident().identificador().IDENT().getText();
                    }
                    String tipoExpressao = getTipo(ctx.chamada_atribuicao().expressao());
                    String tipoVar = pilhaDeTabelas.getTipo(nomeVar);
                    
                    if(tipoVar.equals("char")){
                        sg.addCommand("strcpy("+nomeVar+","+ctx.chamada_atribuicao().expressao().getText()+");\n");
                    }
                    else{
                        sg.addCommand(Formatador.format(ctx.getText())+";\n");
                    }
                    
                }
                //caso IDENT '(' argumentos_opcional ')'
                else{
                    sg.addCommand(ctx.getText()+";\n");
                }
            }
            
            if(!pilhaDeTabelas.topo().existeSimbolo(nomeVar)){
                //sg.println("Linha "+ctx.IDENT().getSymbol().getLine()+": identificador "+ nomeVar +" nao declarado");
            }
        }
        
        //caso 'retorne' expressao;
        if(ctx.getText().contains("retorne")){
            String conteudo = ctx.getText().replace("retorne", "return ");
            sg.addCommand(conteudo+";\n");
        }
        
        super.visitChildren(ctx);
        return null;
    }
    
    @Override public Void visitSenao_opcional(gramaticaLAParser.Senao_opcionalContext ctx) { 
        sg.addCommand("default:\n");
        sg.enterScope();
        super.visitChildren(ctx); 
        sg.addCode("\n");
        sg.exitScope();
        return null;
    }
    
    @Override public Void visitSelecao(gramaticaLAParser.SelecaoContext ctx) { 
        //caso tenha intervalo
        if(ctx.constantes().numero_intervalo().intervalo_opcional().NUM_INT() != null){
            int i = Integer.parseInt(ctx.constantes().numero_intervalo().NUM_INT().getText());
            int j = Integer.parseInt(ctx.constantes().numero_intervalo().intervalo_opcional().NUM_INT().getText());
            for(i=i; i < j; i++){
                sg.addCommand("case "+i+": \n");
            }
            sg.addCommand("case "+j+":\n");
            sg.enterScope();
            super.visitComandos(ctx.comandos()); 
            sg.addCode("\n");
            sg.addCommand("break;\n");
            sg.exitScope();
        }
        else{
        //caso apenas um numero
            sg.addCommand("case "+ctx.constantes().numero_intervalo().NUM_INT().getText()+":\n");
            sg.enterScope();
            super.visitComandos(ctx.comandos()); 
            sg.addCode("\n");
            sg.addCommand("break;\n");
            sg.exitScope();
        }
        
        super.visitMais_selecao(ctx.mais_selecao());
        
        return null;
    }
    
    @Override public Void visitParametro(gramaticaLAParser.ParametroContext ctx) {
        
        ArrayDeque<String> nomeBase = new ArrayDeque<String>();
        ArrayDeque<Integer> linhas = new ArrayDeque<Integer>();
        ArrayDeque<String> tipos = new ArrayDeque<String>();
        String nomeVar = ctx.identificador().IDENT().getText();
        nomeBase.add(nomeVar);
        linhas.add(ctx.identificador().IDENT().getSymbol().getLine());
        tipos.add(ctx.tipo_estendido().tipo_basico_ident().getText());
        gramaticaLAParser.Mais_parametrosContext auxCtx = ctx.mais_parametros();
        while(auxCtx.parametro() != null) {
            nomeBase.add(auxCtx.parametro().identificador().IDENT().getText());
            linhas.add(auxCtx.parametro().identificador().IDENT().getSymbol().getLine());
            tipos.add(auxCtx.parametro().tipo_estendido().tipo_basico_ident().getText());
            auxCtx = auxCtx.parametro().mais_parametros();
        }
        
        String tipoVar = "";

        //trata se o IDENT for do tipo registro ou tipo basico
        while(nomeBase.peek() != null){
            String nomeTipo = tipos.peek();
            if(pilhaDeTabelas.getTipo(nomeTipo) != null && pilhaDeTabelas.getTipo(nomeTipo).equals("registro")){
                if(pilhaDeTabelas.topo().existeSimbolo(nomeBase.peek())){
                    //sg.println("Linha "+linhas.peek()+": identificador "+ nomeBase.peek() +" ja declarado anteriormente");
                }
                else
                {
                    pilhaDeTabelas.topo().adicionarSimbolo(nomeBase.peek(), nomeTipo);
                    for(String var: pilhaDeTabelas.getSimbolos(nomeTipo)){
                        tipoVar = pilhaDeTabelas.getTipo(var, nomeTipo);
                        nomeVar = nomeBase.peek()+"."+var;
                        pilhaDeTabelas.topo().adicionarSimbolo(nomeVar, tipoVar);
                    }
                }
            }
            else{
                pilhaDeTabelas.topo().adicionarSimbolo(nomeBase.peek(), tipos.peek());
            }
            
            nomeBase.poll();
            linhas.poll();
            tipos.poll();
        }
        super.visitChildren(ctx);
        return null;
    } 
    
    @Override
    public Void visitCorpo(gramaticaLAParser.CorpoContext ctx) {
        String comandos = ctx.comandos().getText();
        
        if(comandos.contains("retorne")){
            //sg.println("Linha "+ctx.comandos().getStop().getLine()+": comando retorne nao permitido nesse escopo");
        }
        sg.addCommand("int main() {\n");
        sg.enterScope();
        super.visitChildren(ctx);
        sg.addCommand("return 0;\n");
        sg.exitScope();
        sg.addCommand("}");
        
        return null;
    }
    
    @Override
    public Void visitParcela_unario(gramaticaLAParser.Parcela_unarioContext ctx){
        
        if(ctx.chamada_partes() != null){
            String nomeFuncao = ctx.IDENT().getText();
            ArrayList<String> varsFuncao = new ArrayList<String>();
            //'(' expressao mais_expressao ')'
            if(ctx.chamada_partes().expressao() != null){
                ArrayList<String> tipoVarsChamada = new ArrayList<String>();
                gramaticaLAParser.Mais_expressaoContext auxCtx = ctx.chamada_partes().mais_expressao();
                tipoVarsChamada.add(getTipo(ctx.chamada_partes().expressao()));
                while(auxCtx.expressao() != null){
                    tipoVarsChamada.add(getTipo(auxCtx.expressao()));
                    auxCtx = auxCtx.mais_expressao();
                }
                
                varsFuncao = pilhaDeTabelas.getSimbolos(nomeFuncao);
                
                ArrayList<String> tipoVarsFuncao = new ArrayList<String>();
                
                for(String var: varsFuncao){
                    tipoVarsFuncao.add(pilhaDeTabelas.getTipo(var, nomeFuncao));
                }
                
                if(tipoVarsFuncao.size() != tipoVarsChamada.size()){
                    //sg.println("Linha "+ctx.IDENT().getSymbol().getLine()+": incompatibilidade de parametros na chamada de "+nomeFuncao);
                }
                else{
                    String aux1, aux2;
                    while(tipoVarsFuncao.size() > 0){
                        aux1 = tipoVarsFuncao.remove(0);
                        aux2 = tipoVarsChamada.remove(0);
                        if(aux1 != null && !aux1.equals(aux2)){
                            //sg.println("Linha "+ctx.IDENT().getSymbol().getLine()+": incompatibilidade de parametros na chamada de "+nomeFuncao);
                        }
                    }
                }   
            }
        }
        
        super.visitChildren(ctx);
        return null;
    }
}
