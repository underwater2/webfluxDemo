package com.example.webfluxDemo.repository;

import com.example.webfluxDemo.entity.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MemberRepository extends ReactiveCrudRepository<Member, String> {
}
