package com.soli.dialogue.entity;

import com.soli.dialogue.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq", nullable = false)
    private Long memberSeq;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(nullable = false, length = 100, unique = true)
    private String nickname;

    @Column(nullable = false)
    @ColumnDefault("MEMBER") // default
    @Enumerated(EnumType.STRING)
    private Role role ;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Builder
    private Member(Long memberSeq, String email, String password, String nickname, Role role) {
        this.memberSeq = memberSeq;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = (role == null || role.equals("")) ? Role.MEMBER : role; // 기본 역할 설정
        this.createdAt = LocalDateTime.now(); // 현재 시간으로 초기화
        this.updatedAt = LocalDateTime.now(); // 현재 시간으로 초기화
    }


}
