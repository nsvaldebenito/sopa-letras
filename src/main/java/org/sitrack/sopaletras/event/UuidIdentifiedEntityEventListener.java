package org.sitrack.sopaletras.event;

import java.util.UUID;

import org.sitrack.sopaletras.model.SoupEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class UuidIdentifiedEntityEventListener extends AbstractMongoEventListener<SoupEntity> {
    
    @Override
    public void onBeforeConvert(BeforeConvertEvent<SoupEntity> event) {
        
        super.onBeforeConvert(event);
        SoupEntity entity = event.getSource();
        
        if(entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        } 
    }    

}
