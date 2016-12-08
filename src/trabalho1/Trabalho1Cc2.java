/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.JOptionPane;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author caiodeqmono
 */
public class Trabalho1Cc2 {

    public static void main(String[] args) throws IOException{
        boolean isTeste = true;
        
        saidaParser outSintatico = new saidaParser(0);
        saidaParser outSemantico = new saidaParser(1);
        
        String arquivo, caminho;
        //Geracao de Codigo
        caminho = "/home/caiodeqmono/Desktop/casosDeTesteT1/3.arquivos_sem_erros/1.entrada/";
        arquivo = "1.declaracao_leitura_impressao_inteiro.alg";
        //arquivo = "2.declaracao_leitura_impressao_real.alg";
        //arquivo = "3.declaracao_leitura_impressao_literal.alg";
        //arquivo = "4.declaracao_leitura_impressao_inteiro_literal.alg";
        //arquivo = "5.declaracao_leitura_impressao_expressao_real.alg";
        //arquivo = "6.declaracao_leitura_atribuicao_impressao_real.alg";
        //arquivo = "7.se_entao_impressao.alg";
        //arquivo = "8.se_entao_senao_impressao.alg";
        //arquivo = "9.se_entao_expressao_impressao.alg";
        //arquivo = "10.caso_impressao.alg";
        //arquivo = "11.constante_caso_impressao.alg";
        //arquivo = "12.para_declaracao_impressao.alg";
        //arquivo = "13.enquanto_declaracao_impressao.alg";
        //arquivo = "14.faca-ate_declaracao_impressao.alg";
        //arquivo = "15.ponteiro_impressao.alg";        
        //arquivo = "16.registro_impressao.alg";        
        //arquivo = "17.registro_tipo_impressao.alg";
        //arquivo = "18.procedimento_impressao.alg";
        //arquivo = "19.funcao_dobro_impressao.alg";
        //arquivo = "20.vetor_repeticao_impressao.alg";
        
        ANTLRInputStream input;
        
        if(isTeste){
            input = new ANTLRInputStream(new FileInputStream(caminho+arquivo));
        }
        else{
            File entrada = new File(args[0]);  
            input = new ANTLRInputStream(new FileInputStream(entrada));
        }
        
        
        gramaticaLALexer lexer = new gramaticaLALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        gramaticaLAParser parser = new gramaticaLAParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new AnalisadorSintatico(outSintatico));
        ParseTree tree = null;
        try {
            gramaticaLAParser.ProgramaContext arvore = parser.programa();
            if(outSintatico.toString().isEmpty()){
                AnalisadorSemantico as = new AnalisadorSemantico(outSemantico);
                as.visitPrograma(arvore);
            }
        } catch(ParseCancellationException pce) {
            outSintatico.println(pce.getMessage());
        }
        if(outSintatico.toString().isEmpty()){
            if(!outSemantico.toString().isEmpty()){
                outSemantico.close();
            }
        }
        else{
            outSintatico.close();
        }
        
        if(isTeste){
            System.out.print(outSintatico.toString()+outSemantico.toString());
        }
        else{
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(args[1]), "utf-8"))) {
                String check = outSintatico.toString()+outSemantico.toString();
                if(check.isEmpty()){
                    writer.write("codigo");
                }
                else{
                    writer.write(outSintatico.toString()+outSemantico.toString());
                }
            }
        }
        
        
    }
    
}
