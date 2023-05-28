
import java.time.LocalDate;
import java.util.ArrayList;

public class Oficina {
	
	public ArrayList<Cliente> Clientes = new ArrayList<>();
	public ArrayList<Veiculo> Veiculos = new ArrayList<>();
	public ArrayList<Intervencao> Intervencoes= new ArrayList<>();
	
	// Inserir em BD o Cliente
	public Cliente RegistoCliente(Cliente pessoa) throws Exception
	{ 
		// Validar Dados 
		if(!pessoa.ValidaDados())
			throw new Exception("Dados Invalidos");
		
		// Valida se cliente está no sistema.
		for (Cliente cliente : Clientes) {
			if(cliente.NIF == pessoa.NIF)
			{
				throw new Exception("NIF já em sistema");
			}
		}
		
		// Dar Nr de Cliente
		pessoa.NrCliente = Clientes.size()+1;
		
		// Adicionar à "Base de Dados"
		Clientes.add(pessoa);
		
		return pessoa;
	}
	
	public Veiculo RegistoVeiculo(Cliente pessoa, Veiculo veiculo) throws Exception
	{ 
		Boolean clienteExiste = false;
		
		// Verificar se o Cliente na BD
		for (Cliente cliente : Clientes) {
			if(pessoa.NrCliente == cliente.NrCliente)
				clienteExiste=true;
		}
		
		if(!clienteExiste)
			throw new Exception("Cliente não Existe");
		
		// Verificar Dados Veiculo Valido
		if(!veiculo.ValidaDados())
			throw new Exception("Veiculo Invalido");
		
		// Adicionar à "BD"
		veiculo.NrVeiculo = Veiculos.size()+1;
		Veiculos.add(veiculo);
		
		return veiculo;
	}
	
	public Intervencao MarcarIntervencao(Veiculo veiculo, String PedidoCliente, LocalDate data) throws Exception
	{ 
		boolean veiculoExiste=false;
		boolean intervencaoCoincideComOutra=false;
		
		// Confirma que Veiculo Existe Em sistem
		for (Veiculo veiculoInDB : Veiculos) {
			if(veiculoInDB.NrVeiculo == veiculo.NrVeiculo)
				veiculoExiste= true;
		}
		
		if(!veiculoExiste)
			throw new Exception("Veiculo não Existe");
		
		// Confirmar Data disponivel (um por dia)
		for (Intervencao intervencao : Intervencoes) {
			if(intervencao.Date.atStartOfDay() == data.atStartOfDay())
				intervencaoCoincideComOutra= true;
		}

		if(intervencaoCoincideComOutra)
			throw new Exception("Dia já Ocupado");
		
		// Cria instancia Intervencao
		var inte = new Intervencao();
		inte.Date = data;
		inte.NrVeiculo = veiculo.NrVeiculo;
		inte.PedidoCliente = PedidoCliente;
		
		// Adiciona à "BD"
		inte.NrIntervencao = Intervencoes.size()+1;
		Intervencoes.add(inte);
		
		// Devolve Intervencao
		return inte;
	}
	
	public Intervencao FecharIntervencao(Intervencao intervencao)
	{ 
		var total=0;
		// Calcular Total
		for (ItemIntervencao itemInter : intervencao.ItemIntervencao) {
			total+=(itemInter.Preco*itemInter.Quantidade);
		}

		// Intervencao Fechada
		intervencao.Total= total;
		intervencao.EstaFechado = true;
		
		return intervencao;
	}
}
