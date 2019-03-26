package com.daniel.competitions.specification;

import com.daniel.competitions.entity.Team;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThan;
import net.kaczmarzyk.spring.data.jpa.domain.LessThan;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "totalPoints", params = "totalPointsMin", spec = GreaterThan.class),
        @Spec(path = "totalPoints", params = "totalPointsMax", spec = LessThan.class)
})
public interface TeamSpecification extends Specification<Team> {
}
