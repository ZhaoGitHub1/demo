package com.yizhu.repository;

import com.yizhu.dto.UserQueryDto;
import com.yizhu.entity.Organization;
import com.yizhu.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserSpecs {

    public static Specification<User> listQuerySpec(UserQueryDto userQueryDto){
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Optional.ofNullable(userQueryDto.getId()).ifPresent(i -> predicates.add(builder.equal(root.get("id"), i)));
            Optional.ofNullable(userQueryDto.getName()).ifPresent(n -> predicates.add(builder.equal(root.get("name"), n)));
            Optional.ofNullable(userQueryDto.getAge()).ifPresent(a -> predicates.add(builder.equal(root.get("age"), a)));
            Optional.ofNullable(userQueryDto.getOrgId()).ifPresent(oi -> predicates.add(builder.equal(root.get("orgId"), oi)));
            Optional.ofNullable(userQueryDto.getOrgName()).ifPresent(on -> {
                Join<User, Organization> userJoin = root.join(root.getModel().getSingularAttribute("org", Organization.class), JoinType.LEFT);
                predicates.add(builder.equal(userJoin.get("orgName"), on));
            });

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}

