package com.mycompany.group234.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum ModelType{
	    StarUML,
	    EDMX; 
    public int value(ModelType modelType) {
        return modelType.ordinal();
    }
    public static ModelType getModelType(int ordinal) {
        for(ModelType modelType : ModelType.values())
                if(modelType.ordinal() == ordinal)
                        return modelType;
        return null;
    }
}


