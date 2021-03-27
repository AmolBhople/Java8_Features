package java8.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
    private Gender gender;
}
