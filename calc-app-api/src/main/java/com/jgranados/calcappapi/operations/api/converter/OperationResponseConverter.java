package com.jgranados.calcappapi.operations.api.converter;

import com.jgranados.calcappapi.operations.api.model.OperationApiResponseModel;

/**
 *
 * @author jose
 */
public class OperationResponseConverter extends Converter<OperationApiResponseModel>{

    public OperationResponseConverter(Class<OperationApiResponseModel> typeConverter) {
        super(typeConverter);
    }
}
