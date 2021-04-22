package com.fastcampus.faststore.entity;

import com.fastcampus.faststore.type.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * 할인 정책 Entity
 * 할인 타입과 액수를 가진다
 */
public class DiscountPolicy extends BaseEntity {

    private DiscountType discountType;

    private Long amount;

    // TODO: discountType에 따라 price에서 차액을 빼거나, 퍼센트 할인 가격을 반환하는 메서드를 완성하시오. DiscountPolicyTest를 성공시켜야 합니다.
    // comment: 보통 이런 메서드에서는 최종 할인된 가격이 아니고, 할인 금액을 리턴해줍니다.
    public Long getDiscountAmount(Long price) {

        if (discountType==DiscountType.PERCENT) { // comment: enum값 비교에서는 ==을 사용합니다. (ex. discountType == DiscountType.PERCENT)
            price = price * amount / 100; // comment: price -= price * amount / 100;로 축약이 가능합니다.
            return price;
        }
        if (discountType.equals(DiscountType.AMOUNT)) {
            price = amount; // comment: 역시 price -= amount;로 축약 가능합니다.
            return price;
        }

        return 0L;
    }
}
