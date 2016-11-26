// Generated from NetBeansProjects/trabalho1/src/trabalho1/gramaticaLA.g4 by ANTLR 4.5.3
package trabalho1;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramaticaLAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramaticaLAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(gramaticaLAParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(gramaticaLAParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(gramaticaLAParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(gramaticaLAParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(gramaticaLAParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#mais_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais_var(gramaticaLAParser.Mais_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(gramaticaLAParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#ponteiros_opcionais}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPonteiros_opcionais(gramaticaLAParser.Ponteiros_opcionaisContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#outros_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutros_ident(gramaticaLAParser.Outros_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(gramaticaLAParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(gramaticaLAParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#mais_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais_ident(gramaticaLAParser.Mais_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#mais_variaveis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais_variaveis(gramaticaLAParser.Mais_variaveisContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(gramaticaLAParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(gramaticaLAParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(gramaticaLAParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(gramaticaLAParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(gramaticaLAParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(gramaticaLAParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#parametros_opcional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros_opcional(gramaticaLAParser.Parametros_opcionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(gramaticaLAParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#var_opcional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_opcional(gramaticaLAParser.Var_opcionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#mais_parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais_parametros(gramaticaLAParser.Mais_parametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#declaracoes_locais}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes_locais(gramaticaLAParser.Declaracoes_locaisContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(gramaticaLAParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#comandos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandos(gramaticaLAParser.ComandosContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(gramaticaLAParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#mais_expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais_expressao(gramaticaLAParser.Mais_expressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#senao_opcional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenao_opcional(gramaticaLAParser.Senao_opcionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#chamada_atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChamada_atribuicao(gramaticaLAParser.Chamada_atribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#argumentos_opcional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos_opcional(gramaticaLAParser.Argumentos_opcionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(gramaticaLAParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#mais_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais_selecao(gramaticaLAParser.Mais_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(gramaticaLAParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#mais_constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais_constantes(gramaticaLAParser.Mais_constantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(gramaticaLAParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#intervalo_opcional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalo_opcional(gramaticaLAParser.Intervalo_opcionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#op_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_unario(gramaticaLAParser.Op_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(gramaticaLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#op_multiplicacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_multiplicacao(gramaticaLAParser.Op_multiplicacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#op_adicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_adicao(gramaticaLAParser.Op_adicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(gramaticaLAParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#outros_termos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutros_termos(gramaticaLAParser.Outros_termosContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(gramaticaLAParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#outros_fatores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutros_fatores(gramaticaLAParser.Outros_fatoresContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(gramaticaLAParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(gramaticaLAParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(gramaticaLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#outras_parcelas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutras_parcelas(gramaticaLAParser.Outras_parcelasContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#chamada_partes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChamada_partes(gramaticaLAParser.Chamada_partesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(gramaticaLAParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#op_opcional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_opcional(gramaticaLAParser.Op_opcionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(gramaticaLAParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(gramaticaLAParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#op_nao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_nao(gramaticaLAParser.Op_naoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(gramaticaLAParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#outros_termos_logicos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutros_termos_logicos(gramaticaLAParser.Outros_termos_logicosContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#outros_fatores_logicos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutros_fatores_logicos(gramaticaLAParser.Outros_fatores_logicosContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(gramaticaLAParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(gramaticaLAParser.Parcela_logicaContext ctx);
}