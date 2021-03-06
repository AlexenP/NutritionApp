package main.Model;

import javax.persistence.*;

@Entity
@Table(name = "nutrition")
public class Nutrition {

    @Id
    private int clientId;

    @Column(name = "caloricMaintenance")
    private int caloricMaintenance;

    @Column(name = "caloriesByObective")
    private int caloriesByObective;

    @Column(name = "proteins")
    private int proteins;

    @Column(name = "fats")
    private int fats;

    @OneToOne(mappedBy = "nutrition", cascade = CascadeType.ALL)
    private Client client;

    public Nutrition() {
    }

    public Nutrition(int clientId, int caloricMaintenance, int caloriesByObective, int proteins, int fats) {
        this.clientId = clientId;
        this.caloricMaintenance = caloricMaintenance;
        this.caloriesByObective = caloriesByObective;
        this.proteins = proteins;
        this.fats = fats;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                "clientId=" + clientId +
                ", caloricMaintenance=" + caloricMaintenance +
                ", caloriesByObective=" + caloriesByObective +
                ", proteins=" + proteins +
                ", fats=" + fats +
                '}' + '\n';
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCaloricMaintenance() {
        return caloricMaintenance;
    }

    public void setCaloricMaintenance(int caloricMaintenance) {
        this.caloricMaintenance = caloricMaintenance;
    }

    public int getCaloriesByObective() {
        return caloriesByObective;
    }

    public void setCaloriesByObective(int caloriesByObective) {
        this.caloriesByObective = caloriesByObective;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
