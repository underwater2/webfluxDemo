package com.example.webfluxDemo.mapper;

import com.example.webfluxDemo.dto.MemberDto;
import com.example.webfluxDemo.entity.Member;

public class MemberMapper {

    public static MemberDto mapToMemberDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getLoginId(),
                member.getPassword(),
                member.getAge(),
                member.getCreatedAt(),
                member.getUpdatedAt()
        );
    }

    public static Member mapToMember(MemberDto memberDto) {
        return new Member(
                memberDto.getId(),
                memberDto.getLoginId(),
                memberDto.getPassword(),
                memberDto.getAge(),
                memberDto.getCreatedAt(),
                memberDto.getUpdatedAt()
        );
    }
}
