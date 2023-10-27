package com.example.webfluxDemo.service;

import com.example.webfluxDemo.dto.MemberDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberService {
    Mono<MemberDto> saveMember(MemberDto memberDto);

    Mono<MemberDto> getMember(String memberId);

    Flux<MemberDto> getAllMember();

    Mono<MemberDto> updateMember(MemberDto memberDto, String memberId);

    Mono<Void> deleteMember(String memberId);
}
