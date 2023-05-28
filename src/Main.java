import java.time.LocalDate;

public class Main {
	public static void main(String[] args) throws Exception {
	 
		var oficina = new Oficina();
		var pessoa = new Cliente();
		pessoa.Nome="Pedro";
		pessoa.NIF ="248023993";
		
		var veiculo = new Veiculo();
		veiculo.Marca="Ferrari";
		veiculo.Modelo="Modena";
		veiculo.Matricula="XX-00-XX";
		veiculo.Peso=1300;
		
		pessoa = oficina.RegistoCliente(pessoa);
		veiculo = oficina.RegistoVeiculo(pessoa, veiculo);
		var intervencao = oficina.MarcarIntervencao(veiculo, "Verter Óleo", LocalDate.now());
		intervencao.AdicionarPeca("Bujon", 1, 150, "1234567");
	}
}