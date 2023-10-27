package com.example.webfluxDemo.service;

import com.example.webfluxDemo.dto.MemberDto;
import com.example.webfluxDemo.entity.Member;
import com.example.webfluxDemo.mapper.MemberMapper;
import com.example.webfluxDemo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Mono<MemberDto> saveMember(MemberDto memberDto) {
        Member member = MemberMapper.mapToMember(memberDto);
        Mono<Member> savedMember = memberRepository.save(member);
        return savedMember
                .map(MemberMapper::mapToMemberDto);
    }

    @Override
    public Mono<MemberDto> getMember(String memberId) {
        Mono<Member> foundMember = memberRepository.findById(memberId);
        return foundMember
                .map(MemberMapper::mapToMemberDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<MemberDto> getAllMember() {
        Flux<Member> allMember = memberRepository.findAll();
        return allMember
                .map(MemberMapper::mapToMemberDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<MemberDto> updateMember(MemberDto memberDto, String memberId) {

        Mono<Member> updateMember = memberRepository.findById(memberId);

        return updateMember
                .flatMap(memberEntity -> {
                    memberEntity.setLoginId(memberDto.getLoginId());
                    memberEntity.setPassword(memberDto.getPassword());
                    memberEntity.setAge(memberDto.getAge());
//                    memberEntity.setCreatedAt(memberDto.getCreatedAt());
                    memberEntity.setUpdatedAt(memberDto.getUpdatedAt());
                    return memberRepository.save(memberEntity);
                })
                .map(MemberMapper::mapToMemberDto);
    }

    @Override
    public Mono<Void> deleteMember(String memberId) {
        return memberRepository.deleteById(memberId);
    }
}
