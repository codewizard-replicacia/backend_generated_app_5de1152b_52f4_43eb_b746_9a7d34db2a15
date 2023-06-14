package com.mycompany.group234.converter;

import com.mycompany.group234.enums.ModelCreator;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class ModelCreatorConverter implements AttributeConverter<ModelCreator, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ModelCreator modelCreator) {
        return modelCreator != null ? modelCreator.ordinal() : null;
    }

    @Override
    public ModelCreator convertToEntityAttribute(Integer dbData) {
		return ModelCreator.getModelCreator(dbData);
    }
}
