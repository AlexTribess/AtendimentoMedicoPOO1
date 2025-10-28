package kaka1;

public class Funcao {

	private int id;
	private String nome;
	private String especialidade;
	
	public Funcao(int id, String nome, String especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcao [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", especialidade=");
		builder.append(especialidade);
		builder.append("]");
		return builder.toString();
	}
	
}
