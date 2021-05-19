package org.acme.stuff;

import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.IdMapping;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@EntityView(Record.class)
@CreatableEntityView
public interface RecordCreate {

    @IdMapping
    UUID getId();

    EntityViewManager evm();

    EmbeddedIdView getContainer();

    void setContainer(EmbeddedIdView user);

    default UUID getContainerId() {
        return getContainer() == null ? null : getContainer().getId();
    }

    @JsonProperty
    default void setContainerId(UUID foodId) {
        setContainer(foodId == null ? null : evm().getReference(EmbeddedIdView.class, foodId));
    }

}
