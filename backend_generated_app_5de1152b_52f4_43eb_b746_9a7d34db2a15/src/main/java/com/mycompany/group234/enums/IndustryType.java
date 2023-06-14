package com.mycompany.group234.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum IndustryType{
	    HealthCare,
	    Ecommerce; 
    public int value(IndustryType industryType) {
        return industryType.ordinal();
    }
    public static IndustryType getIndustryType(int ordinal) {
        for(IndustryType industryType : IndustryType.values())
                if(industryType.ordinal() == ordinal)
                        return industryType;
        return null;
    }
}


