package com.example.tsidmember.controller;

import com.example.tsidmember.entity.Member;
import com.example.tsidmember.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository repository;

    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Member create(@RequestBody Member member) {
        return repository.save(member);
    }

    @GetMapping
    public List<Member> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member updated) {
        Member member = repository.findById(id).orElseThrow();
        member.setName(updated.getName());
        member.setEmail(updated.getEmail());
        return repository.save(member);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
