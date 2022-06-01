import javax.swing.JOptionPane;
                                        // nao esquecer de perguntar pq o cpf completo n funciona nem com double
public class Janela {                   // CTRL C CTRL V PROVA + ALTERAR VARIAVEIS E ALTERACAO NAS CONSULTAS N CONSEGUI FAZER A REMOCAO ESTUDAR APOS ENTREGA 
	Professor vetorprof [] = new Professor[20]; // testando com + posicoes
	int posicao = 0;
	int escolha;

	public void janela() {


		do {
			escolha = Integer.parseInt(JOptionPane
					.showInputDialog("1. Registrar novo professor \n 2. Consultar professor \n 3. Remover professor  \n 4. Exibir Dados Prof \n 5. Sair"));

			switch (escolha) {
			case 1:
				registrarprof();
				break;
			case 2:
				consultarprof();
				break;
			case 4:
				exibirprof();
				break;
			}
		} while (escolha != 5);

		
		
	}

	
	
	public void registrarprof() {
		int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF a registrar: "));
		boolean achou = false;
		for (int i = 0; i < posicao; i++) {
			if (cpf == vetorprof[i].cpf) {
				achou = true;
				break;
			}
		}
		if (!achou) {
			vetorprof[posicao] = new Professor();
			vetorprof[posicao].cpf = cpf;
			vetorprof[posicao].nomeprof = JOptionPane.showInputDialog("Nome do professor a ser registrado: ");
			vetorprof[posicao].totaldeaulas = Integer.parseInt(JOptionPane.showInputDialog("Aulas semanais do professor: "));
			vetorprof[posicao].valor = Double.parseDouble(JOptionPane.showInputDialog("Valor/Aula professor: "));
			posicao++;

		} else {
			JOptionPane.showMessageDialog(null, cpf + " Este cpf ja esta registrado no sistema ");
		}
	}
	
	
	
	public int consultarprof() {
		if (posicao < 1) {
			JOptionPane.showMessageDialog(null, "ERROR404 not found");
			return -1;
		} else {
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF do professor a pesquisar: "));

			for (int contador = 0; contador < posicao; contador++) {
				if (vetorprof[contador].cpf == cpf) {
					String aux= "";
					aux += "Nome do professor:  " + vetorprof[contador].nomeprof + "\n";
					aux += "Cpf do professor:  " + vetorprof[contador].cpf + "\n";
					aux += "Total de aulas do professor: " + vetorprof[contador].totaldeaulas + "\n";
					aux += "Valor/Aula do professor: " + vetorprof[contador].valor + "\n";
					aux += "Salario professor a consultar: " + vetorprof[contador].calcsalariobase() + "\n";
					aux += "Valor/Hora atividade do professor: " + vetorprof[contador].horaatv() + "\n";
					aux += "Descanso Semanal do professor: "  + vetorprof[contador].descansoremunerado() + "\n\n";
					JOptionPane.showMessageDialog(null, cpf + " Foi encontrado na posicao: " + (contador + 1) + "\n" + aux);
					return contador;
				}
			}
			JOptionPane.showMessageDialog(null, cpf + " não encontrado!");
			return -1;
		}
	}
	

	public void exibirprof() {
		
		String aux = "";
		
		if (posicao < 1) {
			aux += "Nao ha ninguem registrado";
		} else {
			for (int contador = 0; contador < posicao; contador++) {
				aux += "Nome do professor:  " + (contador + 1) + ": " + vetorprof[contador].nomeprof + "\n";
				aux += "Cpf do professor:  " + (contador + 1) + ": " + vetorprof[contador].cpf + "\n";
				aux += "Total de aulas do professor: " + (contador + 1) + ": " + vetorprof[contador].totaldeaulas + "\n";
				aux += "Valor/Aula do professor: " + (contador + 1) + ": " + vetorprof[contador].valor + "\n";
				aux += "Salario professor: " + (contador + 1) + ": " + vetorprof[contador].calcsalariobase() + "\n";
				aux += "Valor/Hora atividade do professor: " + (contador + 1) + ": " + vetorprof[contador].horaatv() + "\n";
				aux += "Descanso Semanal do professor: " + (contador + 1) + ": " + vetorprof[contador].descansoremunerado() + "\n\n";

			}
		}
		JOptionPane.showMessageDialog(null, aux);
	}

	
	

	
}