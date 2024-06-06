package br.edu.imepac.clinica.medica.database.daos;

import br.edu.imepac.clinica.medica.database.Database;
import br.edu.imepac.clinica.medica.entidades.Aluno;
import br.edu.imepac.clinica.medica.interfaces.PersistentInterface;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDao extends Database implements PersistentInterface<Aluno> {

    @Override
    public boolean save(Aluno entity) throws SQLException {
        String sql = "INSERT INTO aluno(nome,matricula) VALUES (?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, entity.getNome());
        pst.setString(2, entity.getMatricula());
        pst.execute();
        return true;
    }

    @Override
    public Aluno load(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Aluno entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Aluno entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
