package main.Model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "paLevel")
    private Integer paLevel;

    @Column(name = "objective")
    private Integer objective;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Nutrition nutrition;

    @OneToMany(mappedBy = "client")
    private Set<Plan> plans = new HashSet<>();

    public Client() {
    }

    public Client(int clientId, String firstName, String lastName, String sex, Integer height, Integer weight, Integer paLevel, Integer objective, Nutrition nutrition, Set<Plan> plans) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.paLevel = paLevel;
        this.objective = objective;
        this.nutrition = nutrition;
        //this.plans = plans;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", paLevel=" + paLevel +
                ", objective=" + objective +
                ", nutrition=" + nutrition +
                //", plans=" + plans +
                '}' + '\n';
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int departmentId) {
        this.clientId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPaLevel() {
        return paLevel;
    }

    public void setPaLevel(Integer paLevel) {
        this.paLevel = paLevel;
    }

    public Integer getObjective() {
        return objective;
    }

    public void setObjective(Integer objective) {
        this.objective = objective;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

}
