package br.com.igor.arquivomultiplosformatosjob.dominio;

public class Livros {
	private String nome;
	private String valor;
	private String id;
	private String tpMovimento;
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTpMovimento() {
		return tpMovimento;
	}

	public void setTpMovimento(String tpMovimento) {
		this.tpMovimento = tpMovimento;
	}


	@Override
	public String toString() {
		return "Livri{" +
	                "nome='" + nome + "'" +
	                ", preco ='" + valor + "'" +
	                ", id='" + id + "'" +
	                ", Tipo Movimento='" + tpMovimento + "'" +
	                '}';
	}
}
