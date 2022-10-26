package org.sitrack.sopaletras.model;

import java.util.List;
import java.util.UUID;

import org.sitrack.sopaletras.dto.ResponseWrapper;
import org.sitrack.sopaletras.dto.Rows;
import org.sitrack.sopaletras.dto.Soup;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public abstract class SoupEntity {
	
	@Id   
    protected UUID id;    

    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        
        if(this.id != null) {
            
            throw new UnsupportedOperationException("ID is already defined");
        }
        
        this.id = id;
    }
	 

}
