package com.mycompany.group234.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum ModelCreator{
	    Replicacia,
	    User; 
    public int value(ModelCreator modelCreator) {
        return modelCreator.ordinal();
    }
    public static ModelCreator getModelCreator(int ordinal) {
        for(ModelCreator modelCreator : ModelCreator.values())
                if(modelCreator.ordinal() == ordinal)
                        return modelCreator;
        return null;
    }
}


