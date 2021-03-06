package org.starrier.dreamwar.utils.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Controller 参数校验，错误返回封装
 *
 * @author Starrier
 * @date 2019/1/31.
 */
@Data
@NoArgsConstructor
public class ParameterInvalidItem implements Serializable {

    private String fieldName;
    private String message;

}
