package com.alkemy.disney.disney.repository.specifications;

import com.alkemy.disney.disney.dto.PeliculaFiltersDTO;
import com.alkemy.disney.disney.entity.Pelicula;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaSpecifications {

    public Specification<Pelicula> getByFilters(PeliculaFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            if (filtersDTO.getGenre() != null && filtersDTO.getGenre().isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("generoId"), filtersDTO.getGenre()));
            }

            /*if (StringUtils.hasLength(filtersDTO.getGenre())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("generoId")),
                                "%" + filtersDTO.getGenre() + "%"
                        )
                );
            }*/

            //Remove duplicates
            query.distinct(true);

            // Order resolver
            String orderByField = "titulo";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
