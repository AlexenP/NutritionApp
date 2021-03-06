package main.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planId;

    private int clientId;

    @Column(name = "planType")
    private Integer planType;

    @ManyToMany
    @JoinTable(
            name = "plan_menu",
            joinColumns = {@JoinColumn(name = "planId")},
            inverseJoinColumns = {@JoinColumn(name = "menuId")}
    )
    private Set<Menu> menus = new HashSet<Menu>();

    private int totalCalories = 0;
    private int totalProteins = 0;
    private int totalFats = 0;

    public Plan() {
    }

    public Plan(int planId, int clientId, Integer planType, Set<Menu> menus, int totalCalories, int totalProteins, int totalFats) {
        this.planId = planId;
        this.clientId = clientId;
        this.planType = planType;
        this.menus = menus;
        this.totalCalories = totalCalories;
        this.totalProteins = totalProteins;
        this.totalFats = totalFats;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "planId=" + planId +
                ", clientId=" + clientId +
                ", planType=" + planType +
                ", menus=" + menus +
                ", totalCalories=" + totalCalories +
                ", totalProteins=" + totalProteins +
                ", totalFats=" + totalFats +
                '}' + '\n';
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public int getTotalProteins() {
        return totalProteins;
    }

    public void setTotalProteins(int totalProteins) {
        this.totalProteins = totalProteins;
    }

    public int getTotalFats() {
        return totalFats;
    }

    public void setTotalFats(int totalFats) {
        this.totalFats = totalFats;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
