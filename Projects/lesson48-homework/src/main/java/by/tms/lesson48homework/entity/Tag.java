package by.tms.lesson48homework.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {
    private int id;
    private String name;
}
