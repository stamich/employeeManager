package pl.codecity.employees.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The user id automatically generated", required = true)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @ApiModelProperty(notes = "The first name of the employee's", required = true)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @ApiModelProperty(notes = "The last name of the employee's", required = true)
    private String lastName;

    @Column(nullable = false)
    @ApiModelProperty(notes = "The employee's email", required = true)
    private Integer grade;

    @Column(nullable = false)
    @ApiModelProperty(notes = "The employee's email", required = true)
    private Integer salary;

    @CreationTimestamp
    @ApiModelProperty(notes = "The creation date", required = true)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @ApiModelProperty(notes = "The update date", required = true)
    private LocalDateTime updatedAt;
}
