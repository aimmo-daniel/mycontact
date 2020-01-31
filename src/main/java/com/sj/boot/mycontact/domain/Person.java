package com.sj.boot.mycontact.domain;

import com.sj.boot.mycontact.domain.dto.Birthday;
import com.sj.boot.mycontact.controller.dto.PersonDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
@Where(clause = "deleted = false") //deleted false 인것만 노출
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    private String hobby;

    private String address;

    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    private String phoneNumber;

    @ColumnDefault("0") // 0 = false
    private boolean deleted; // 삭제 여부

    public void set(PersonDto personDto) {
        if(!StringUtils.isEmpty(personDto.getHobby())){
            this.setHobby(personDto.getHobby());
        }
        if(!StringUtils.isEmpty(personDto.getAddress())) {
            this.setAddress(personDto.getAddress());
        }
        if(!StringUtils.isEmpty(personDto.getJob())) {
            this.setJob(personDto.getJob());
        }
        if(!StringUtils.isEmpty(personDto.getPhoneNumber())) {
            this.setPhoneNumber(personDto.getPhoneNumber());
        }

        if(personDto.getBirthday() != null) {
            this.setBirthday(Birthday.of(personDto.getBirthday()));
        }
    }

    // 올해 나이 구하기
    public Integer getAge() {
        if(this.birthday != null) {
            return LocalDate.now().getYear() - this.birthday.getYearOfBirthday() + 1 ;
        } else {
            return null;
        }
    }

    public boolean isBirthdayToday() {
        return LocalDate.now().equals(LocalDate.of(birthday.getYearOfBirthday(), birthday.getMonthOfBirthday(), birthday.getDayOfBirthday()));
    }

}


