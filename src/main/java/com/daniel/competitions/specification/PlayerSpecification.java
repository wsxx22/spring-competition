package com.daniel.competitions.specification;

import com.daniel.competitions.entity.Player;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path="name", spec= Equal.class),
        @Spec(path="surname", spec= Equal.class),
        //@Spec(path = "age", spec = Equal.class)
        @Spec(path = "age", params = { "age_min" }, spec = GreaterThanOrEqual.class),
        @Spec(path = "age", params = { "age_max" }, spec = LessThanOrEqual.class),
        @Spec(path = "team.id", params = "team_id", spec = In.class)
})
public interface PlayerSpecification extends Specification<Player> {

}
