
public class Funcionario extends Pessoa {

	private int id;
	private Funcao funcao;
		
	public Funcionario(int id, Funcao funcao) {
		super();
		this.id = id;
		this.funcao = funcao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	
}
