package repositories;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import entities.Funcionario;

public class FuncionarioRepository {

	public void exportaDados(Funcionario funcionario) {

		try {

			var fileWriter = new FileWriter("d:\\temp\\funcionario.txt", true);
			var printWriter = new PrintWriter(fileWriter);

			printWriter.write("\nId do funicinário...: " + funcionario.getId());
			printWriter.write("\nNome................: " + funcionario.getNome());
			printWriter.write("\nMatrícula...........: " + funcionario.getMatricula());
			printWriter.write("\nData de admissão....: " + funcionario.getDataDeAdmissao());
			printWriter.write("\nTipo de contratação.: " + funcionario.getTipoContratacao());
			printWriter.write("\n");

			printWriter.close();

			JOptionPane.showMessageDialog(null, "Dados gravados com seucesso!");

		} catch (Exception e) {
			System.out.println("\nFalha ao gravar o arquivo: " + e.getMessage());
		}

	}
}
