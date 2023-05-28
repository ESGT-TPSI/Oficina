import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {

	@Test
	void ClienteEstaVazio() {
		var client = new Cliente();

		assertEquals(client.ValidaDados(), false);
	}
	
	@Test
	void ClienteNomeEstaNULL() {
		var client = new Cliente();
		client.Nome =null;
		client.NIF="000000000";
		assertEquals(client.ValidaDados(), false);
	}
	@Test
	void ClienteNIFEstaNULL() {
		var client = new Cliente();
		client.Nome ="Pedro";
		client.NIF=null;
		assertEquals(client.ValidaDados(), false);
	}

	@Test
	void ClienteEstaOK() {
		var client = new Cliente();
		client.Nome="Pedro Torrezão";
		client.NIF="000000000";
		assertEquals(client.ValidaDados(), true);
	}
	
	@Test
	void ClienteNaoTemNome() {
		var client = new Cliente();
		client.NIF="000000000";
		assertEquals(client.ValidaDados(), false);
	}
	

	@Test
	void ClienteNaoTemNIF() {
		var client = new Cliente();
		client.Nome="Pedro Torrezão";
		assertEquals(client.ValidaDados(), false);
	}
	

	@Test
	void ClienteTemNIFCom8Digitos() {
		var client = new Cliente();
		client.Nome="Pedro Torrezão";
		client.NIF="00000000";
		assertEquals(client.ValidaDados(), false);

		client.NIF="00000000000";
		assertEquals(client.ValidaDados(), false);
	}
}
