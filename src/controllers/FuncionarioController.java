package controllers;

import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Funcionario;
import enums.TipoContratacao;
import repositories.FuncionarioRepository;

public class FuncionarioController {

	public void cadastrarFuncionario() {

		var funcionario = new Funcionario();

		try {
			funcionario.setId(UUID.randomUUID());
			funcionario.setNome(JOptionPane.showInputDialog("Informe o nome do funcionário:"));
			funcionario.setMatricula(JOptionPane.showInputDialog("Informe a matrícula do funcionário:"));
			funcionario.setDataDeAdmissao(new SimpleDateFormat("dd/MM/yyyy")
					.parse(JOptionPane.showInputDialog("Informe a data de admissão:")));

			var opcao = JOptionPane.showInputDialog("Informe (1)Estágio, (2)CLT ou (3)Terceirazado:");
			switch (opcao) {
			case "1":
				funcionario.setTipoContratacao(TipoContratacao.ESTAGIO);
				break;
			case "2":
				funcionario.setTipoContratacao(TipoContratacao.CLT);
				break;
			case "3":
				funcionario.setTipoContratacao(TipoContratacao.TERCEIRIZADO);
				break;

			}
			var funcionarioRepository = new FuncionarioRepository();
			funcionarioRepository.exportaDados(funcionario);

		} catch (Exception e) {
			System.out.println("\nFalha ao capturar os dados:" + e.getMessage());
		}

	}

}
