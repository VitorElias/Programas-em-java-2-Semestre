package Controlle;

import java.util.ArrayList;
import java.util.List;

public class Validador {
    private List<String> mensagensErro;

    public Validador() {
        mensagensErro = new ArrayList<>();
    }

    public void adicionarMensagemErro(String mensagem) {
        mensagensErro.add(mensagem);
    }

    public void limparMensagensErro() {
        mensagensErro.clear();
    }

    public List<String> getMensagensErro() {
        return mensagensErro;
    }

    public boolean temErros() {
        return !mensagensErro.isEmpty();
    }

    public void validarTexto(String valor, String nomeCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            mensagensErro.add("O campo " + nomeCampo + " não pode estar vazio.");
        }
    }

    public void validarNumeroInteiro(String valor, String nomeCampo) {
        try {
            int numero = Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            mensagensErro.add("O campo " + nomeCampo + " deve conter um número inteiro válido.");
        }
    }

    public void validarNumeroFloat(String valor, String nomeCampo) {
        try {
            float numero = Float.parseFloat(valor);
        } catch (NumberFormatException e) {
            mensagensErro.add("O campo " + nomeCampo + " deve conter um número de ponto flutuante válido.");
        }
    }
}