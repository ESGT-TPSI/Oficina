import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VeiculoTests {

	@Test
	void DefaultInvalido() {
		var veiculo = new Veiculo();

		assertEquals(veiculo.ValidaDados(), false);
	}
	@Test
	void ApenasMarca() {
		var veiculo = new Veiculo();
		veiculo.Marca="Ferrari";
		assertEquals(veiculo.ValidaDados(), false);
	}
	@Test
	void ApenasModelo() {
		var veiculo = new Veiculo();
		veiculo.Modelo="Modena";
		assertEquals(veiculo.ValidaDados(), false);
	}
	@Test
	void ApenasMatricula() {
		var veiculo = new Veiculo();
		veiculo.Matricula="XX-00-XX";
		assertEquals(veiculo.ValidaDados(), false);
	}
	@Test
	void ApenasPeso() {
		var veiculo = new Veiculo();
		veiculo.Peso=1000;
		assertEquals(veiculo.ValidaDados(), false);
	}
	@Test
	void Valido() {
		var veiculo = new Veiculo();
		veiculo.Marca="Ferrari";
		veiculo.Peso=100;
		veiculo.Matricula="XX-00-XX";
		veiculo.Modelo="Modena";
		assertEquals(veiculo.ValidaDados(), true);
	}
	@Test
	void Invalido_MarcaVazia() {
		var veiculo = new Veiculo();
		veiculo.Marca="";
		assertEquals(veiculo.ValidaDados(), false);
	}
	@Test
	void Invalido_ModeloVazia() {
		var veiculo = new Veiculo();
		veiculo.Modelo="";
		assertEquals(veiculo.ValidaDados(), false);
	}

	@Test
	void Invalido_MatriculaVazia() {
		var veiculo = new Veiculo();
		veiculo.Matricula="";
		assertEquals(veiculo.ValidaDados(), false);
	}
}
