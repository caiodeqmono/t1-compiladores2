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
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 *
 * @author caiodeqmono
 */
public class Trabalho1Cc2 {

    public static void main(String[] args) throws IOException{
        saidaParser outSintatico = new saidaParser(0);
        saidaParser outSemantico = new saidaParser(1);
        saidaGerador outGerador = new saidaGerador();
     
        ANTLRInputStream input;
        
        File entrada = new File(args[0]);  
        input = new ANTLRInputStream(new FileInputStream(entrada));   
        
        gramaticaLALexer lexer = new gramaticaLALexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        gramaticaLAParser parser = new gramaticaLAParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new AnalisadorSintatico(outSintatico));
        gramaticaLAParser.ProgramaContext arvore = null;
        
        try {
            arvore = parser.programa();
            
            if(outSintatico.toString().isEmpty()){
                AnalisadorSemantico as = new AnalisadorSemantico(outSemantico);
                as.visitPrograma(arvore);
            }
        } catch(ParseCancellationException pce) {
            outSintatico.println(pce.getMessage());
        }

        String errors = outSintatico.toString()+outSemantico.toString();
        
        if(errors.isEmpty()){
            try {
                Gerador as = new Gerador(outGerador);
                as.visitPrograma(arvore);  
                
                
            } catch(ParseCancellationException pce) {
                outSintatico.println(pce.getMessage());
                
            }
        }
       
        if(errors.isEmpty()){
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(args[1]), "utf-8"))) {
                    writer.write(outGerador.toString());
            }
        }else{
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(args[1]), "utf-8"))) {
                writer.write(outSintatico.toString()+outSemantico.toString()+"Fim da compilacao\n");
            }
        }
    }
}
