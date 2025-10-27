import java.util.List;

public class Fila {

	private int id;
	private List<Paciente> pacientes;
		
	public Fila(int id, List<Paciente> pacientes) {
		super();
		this.id = id;
		this.pacientes = pacientes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	
	
}
