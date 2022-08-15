import javax.swing.JOptionPane;

public class principal {

    public static void main(String[] args) {
        String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Nome?");
                    String fone = JOptionPane.showInputDialog("Fone?");
                    String email = JOptionPane.showInputDialog("Email?");
                    Pessoa p = new Pessoa();
                    p.setNome(nome);
                    p.setFone(fone);
                    p.setEmail(email);
                    p.inserir();
                    break;
                case 2:
                    String nome2 = JOptionPane.showInputDialog("Nome?");
                    String fone2 = JOptionPane.showInputDialog("Fone?");
                    String email2 = JOptionPane.showInputDialog("Email?");
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
                    Pessoa p1 = new Pessoa();
                    p1.setNome(nome2);
                    p1.setFone(fone2);
                    p1.setEmail(email2);
                    p1.setCodigo(codigo);
                    p1.atualizar();
                    break;
                case 3:
                    int codigo1 = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
                    Pessoa p2 = new Pessoa();
                    p2.setCodigo(codigo1);
                    p2.apagar();
                    break;
                case 4:
                    Pessoa p3 = new Pessoa();
                    p3.listar();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (op != 0);
    }

}
