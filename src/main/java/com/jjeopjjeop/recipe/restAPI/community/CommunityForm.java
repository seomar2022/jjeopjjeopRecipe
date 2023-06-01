package com.jjeopjjeop.recipe.restAPI.community;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommunityForm {

    @ApiModelProperty(example = "유저아이디")
    private String user_id;

    @ApiModelProperty(example = "0 - フリー글 , 1 - レシピレビュー")
    private String category;

    @ApiModelProperty(example = "レシピ 후기글일경우 0보다 큰 숫자(レシピ 일련番号)入力")
    private Integer rcp_seq;//レシピ후기일경우 번호

    @ApiModelProperty(example = "タイトル")
    private String title;

    @ApiModelProperty(example = "내용")
    private String content;

}
