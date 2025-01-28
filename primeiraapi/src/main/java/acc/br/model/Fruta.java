package acc.br.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Fruta extends PanacheEntity {
    public String nome;
    public int qtd;

    public Fruta() {
    }

    public Fruta(int qtd, String nome) {
        this.qtd = qtd;
        this.nome = nome;
    }
    public static Fruta findByName(String nome) {
        return find("nome", nome).firstResult();
    }

    public static List<Fruta> findOlderThan(int qtd) {
        return list("qtd > ?1", qtd);
    }
}
