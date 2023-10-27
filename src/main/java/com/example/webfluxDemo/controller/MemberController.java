package com.example.webfluxDemo.controller;

import com.example.webfluxDemo.dto.MemberDto;
import com.example.webfluxDemo.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<MemberDto> saveMember(@RequestBody MemberDto memberDto) {
        return memberService.saveMember(memberDto);
    }

    @GetMapping("/{id}")
    public Mono<MemberDto> getMember(@PathVariable("id") String memberDto){
        return memberService.getMember(memberDto);
    }

    @GetMapping
    public Flux<MemberDto> getAllMember(){
        return memberService.getAllMember();
    }

    @PutMapping("/{id}")
    public Mono<MemberDto> updateMember(@RequestBody MemberDto memberDto,
                                            @PathVariable("id") String memberId){
        return memberService.updateMember(memberDto, memberId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMember(@PathVariable("id") String memberId){
        return memberService.deleteMember(memberId);
    }
}
