package Visualização;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Modelo.Movimentacao;

public class Entrada_E_Saida {
   public static String solicitaTitular() {
      String titular;
      titular = JOptionPane.showInputDialog("Qual o nome do titular");
      return titular;
   }

   public static int solicitarTipoDeConta() {
      String[] tipoConta = { "Celecione uma opção", "Conta poupança", "Conta corrente" };
      JComboBox<String> box = new JComboBox<>(tipoConta);
      do {
         JOptionPane.showConfirmDialog(null, box, "Qual o tipo de conta", JOptionPane.OK_CANCEL_OPTION);
         if (box.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Escolha uma opção valida");
         }
      } while (box.getSelectedIndex() == 0);

      return box.getSelectedIndex();
   }

   public static Double solicitaSaldo() {
      Double saldo;
      do {
         saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o saldo na conta?"));
         if (saldo < 0) {
            JOptionPane.showMessageDialog(null, "Impossivel abrir uma conta com valor negativo");
         }
      } while (saldo < 0);

      return saldo;
   }

   public static int solicitaOperacao() {

      String[] operacao = { "Sacar", "Depositar", "Ver saldo da conta", "Ver dados da conta", "Gerar Extrato completo",
            "Gerar extrato de depositos", "Gerar extrato de saques", "Sair do programa" };
      JComboBox<String> opcao = new JComboBox<>(operacao);
      JOptionPane.showConfirmDialog(null, opcao, "Escolha uma operação", JOptionPane.OK_CANCEL_OPTION);
      return opcao.getSelectedIndex();
   }

   public static Double solicitaSaque(Double saldo) {
      Double saque;
      
         saque = Double.parseDouble(JOptionPane.showInputDialog("Quanto voce quer sacar?"));
      
      return saque;
   }

   public static Double solicitaDeposito() {

      Double deposito;
      do {
         deposito = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do deposito?"));
         if (deposito <= 0) {
            JOptionPane.showMessageDialog(null, "O valor não pode ser menor ou igual a 0");
         }
      } while (deposito < 0);
      return deposito;
   }

   public static void exibirSaldo(Double saldo) {
      JOptionPane.showMessageDialog(null, saldo, "Saldo da conta", JOptionPane.OK_CANCEL_OPTION);
   }

   public static void exibirDadosDaConta(String titular, int tipo, Double saldo) {

      StringBuilder sb = new StringBuilder();

      sb.append("Titular: ").append(titular).append("\n");

      if (tipo == 1) {
         sb.append("Tipo: ").append("Conta poupança").append("\n")
               .append("Saldo: ").append("R$:").append(saldo).append("\n");

         JOptionPane.showMessageDialog(null, sb.toString());
      } else {

         sb.append("Tipo: ").append("Conta Corrente").append("\n")

               .append("Saldo: ").append("R$:").append(saldo).append("\n");
         JOptionPane.showMessageDialog(null, sb.toString());
      }

   }

   public static void exibirExtratoCompleto(ArrayList<Movimentacao> listaMovimentacaos) {
      if (listaMovimentacaos.isEmpty()) {
         JOptionPane.showMessageDialog(null, "Nenhuma movimentação realizada.", "Extrato geral",
               JOptionPane.OK_CANCEL_OPTION);
         return;
      }

      StringBuilder sb = new StringBuilder();

      for (int x = 0; x < listaMovimentacaos.size(); x++) {
         Movimentacao mov = listaMovimentacaos.get(x);
         sb.append("\ntipo:");
         if (mov.getTipo() == 1) {
            sb.append("saque" + "\n");
         } else {
            sb.append("Deposito" + "\n");
         }
         sb.append("Valor: R$").append(mov.getValor()).append("\n").append("Data: ")
               .append(mov.getData() + "\n_______");

      }
      JOptionPane.showMessageDialog(null, sb.toString(), "Extrato geral", JOptionPane.OK_OPTION);
   }

   public static void exibirExtratoDeDepositos(ArrayList<Movimentacao> listaMovimentacaos) {
      StringBuilder sb = new StringBuilder();
      boolean houveMovimentacao = false;
      for (Movimentacao mov : listaMovimentacaos) {
         if (mov.getTipo() == 2) {
            houveMovimentacao = true;
            sb.append("\ntipo:")
                  .append("Desposito" + "\n")
                  .append("Valor: R$").append(mov.getValor())
                  .append("\n").append("Data: ")
                  .append(mov.getData() + "\n_______");
         }

      }
      if (houveMovimentacao == true) {
         JOptionPane.showMessageDialog(null, sb.toString(), "Extrato de depositos", JOptionPane.OK_OPTION);

      } else {
         JOptionPane.showMessageDialog(null, "Não Ouve nenhum deposito", "Extrato de depositos",
               JOptionPane.OK_CANCEL_OPTION);
      }

   }

   public static void exibirExtratoSaques(ArrayList<Movimentacao> listaMovimentacaos) {
      StringBuilder sb = new StringBuilder();
      boolean houveMovimentacao = false;
      for (Movimentacao mov : listaMovimentacaos) {

         if (mov.getTipo() == 1) {
            houveMovimentacao = true;
            sb.append("\ntipo:")
                  .append("Saque" + "\n")
                  .append("Valor: R$").append(mov.getValor())
                  .append("\n").append("Data: ")
                  .append(mov.getData() + "\n_______");
         }

      }
      if (houveMovimentacao) {
         JOptionPane.showMessageDialog(null, sb.toString(), "Extrato de saques", JOptionPane.OK_OPTION);

      } else {
         JOptionPane.showMessageDialog(null, "Não Ouve nenhum saque", "Extrato de saque", JOptionPane.OK_CANCEL_OPTION);
      }
   }

   public static void exibirMensagemEncerramento() {
      JOptionPane.showMessageDialog(null, "Encerrando o programa", "encerramento", JOptionPane.OK_OPTION);
   }

}
