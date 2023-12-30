/**
 * File: ArtWork.java
 */

package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * This is an entity bean. In a entity bean is declared all entity's attributes
 * and their getters and setters
 * Using the annotation @Entity we can use it as an entity bean in the Spring
 * Boot Framework
 */

@Entity
@Data
@Table(name = "artworks")
public class ArtWork {

    /**
     * The @Id annotation makes the attribute 'artworkCode' the primary key of
     * this entity
     * 
     * @GeneratedValue is an annotation that gives to artworkCode the property to
     *                 have a primary key with auto-increment.
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "artwork-id")
    private Long artworkId;
    @Column(name = "artwork-name")
    private String artworkName;
    @Column(name = "artwork-description")
    private String artworkDescription;
    @Column(name = "artwork-year")
    private String artworkYear;

    /*
     * Relationship between entities.
     * 
     * @OneToOne defines the relationship type and FetchType.LAZY defines the
     * fetching mode.
     * (LAZY only when it is required in order to preserve resources)
     */

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stand-id", referencedColumnName = "stand-id")
    private Stand joinedStand;

}
