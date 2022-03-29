package src.main.java.pet;

import java.util.Objects;

public class Type {
        private Integer Id;
        private String name;
        private Integer stage;
        private Integer fave_food;
        private Integer max_exp;
        private Integer upgrade;

        public Type() {
        }

        public Type(String name, Integer stage, Integer fave_food, Integer max_exp, Integer upgrade) {
        this.name = name;
        this.stage = stage;
        this.fave_food = fave_food;
        this.max_exp = max_exp;
        this.upgrade = upgrade;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getFave_food() {
        return fave_food;
    }

    public void setFave_food(Integer fave_food) {
        this.fave_food = fave_food;
    }

    public Integer getMax_exp() {
        return max_exp;
    }

    public void setMax_exp(Integer max_exp) {
        this.max_exp = max_exp;
    }

    public Integer getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Integer upgrade) {
        this.upgrade = upgrade;
    }

    @Override
    public String toString() {
        return "Type{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", stage=" + stage +
                ", fave_food=" + fave_food +
                ", max_exp=" + max_exp +
                ", upgrade=" + upgrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(Id, type.Id) && Objects.equals(name, type.name) && Objects.equals(stage, type.stage) && Objects.equals(fave_food, type.fave_food) && Objects.equals(max_exp, type.max_exp) && Objects.equals(upgrade, type.upgrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, stage, fave_food, max_exp, upgrade);
    }
}
