package org.acme.stuff;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Container {

    @Id
    @Column(length = 64)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID id;

    @Version
    public Short version;

    @ElementCollection
    private Set<Embedded> embedded = new HashSet<>();

}
