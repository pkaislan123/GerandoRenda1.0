package br.com.form;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutosForm {
	
	private String descricao;
	private String inf_complementar;
	private String preco;
	private int codigo_destaque;
	private String link_padrao_vendas;
	private String link_desc_minimo;
	private String link_desc_medio;
	private String link_desc_maximo;
	private String link_brind;
	private String link_checkout;
	private LocalDate data_auteracao;
		
}
