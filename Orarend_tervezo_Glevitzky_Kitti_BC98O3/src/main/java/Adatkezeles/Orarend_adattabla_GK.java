package Adatkezeles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Adatbazis kezeles
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Orarend_adattabla_GK {
    @GeneratedValue
    @Id
    private Long id;

    private String targy;

    private String nap;

    private String ora;

    private Integer evfolyam;

    private String osztaly;

    public boolean napValid() {
        List<String> napok = List.of("hétfő", "kedd", "szerda", "csütörtök", "péntek");
        return napok.contains(getNap());
    }

    public boolean evfolyamValid() {
        return getEvfolyam() >= 1 &&
                getEvfolyam() <= 13;
    }
}