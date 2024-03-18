/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Computador;

/**
 *
 * @author vitor
 */
public class sql {

    static String url = "jdbc:mysql://localhost:3306/lojainformatica?serverTimezone=America/Sao_Paulo&useSSL=false";
    static String login = "admin";
    static String senha = "admin";

    public static boolean salvarNoBanco(Computador pc) {
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean sucesso = false;

        try {
            // Carregando o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecendo a conexão com o banco de dados
            conexao = DriverManager.getConnection(url, login, senha);

            // Preparando a declaração SQL para inserção
            comandoSQL = conexao.prepareStatement("INSERT INTO computador(marca, hd, processador) VALUES(?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            // Preenchendo os parâmetros da declaração SQL com os dados 
            comandoSQL.setString(1, pc.getMarca());
            comandoSQL.setInt(2, pc.getHd());
            comandoSQL.setString(3, pc.getProcessador());

            // Executando a atualização no banco de dados e obtendo o número de linhas afetadas
            int lA= comandoSQL.executeUpdate();

            // Verificando se a operação foi bem-sucedida com base no número de linhas afetadas
            if (lA > 0) {
                sucesso = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
          
            Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                   
                    Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return sucesso;

    }

    public static ArrayList<Computador> listarNoBanco() {
        ArrayList<Computador> listaPC = new ArrayList<>();
        Connection conectar = null;
        PreparedStatement comandoSQL = null;
        ResultSet re = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(url, login, senha);
            comandoSQL = conectar.prepareStatement("SELECT * FROM computador");
            re = comandoSQL.executeQuery();

            if (re != null) {
                while (re.next()) {
                    Computador computador = new Computador();
                    computador.setHd(re.getInt("hd"));
                    computador.setProcessador(re.getString("processador"));
                    computador.setId(re.getInt("id"));
                    computador.setMarca(re.getString("marca"));
                    listaPC.add(computador);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                } catch (SQLException ex) {
                    Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return listaPC;
    }

    public static boolean alterarNoBanco(Computador pc) {

        Connection conectar = null;
        PreparedStatement comandoSQL = null;
        boolean sucesso = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(url, login, senha);

            comandoSQL = conectar.prepareStatement("UPDATE Computador SET hd = ?, processador = ? WHERE id = ?");
            comandoSQL.setInt(1, pc.getHd());
            comandoSQL.setString(2, pc.getProcessador());
            comandoSQL.setInt(3, pc.getId());

            int lA = comandoSQL.executeUpdate();

            sucesso = lA > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            sucesso = false;
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                } catch (SQLException ex) {
                    sucesso = false;
                }
            }
        }

        return sucesso;

    }

    public static ArrayList<Computador> buscarProcessador(String nomePro) {
        ArrayList<Computador> listaPc = new ArrayList<>();
        Connection conectar = null;
        PreparedStatement comandoSQL = null;
        ResultSet re = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(url, login, senha);

            comandoSQL = conectar.prepareStatement("SELECT id, processador, marca, hd FROM computador WHERE processador LIKE ?");
            comandoSQL.setString(1, nomePro);

            re = comandoSQL.executeQuery();

            if (re != null) {
                while (re.next()) {
                    Computador pc = new Computador();

                    pc.setId(re.getInt("id"));
                    pc.setMarca(re.getString("marca"));
                    pc.setProcessador(re.getString("processador"));
                    pc.setHd(re.getInt("hd"));

                    listaPc.add(pc);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                } catch (SQLException ex) {
                    Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return listaPc;
    }

    public static boolean excluirNoBanco(int id) {

        Connection conectar = null;
        PreparedStatement comandoSQL = null;
        boolean sucesso = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(url, login, senha);

            comandoSQL = conectar.prepareStatement("DELETE FROM computador WHERE id = ?");
            comandoSQL.setInt(1, id);

            int lA = comandoSQL.executeUpdate();

            sucesso = lA > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            sucesso = false;
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                } catch (SQLException ex) {
                    sucesso = false;
                }
            }
        }

        return sucesso;
    }

}
