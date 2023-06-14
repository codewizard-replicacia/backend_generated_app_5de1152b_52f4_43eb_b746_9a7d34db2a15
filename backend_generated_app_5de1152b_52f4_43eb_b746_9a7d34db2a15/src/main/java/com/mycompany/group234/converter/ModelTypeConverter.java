package com.mycompany.group234.converter;

import com.mycompany.group234.enums.ModelType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class ModelTypeConverter implements AttributeConverter<ModelType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ModelType modelType) {
        return modelType != null ? modelType.ordinal() : null;
    }

    @Override
    public ModelType convertToEntityAttribute(Integer dbData) {
		return ModelType.getModelType(dbData);
    }
}
