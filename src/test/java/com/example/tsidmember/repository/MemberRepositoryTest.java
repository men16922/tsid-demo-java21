package com.example.tsidmember.repository;

import com.example.tsidmember.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    private final Random random = new Random();

    @Test
    void insertMember() {
        // given
        Member member = new Member();
        member.setName("user-" + UUID.randomUUID().toString().substring(0, 8));
        member.setEmail("user" + random.nextInt(100000) + "@example.com");

        // when
        Member saved = memberRepository.save(member);

        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isNotBlank();
        assertThat(saved.getEmail()).contains("@example.com");
    }

    @Test
    void bulkInsertMembers() {
        // given
        List<Member> members = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Member member = new Member();
            member.setName("user-" + UUID.randomUUID().toString().substring(0, 8));
            member.setEmail("user" + random.nextInt(100000) + "@example.com");
            members.add(member);
        }

        // when
        List<Member> savedMembers = memberRepository.saveAll(members);

        // then
        assertThat(savedMembers).hasSize(100);
        assertThat(savedMembers.get(0).getId()).isNotNull();
    }
}
