package com.alfazid.siasd.utilities;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by cigist on 23/07/20.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasePagintaion {
    private String sortBy;
    private String searchBy;
    private String searchValue;
}
