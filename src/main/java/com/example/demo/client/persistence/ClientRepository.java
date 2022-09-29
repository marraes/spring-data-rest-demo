package com.example.demo.client.persistence;

import java.util.List;
import java.util.UUID;

import com.example.demo.client.persistence.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ClientRepository extends PagingAndSortingRepository<Client, UUID> {

    List<Client> findAllByNameLike(@Param("name") String name);

    @Query("SELECT c FROM Client c WHERE upper(c.name) LIKE upper(:name)")
    Page<Client> findAllByNameLikeFromQuery(@Param("name") String name, Pageable pageable);

    @Query("""
            SELECT c FROM Client c
            WHERE
            (:name IS NULL OR upper(c.name) LIKE upper(:name))
            AND (:description IS NULL OR upper(c.description) LIKE upper(:description))
            """)
    Page<Client> findAll(
            @Param("name") String name,
            @Param("description") String description,
            Pageable pageable
    );

}
