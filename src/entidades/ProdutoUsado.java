package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	private Date dataValidade;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ProdutoUsado(String nome, Double preco, Date dataValidade) {
		super(nome, preco);
		this.dataValidade = dataValidade;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	@Override
	public String etiquetaPreco() {
		return nome 
				+ " (Usado) R$ " 
				+ String.format("%.2f", preco) 
				+ " (Data de validade: " 
				+ sdf.format(dataValidade)
				+ ")";
	}
}