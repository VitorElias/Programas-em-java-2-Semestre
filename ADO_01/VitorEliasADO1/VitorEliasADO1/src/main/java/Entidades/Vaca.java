/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author vitor
 */
public class Vaca {

    private String nome;
    private int idade;
    private String porte;
    private String pelagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String Pelagem) {
        this.pelagem = Pelagem;
    }

    public void Andar() {
        System.out.println(nome + " está andando");
    }

    public void Parar() {
        System.out.println(nome + " está parada.");
    }

    public void Alimentar() {
        System.out.println(nome + " está comendo.");
    }

    public void ProduzirLeite() {
        System.out.println(nome + " esta produzindo leite.");

    }

    public Vaca() {

    }

    public Vaca(String nome, int idade, String porte, String pelagem) {

        this.nome = nome;
        this.idade = idade;
        this.porte = porte;
        this.pelagem = pelagem;
    }

}
