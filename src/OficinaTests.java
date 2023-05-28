import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class OficinaTests {

	@Test
	void Valido() throws Exception {
		// Arrange
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

		// Execute
		intervencao= oficina.FecharIntervencao(	intervencao);
		
		// Assert
		assertEquals(intervencao.Total, 150);
		assertEquals(intervencao.EstaFechado, true);
	}
	
	@Test
	void InvValido() throws Exception {
		// Arrange
		var oficina = new Oficina();
		var pessoa = new Cliente();
		pessoa.Nome="Pedro";
		pessoa.NIF ="248023993";
		
		var veiculo = new Veiculo();
		veiculo.Marca="Ferrari";
		veiculo.Modelo="Modena";
		veiculo.Matricula="XX-00-XX";
		veiculo.Peso=1300;
		
		//pessoa = oficina.RegistoCliente(pessoa);
		//veiculo = oficina.RegistoVeiculo(pessoa, veiculo);
		veiculo.NrVeiculo = 30000;
		assertThrows(Exception.class, () -> {
			oficina.MarcarIntervencao(null, "Verter Óleo", LocalDate.now());
		});
	}
	
	
}
