package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecadoDAO {
    public void cadastrar(Recado recado) throws SQLException{
        String sql = "INSERT INTO recado (autor, menssagem) VALUES (?, ?)";

        try (Connection conexao = Conexao.abrir();
             PreparedStatement comando = conexao.prepareStatement(sql)){
            comando.setString(1, recado.getAutor());
            comando.setString(2, recado.getMenssagem());
            comando.executeUpdate();
        }
    }
    public List<Recado> listar() throws SQLException{
        String sql = "SELECT id, autor, menssagem FROM recado ORDER BY id DESC";
        List <Recado> recados = new ArrayList<>();

        try(Connection conexao = Conexao.abrir();
            PreparedStatement comando = conexao.prepareStatement(sql);
        ResultSet resultado = comando.executeQuery()){

            while (resultado.next()){
                Recado recado = new Recado(
                        resultado.getInt("id"),
                        resultado.getString("autor"),
                        resultado.getString("menssagem")
                );
                recados.add(recado);
            }
        }
        return recados;
    }
}
