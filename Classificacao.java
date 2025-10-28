import java.time.Duration;

public class Classificacao {

	private int cor;
	private String descricao;
	private Duration tempoEspera;

	public Classificacao(int cor, String descricao, Duration tempoEspera) {
		super();
		this.cor = cor;
		this.descricao = descricao;
		this.tempoEspera = tempoEspera;
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Duration getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(Duration tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Classificacao [cor=");
		builder.append(cor);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", tempoEspera=");
		builder.append(tempoEspera);
		builder.append("]");
		return builder.toString();
	}
	
	
}
