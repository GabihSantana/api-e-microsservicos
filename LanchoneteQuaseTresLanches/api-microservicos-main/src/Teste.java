/**
 *  TDD: Classe de Teste das funcionalidades do delivery *  
 *  Garante que, em caso de manutenção, o resultado continue sendo o mesmo, garantindo a funcionalidade esperada do programa.
 */

import entidades.Caixa;
import entidades.Lanche;
import entidades.Pedido;
import entidades.Pizza;
import entidades.Salgadinho;
import enums.LancheMolhoSelecao;
import enums.LanchePaoSelecao;
import enums.LancheRecheioSelecao;
import enums.PizzaBordaSelecao;
import enums.PizzaMolhoSelecao;
import enums.PizzaRecheioSelecao;
import enums.SalgadoMassaSelecao;
import enums.SalgadoRecheioSelecao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class Teste {	
	 @Test
	    void testePedidoPizzaComValores() {
	        Pedido pedido = new Pedido();
	        pedido.setNomeCliente("July");

	        Pizza pizza = new Pizza(
	            PizzaMolhoSelecao.TOMATE,      	
	            PizzaRecheioSelecao.BROCOLIS,    
	            PizzaBordaSelecao.CHEDDAR,      
	            35.0,                          
	            LocalDate.now().plusDays(2),   
	            0.8                            
	        );

	        pedido.addItemConsumido(pizza);
	        
	        // validar o preço da pizza
	        assertEquals(46.0, pizza.calcularPreco());
	    }
	 
	 @Test
	    void testePedidoLancheComValores() {
	        Pedido pedido = new Pedido();
	        pedido.setNomeCliente("July");

	        Lanche lanche = new Lanche(
	        	LanchePaoSelecao.AUSTRALIANO,      	
	        	LancheRecheioSelecao.XBURGUER,    
	        	LancheMolhoSelecao.ROSE,      
	            35.0,                          
	            LocalDate.now().plusDays(2),   
	            0.4                            
	        );

	        pedido.addItemConsumido(lanche);

	        assertEquals(19.0, lanche.calcularPreco());
	    }
	 
	 @Test
		  void testePedidoSalgadosComValores() {
		        Pedido pedido = new Pedido();
		        pedido.setNomeCliente("July");
	
		        Salgadinho salgados = new Salgadinho(
		        	SalgadoRecheioSelecao.BROCOLIS,      	
		        	SalgadoMassaSelecao.ASSADA,    
		            35.0,                          
		            LocalDate.now().plusDays(2),   
		            0.2                            
		        );
	
		        pedido.addItemConsumido(salgados);
	
		        assertEquals(9, salgados.calcularPreco());
		        
		    }
	 
	 @Test
	 	void testeTrocoCliente() {
	 	Caixa caixa = new Caixa();
	 	
	 	caixa.setValorPago(50.0);
	    assertEquals(25, caixa.calcularTroco(25.0));
	 }
}
