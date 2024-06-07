package br.edu.imepac.clinica.medica.database.daos;

import br.edu.imepac.clinica.medica.database.Database;
import br.edu.imepac.clinica.medica.entidades.Aluno;
import br.edu.imepac.clinica.medica.interfaces.PersistentInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao extends Database implements PersistentInterface<Aluno> {

    @Override
    public boolean save(Aluno entity) throws SQLException {
        String sql = "INSERT INTO aluno(nome,matricula) VALUES (?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, entity.getNome());
        pst.setString(2, entity.getMatricula());
        pst.executeUpdate();
        return true;
    }

    @Override
    public Aluno load(long id) throws SQLException {
        String sql = "SELECT * FROM aluno where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1, id);
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            Aluno aluno = new Aluno(resultSet.getLong("id"), resultSet.getString("nome"), resultSet.getString("matricula"));
            return aluno;
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Aluno entity) throws SQLException {
        String sql = "UPDATE aluno SET nome = ?, matricula = ? where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, entity.getNome());
        pst.setString(2, entity.getMatricula());
        pst.setLong(3, entity.getId());

        int updateCount = pst.executeUpdate(sql);
        if (updateCount > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Aluno entity) throws SQLException {
        return delete(entity.getId());
    }

    public boolean delete(Long id) throws SQLException {
        String sql = "DELETE FROM aluno where id=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1, id);
        int updateCount = pst.executeUpdate(sql);
        if (updateCount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Aluno> list() throws SQLException {
        String sql = "SELECT * FROM aluno";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet resultSet = pst.executeQuery();

        List<Aluno> listaDeAlunos = new ArrayList<>();
        while (resultSet.next()) {
            Aluno aluno = new Aluno(resultSet.getLong("id"), resultSet.getString("nome"), resultSet.getString("matricula"));
            listaDeAlunos.add(aluno);
        }
        return listaDeAlunos;
    }

}
