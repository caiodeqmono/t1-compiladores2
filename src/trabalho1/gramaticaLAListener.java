// Generated from NetBeansProjects/trabalho1/src/trabalho1/gramaticaLA.g4 by ANTLR 4.5.3
package trabalho1;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramaticaLAParser}.
 */
public interface gramaticaLAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(gramaticaLAParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(gramaticaLAParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(gramaticaLAParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(gramaticaLAParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(gramaticaLAParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(gramaticaLAParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(gramaticaLAParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(gramaticaLAParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(gramaticaLAParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(gramaticaLAParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#mais_var}.
	 * @param ctx the parse tree
	 */
	void enterMais_var(gramaticaLAParser.Mais_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#mais_var}.
	 * @param ctx the parse tree
	 */
	void exitMais_var(gramaticaLAParser.Mais_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(gramaticaLAParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(gramaticaLAParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#ponteiros_opcionais}.
	 * @param ctx the parse tree
	 */
	void enterPonteiros_opcionais(gramaticaLAParser.Ponteiros_opcionaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#ponteiros_opcionais}.
	 * @param ctx the parse tree
	 */
	void exitPonteiros_opcionais(gramaticaLAParser.Ponteiros_opcionaisContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#outros_ident}.
	 * @param ctx the parse tree
	 */
	void enterOutros_ident(gramaticaLAParser.Outros_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#outros_ident}.
	 * @param ctx the parse tree
	 */
	void exitOutros_ident(gramaticaLAParser.Outros_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(gramaticaLAParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(gramaticaLAParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(gramaticaLAParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(gramaticaLAParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#mais_ident}.
	 * @param ctx the parse tree
	 */
	void enterMais_ident(gramaticaLAParser.Mais_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#mais_ident}.
	 * @param ctx the parse tree
	 */
	void exitMais_ident(gramaticaLAParser.Mais_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#mais_variaveis}.
	 * @param ctx the parse tree
	 */
	void enterMais_variaveis(gramaticaLAParser.Mais_variaveisContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#mais_variaveis}.
	 * @param ctx the parse tree
	 */
	void exitMais_variaveis(gramaticaLAParser.Mais_variaveisContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(gramaticaLAParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(gramaticaLAParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(gramaticaLAParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(gramaticaLAParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(gramaticaLAParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(gramaticaLAParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(gramaticaLAParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(gramaticaLAParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(gramaticaLAParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(gramaticaLAParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(gramaticaLAParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(gramaticaLAParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#parametros_opcional}.
	 * @param ctx the parse tree
	 */
	void enterParametros_opcional(gramaticaLAParser.Parametros_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#parametros_opcional}.
	 * @param ctx the parse tree
	 */
	void exitParametros_opcional(gramaticaLAParser.Parametros_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(gramaticaLAParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(gramaticaLAParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#var_opcional}.
	 * @param ctx the parse tree
	 */
	void enterVar_opcional(gramaticaLAParser.Var_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#var_opcional}.
	 * @param ctx the parse tree
	 */
	void exitVar_opcional(gramaticaLAParser.Var_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#mais_parametros}.
	 * @param ctx the parse tree
	 */
	void enterMais_parametros(gramaticaLAParser.Mais_parametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#mais_parametros}.
	 * @param ctx the parse tree
	 */
	void exitMais_parametros(gramaticaLAParser.Mais_parametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#declaracoes_locais}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes_locais(gramaticaLAParser.Declaracoes_locaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#declaracoes_locais}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes_locais(gramaticaLAParser.Declaracoes_locaisContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(gramaticaLAParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(gramaticaLAParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(gramaticaLAParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(gramaticaLAParser.ComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(gramaticaLAParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(gramaticaLAParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#mais_expressao}.
	 * @param ctx the parse tree
	 */
	void enterMais_expressao(gramaticaLAParser.Mais_expressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#mais_expressao}.
	 * @param ctx the parse tree
	 */
	void exitMais_expressao(gramaticaLAParser.Mais_expressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#senao_opcional}.
	 * @param ctx the parse tree
	 */
	void enterSenao_opcional(gramaticaLAParser.Senao_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#senao_opcional}.
	 * @param ctx the parse tree
	 */
	void exitSenao_opcional(gramaticaLAParser.Senao_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#chamada_atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterChamada_atribuicao(gramaticaLAParser.Chamada_atribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#chamada_atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitChamada_atribuicao(gramaticaLAParser.Chamada_atribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#argumentos_opcional}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos_opcional(gramaticaLAParser.Argumentos_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#argumentos_opcional}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos_opcional(gramaticaLAParser.Argumentos_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(gramaticaLAParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(gramaticaLAParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#mais_selecao}.
	 * @param ctx the parse tree
	 */
	void enterMais_selecao(gramaticaLAParser.Mais_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#mais_selecao}.
	 * @param ctx the parse tree
	 */
	void exitMais_selecao(gramaticaLAParser.Mais_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(gramaticaLAParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(gramaticaLAParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#mais_constantes}.
	 * @param ctx the parse tree
	 */
	void enterMais_constantes(gramaticaLAParser.Mais_constantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#mais_constantes}.
	 * @param ctx the parse tree
	 */
	void exitMais_constantes(gramaticaLAParser.Mais_constantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(gramaticaLAParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(gramaticaLAParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#intervalo_opcional}.
	 * @param ctx the parse tree
	 */
	void enterIntervalo_opcional(gramaticaLAParser.Intervalo_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#intervalo_opcional}.
	 * @param ctx the parse tree
	 */
	void exitIntervalo_opcional(gramaticaLAParser.Intervalo_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(gramaticaLAParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(gramaticaLAParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(gramaticaLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(gramaticaLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#op_multiplicacao}.
	 * @param ctx the parse tree
	 */
	void enterOp_multiplicacao(gramaticaLAParser.Op_multiplicacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#op_multiplicacao}.
	 * @param ctx the parse tree
	 */
	void exitOp_multiplicacao(gramaticaLAParser.Op_multiplicacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#op_adicao}.
	 * @param ctx the parse tree
	 */
	void enterOp_adicao(gramaticaLAParser.Op_adicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#op_adicao}.
	 * @param ctx the parse tree
	 */
	void exitOp_adicao(gramaticaLAParser.Op_adicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(gramaticaLAParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(gramaticaLAParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#outros_termos}.
	 * @param ctx the parse tree
	 */
	void enterOutros_termos(gramaticaLAParser.Outros_termosContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#outros_termos}.
	 * @param ctx the parse tree
	 */
	void exitOutros_termos(gramaticaLAParser.Outros_termosContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(gramaticaLAParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(gramaticaLAParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#outros_fatores}.
	 * @param ctx the parse tree
	 */
	void enterOutros_fatores(gramaticaLAParser.Outros_fatoresContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#outros_fatores}.
	 * @param ctx the parse tree
	 */
	void exitOutros_fatores(gramaticaLAParser.Outros_fatoresContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(gramaticaLAParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(gramaticaLAParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(gramaticaLAParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(gramaticaLAParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(gramaticaLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(gramaticaLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#outras_parcelas}.
	 * @param ctx the parse tree
	 */
	void enterOutras_parcelas(gramaticaLAParser.Outras_parcelasContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#outras_parcelas}.
	 * @param ctx the parse tree
	 */
	void exitOutras_parcelas(gramaticaLAParser.Outras_parcelasContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#chamada_partes}.
	 * @param ctx the parse tree
	 */
	void enterChamada_partes(gramaticaLAParser.Chamada_partesContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#chamada_partes}.
	 * @param ctx the parse tree
	 */
	void exitChamada_partes(gramaticaLAParser.Chamada_partesContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(gramaticaLAParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(gramaticaLAParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#op_opcional}.
	 * @param ctx the parse tree
	 */
	void enterOp_opcional(gramaticaLAParser.Op_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#op_opcional}.
	 * @param ctx the parse tree
	 */
	void exitOp_opcional(gramaticaLAParser.Op_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(gramaticaLAParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(gramaticaLAParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(gramaticaLAParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(gramaticaLAParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#op_nao}.
	 * @param ctx the parse tree
	 */
	void enterOp_nao(gramaticaLAParser.Op_naoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#op_nao}.
	 * @param ctx the parse tree
	 */
	void exitOp_nao(gramaticaLAParser.Op_naoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(gramaticaLAParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(gramaticaLAParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#outros_termos_logicos}.
	 * @param ctx the parse tree
	 */
	void enterOutros_termos_logicos(gramaticaLAParser.Outros_termos_logicosContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#outros_termos_logicos}.
	 * @param ctx the parse tree
	 */
	void exitOutros_termos_logicos(gramaticaLAParser.Outros_termos_logicosContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#outros_fatores_logicos}.
	 * @param ctx the parse tree
	 */
	void enterOutros_fatores_logicos(gramaticaLAParser.Outros_fatores_logicosContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#outros_fatores_logicos}.
	 * @param ctx the parse tree
	 */
	void exitOutros_fatores_logicos(gramaticaLAParser.Outros_fatores_logicosContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(gramaticaLAParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(gramaticaLAParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(gramaticaLAParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(gramaticaLAParser.Parcela_logicaContext ctx);
}