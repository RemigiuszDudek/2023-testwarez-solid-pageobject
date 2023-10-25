package org.example.objects;

import java.util.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Desert {
    String name;
    String calories;
    String fat;
    String carbs;
    String proteins;

    public Desert(String name, String calories, String fat, String carbs, String proteins) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.proteins = proteins;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (!Desert.class.isAssignableFrom(obj.getClass())) return false;

        final Desert other = (Desert) obj;
        if (!Objects.equals(this.name, other.name)) return false;
        if (!Objects.equals(this.calories, other.calories)) return false;
        if (!Objects.equals(this.fat, other.fat)) return false;
        if (!Objects.equals(this.carbs, other.carbs)) return false;
        if (!Objects.equals(this.proteins, other.proteins)) return false;

        return true;
    }
}
