package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
// @Where(clause="is_deleted=false") //select * from users where id=4 and is_deleted =false;
//adding the clause @where to manage any repository which is using user entity(User repository in this case)
// whatever query inside, will add it automatically to each method
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String userName;
    private String passWord;
    private boolean enabled;
    private String phone;

    @ManyToOne
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;



}
