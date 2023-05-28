import java.time.LocalDate;
import java.util.ArrayList;

public class Intervencao {
	public String PedidoCliente="";
	public Boolean EstaFechado=false;
	public LocalDate Date;
	public int NrVeiculo;
	public int NrIntervencao;

	public ArrayList<ItemIntervencao> ItemIntervencao= new ArrayList<>();;
	public int Total;
	public void AdicionarPeca(String NomePeca, int quantidade, double preco, String nrSerie) throws Exception {

		// Validar Dados Peça 
		 if(NomePeca== null || NomePeca.length()==0)
			 throw new Exception("Peça Inválida");
		
		// Adicinar à minha lista de Items Intervenca
		 var itemIn=new ItemIntervencao();
		 itemIn.Nome= NomePeca;
		 itemIn.Quantidade= quantidade;
		 itemIn.Preco= preco;
		 itemIn.NrSerie= nrSerie;
		 
		 
		 ItemIntervencao.add(itemIn);
		
	}
	public void AdicionarMaoObra() {}
	
}
