package com.example.tsidmember.repository;

import com.example.tsidmember.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {}
