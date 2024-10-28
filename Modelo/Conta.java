package Modelo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;


public class Conta {
    private String titularDaConta;
    private int tipoConta;
    private Double saldo;

    ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<>();

    public ArrayList<Movimentacao> getListaDeMovimentacao() {
        return listaDeMovimentacao;
    }

    public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
        this.listaDeMovimentacao = listaDeMovimentacao;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTitularDaConta() {
        return titularDaConta;
    }

    public void setTitularDaConta(String titularDaConta) {
        this.titularDaConta = titularDaConta;
    }

    public void depositar(Double valor) {
        Movimentacao movimentacao = new Movimentacao();
        saldo += valor;
        movimentacao.setTipo(2);
        movimentacao.setValor(valor);
        movimentacao.setData(new Date());
        listaDeMovimentacao.add(movimentacao);
    }

    public void sacar(Double valor) {
        Movimentacao movimentacao = new Movimentacao();
        saldo -= valor;
        if (saldo < -1000) {
            JOptionPane.showMessageDialog(null, "Não é possivel deixar a conta com menos de R$1000 negativos", "saque", JOptionPane.OK_OPTION);
            saldo+=valor;
        }
        movimentacao.setTipo(1);
        movimentacao.setValor(valor);
        movimentacao.setData(new Date());
        listaDeMovimentacao.add(movimentacao);

    }

}
