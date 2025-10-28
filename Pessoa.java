import java.time.LocalDate;
import java.time.Period;


public class Pessoa {

	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	
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
		if(nome.length() > 3)
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf.length() == 14)
		this.cpf = cpf;
	}

	public int calcularIdade() {
		Period periodo = Period.between(dataNascimento, LocalDate.now());

		int anos = periodo.getYears();

		return anos;
	}
	
}
