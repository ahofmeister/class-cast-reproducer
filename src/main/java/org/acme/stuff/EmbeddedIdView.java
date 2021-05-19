package org.acme.stuff;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

import java.util.UUID;

@EntityView(Container.class)
public interface EmbeddedIdView {

    @IdMapping
    UUID getId();

}
