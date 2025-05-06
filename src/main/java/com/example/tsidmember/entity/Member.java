package com.example.tsidmember.entity;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.util.Objects;

@Entity
public class Member {

    @Id
    private Long id;  // BIGINT로 저장

    private String name;
    private String email;

    @PrePersist
    public void assignTsid() {
        if (this.id == null) {
            this.id = TsidCreator.getTsid().toLong();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member member)) return false;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
