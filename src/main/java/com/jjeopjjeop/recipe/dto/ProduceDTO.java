package com.jjeopjjeop.recipe.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Component
public class ProduceDTO {
    private Integer produce_num;
    private String user_id;

    @NotNull(message = "カテゴリー를 선택해주세요")
    private Integer produce_type;

    @Size(min = 1, max = 30, message = "商品 前은 必須 入力값입니다.(최대: 한글 15자/영어 30자)")
    private String produce_name;

    @NotNull(message = "価格은 必須 入力값입니다.")
    @Positive(message = "1이상의 숫자를 入力해주세요.")
    private Integer price;

    private String produce_image;

    private String produce_image_path;

    @Size(min = 1, max = 200, message = "商品 설명은 必須 入力값입니다.(최대: 한글 113자/영어 200자)")
    private String produce_description;

    private Integer end_of_sale;

    @Autowired
    private PayDTO payDTO;//장바구니에 쓰려고 만듦.
    //여기서 Autowired안하면 다른데서 아래처럼쓸때
    //produceDTO.getPayDTO().setPay_num(1);
    // java.lang.NullPointerException: null 이거 나옴.

    @Autowired
    private List<PayDTO> payDTOList;
}