
public class Veiculo {

	public String Matricula;
	public String Marca;
	public String Modelo;
	public int Peso;
	public int NrVeiculo;
	
	public boolean ValidaDados() {
		
		if ( this.Marca ==null|| this.Marca.length()==0)
			return false;
		if ( this.Modelo ==null || this.Modelo.length()==0 )
			return false;
		if (this.Matricula == null || this.Matricula.length()==0)
			return false;
		if (this.Peso<=0)
			return false;
		return true;
	}

}
