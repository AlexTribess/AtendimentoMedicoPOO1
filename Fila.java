import java.util.List;

public class Fila {

	private int id;
	private List<Paciente> pacientes;
		
	public Fila(int id, List<Paciente> pacientes) {
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
	
	public boolean adicionarPaciente(Paciente paciente){
		pacientes.add(paciente);	
		return true;
	}
	
	public boolean chamarProximo() {
		Paciente paciente = pacientes.getFirst();	
		System.out.println("Atendimento de " + paciente);
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fila [id=");
		builder.append(id);
		builder.append(", pacientes=");
		builder.append(pacientes);
		builder.append("]");
		return builder.toString();
	}
	
}
