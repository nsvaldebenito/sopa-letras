package org.sitrack.sopaletras.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;

public abstract class SoupEntity {
	
	@Id   
    protected UUID id;   
	
	

    public SoupEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

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
