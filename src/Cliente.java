
public class Cliente {

	public String Nome = "";
	public String NIF ="";
	public int NrCliente;
	
	public boolean ValidaDados() {
		
		// Valida Nome == null OU Valida Nome Length 0   
		if (this.Nome == null || this.Nome.length() == 0)
			return false;
		
		// Valida NIF Length 0
		// Valida NIF != null
		// Valida NIF  Length == 9
		if (this.NIF == null || this.NIF.length() != 9)
			return false;
		
		return true;
	}

}
