package com.daniel.competitions.specification;


import com.daniel.competitions.entity.Competition;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThan;
import net.kaczmarzyk.spring.data.jpa.domain.LessThan;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "date", params = "dateAfter", spec = GreaterThan.class),
        @Spec(path = "date", params = "dateBefore", spec = LessThan.class)

})
public interface CompetitionSpecification extends Specification<Competition> {
}
