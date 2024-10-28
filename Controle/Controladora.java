package Controle;

import javax.swing.JOptionPane;
import Modelo.Conta;
import Visualização.Entrada_E_Saida;

public class Controladora {
  public void exibirMenu() {
    int operacao;

    // Criando a conta
    JOptionPane.showMessageDialog(null, "Você criou uma conta!!");
    Conta conta = new Conta();
    conta.setTitularDaConta(Entrada_E_Saida.solicitaTitular());
    conta.setTipoConta(Entrada_E_Saida.solicitarTipoDeConta());
    conta.setSaldo(Entrada_E_Saida.solicitaSaldo());

    do {
      operacao = Entrada_E_Saida.solicitaOperacao();
      Double valor;
      switch (operacao) {
        case 0:
          valor = Entrada_E_Saida.solicitaSaque(conta.getSaldo());
          conta.sacar(valor);
          break;
        case 1:
          valor = Entrada_E_Saida.solicitaDeposito();
          conta.depositar(valor);
          break;
        case 2:
          Entrada_E_Saida.exibirSaldo(conta.getSaldo());
          break;
        case 3:
          Entrada_E_Saida.exibirDadosDaConta(conta.getTitularDaConta(), conta.getTipoConta(), conta.getSaldo());
          break;
        case 4:
          Entrada_E_Saida.exibirExtratoCompleto(conta.getListaDeMovimentacao());
          break;
        case 5:
          Entrada_E_Saida.exibirExtratoDeDepositos(conta.getListaDeMovimentacao());
          break;
        case 6:
          Entrada_E_Saida.exibirExtratoSaques(conta.getListaDeMovimentacao());
          break;
        default:
      }
    } while (operacao != 7);
    Entrada_E_Saida.exibirMensagemEncerramento();
    System.exit(0);
  }
}
