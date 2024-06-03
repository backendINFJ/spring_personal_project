package com.sparta.personalproject.entity;

import com.sparta.personalproject.dto.ScheduleManagementRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "schedule")
@NoArgsConstructor // 기본 생성자 생성
public class ScheduleManagement extends Timestamped {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Id // 고유 아이디
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleId")
    private Long id;

    @NotNull(message = "담당자를 기입해주세요!")
    @Min(1)
    @Max(5)
    @Column(name = "manager", nullable = false)
    private String manager;
   //  @Pattern()
    @NotNull(message = "패스워드를 입력해주세요.")
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @NotNull(message = "제목을 입력해주세요!")
    @Column(name = "title", nullable = false)
    private String title;
    @NotNull(message = "내용을 입력해주세요!")
    @Column(name = "content", nullable = false)
    private String content;

//    @OneToMany(mappedBy = "Comment") // 댓글 추가 1:N
//    private List<Comment>CommentList = new ArrayList<>();

    public ScheduleManagement(ScheduleManagementRequestDto requestDto) {
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
        this.date = requestDto.getDate();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(ScheduleManagementRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.manager = requestDto.getManager();
    }
}
