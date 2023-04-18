package co.tenisu.atelierrestapp.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
class PlayerData {
    private Integer rank; // Le classement du joueur
    private Integer points;
    private Integer weight;
    private Integer height;
    private Integer age;
    @ElementCollection
    private List<Integer> last;
}