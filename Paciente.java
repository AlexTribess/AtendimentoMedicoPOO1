import java.util.List;

public class Paciente extends Pessoa {

	private int id;
	private Classificacao nivel;
	private List<String> perguntas;
		
	public Paciente(int id, Classificacao nivel, List<String> perguntas) {
		super();
		this.id = id;
		this.nivel = nivel;
		this.perguntas = perguntas;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Classificacao getNivel() {
		return nivel;
	}
	public void setNivel(Classificacao nivel) {
		this.nivel = nivel;
	}
	public List<String> getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(List<String> perguntas) {
		this.perguntas = perguntas;
	}
	
	public int getPrioridadeNumerica() {
        
        if (this.nivel == null) {
            return 5; 
        }
        return this.nivel.getPrioridadeNumerica(); 
    }
	
}
