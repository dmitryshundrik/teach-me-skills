package by.tms.lesson46homework.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Telephone {
    private String code;
    private String number;
}
