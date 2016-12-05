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
        boolean isTeste = false;
        
        saidaParser outSintatico = new saidaParser(0);
        saidaParser outSemantico = new saidaParser(1);
        
        String arquivo;
        //arquivo = "1.algoritmo_2-2_apostila_LA.txt";
        //arquivo = "2.algoritmo_2-4_apostila_LA.txt";
        //arquivo = "3.algoritmo_3-1_apostila_LA.txt";
        //arquivo = "4.algoritmo_3-2_apostila_LA.txt";
        //arquivo = "5.algoritmo_3-3_apostila_LA.txt";
        //arquivo = "6.algoritmo_4-5_apostila_LA.txt";
        //arquivo = "7.algoritmo_5-3_apostila_LA.txt";
        //arquivo = "8.algoritmo_6-2_apostila_LA.txt";
        //arquivo = "9.algoritmo_6-9_apostila_LA.txt":
        //arquivo = "12.algoritmo_8-3_apostila_LA.txt";
        arquivo = "18.algoritmo_2-2_apostila_LA.txt";
        
        
        ANTLRInputStream input;
        
        if(isTeste){
            input = new ANTLRInputStream(new FileInputStream("/home/caiodeqmono/Desktop/casosDeTesteT1/2.arquivos_com_erros_semanticos/entrada/"+arquivo));
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
                writer.write(outSintatico.toString()+outSemantico.toString());
            }
        }
        
        
    }
    
}
