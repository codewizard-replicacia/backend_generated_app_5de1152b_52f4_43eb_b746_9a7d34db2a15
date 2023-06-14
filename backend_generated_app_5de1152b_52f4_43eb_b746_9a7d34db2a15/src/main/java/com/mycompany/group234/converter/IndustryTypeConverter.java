package com.mycompany.group234.converter;

import com.mycompany.group234.enums.IndustryType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class IndustryTypeConverter implements AttributeConverter<IndustryType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(IndustryType industryType) {
        return industryType != null ? industryType.ordinal() : null;
    }

    @Override
    public IndustryType convertToEntityAttribute(Integer dbData) {
		return IndustryType.getIndustryType(dbData);
    }
}
