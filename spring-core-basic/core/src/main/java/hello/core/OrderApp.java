package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        //1. 회원가입을 한다
        MemberService memberService = new MemberServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "홍길동", Grade.VIP);
        memberService.join(member);

        //2. 주문을 한다
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.createOrder(memberId, "티셔츠", 100000);

        System.out.println("order : " + order);
        System.out.println("할인 후 금액 : " + order.calculatePrice());
    }

}
