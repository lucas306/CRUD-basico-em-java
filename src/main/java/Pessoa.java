import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Pessoa {

    private int codigo;
    private String nome;
    private String fone;
    private String email;
    
    public Pessoa(String email,String fone,String nome, int codigo){
        this.codigo = codigo;
        this.email = email;
        this.fone = fone;
        this.nome = nome;
    }

    public Pessoa() {}

    public void inserir() {
        //1: Definir o comando SQL
        String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizar() {
        //1: Definir o comando SQL
        String sql = "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE codigo = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagar() {
        //1: Definir o comando SQL
        String sql = "DELETE FROM tb_pessoa WHERE codigo = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setInt(1, codigo);
            //5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        //1: Definir o comando SQL
        String sql = "SELECT * FROM tb_pessoa";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String fone = rs.getString("fone");
                String email = rs.getString("email");
                String aux = String.format(
                        "Código: %d, Nome: %s, Fone: %s, Email: %s",
                        codigo,
                        nome,
                        fone,
                        email
                );
                JOptionPane.showMessageDialog(null, aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //getters/setters 
    void setNome(String nome) {
        this.nome = nome;
    }

    void setFone(String fone) {
        this.fone = fone;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    String getNome(){
        return nome;
    }
    String getFone(){
        return fone;
    }
    String getEmail(){
        return email;
    }
    int getCodigo(){
        return codigo;
    }
}
