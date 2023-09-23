package vn.edu.iuh.fit.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ConvertEmployeeStatus implements AttributeConverter<EmployeeStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.value();

    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;

        return Stream.of(EmployeeStatus.values())
                .filter(c -> c.value() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}