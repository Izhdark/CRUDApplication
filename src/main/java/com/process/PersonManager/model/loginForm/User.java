package com.process.PersonManager.model.loginForm;

import com.process.PersonManager.utils.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name = "login")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 4, max = 64, message = ErrorMessage.EMPTY_FIELD + "(от 4 до 64 символов)")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "aasdasd")
    private String email;

    @Size(min = 4, max = 100, message = ErrorMessage.EMPTY_FIELD + "(от 4 до 30 символов)")
    @Pattern(regexp = "(\\w|\\D)+")
    private String password;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date creation_date;

    @Size(min = 3,max = 64,message = "ASdasdasd")
    @Pattern(regexp = "([А-аЯ-я]|[A-aZ-z]|\\d)+")
    private String firstName;

    @Size(min=3,max = 64)
    @Pattern(regexp = "([А-аЯ-я]|[A-aZ-z]|\\d)+")
    private String lastName;

    private String userRole;

    private String token;

}
