package com.jjeopjjeop.recipe.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Component
public class RecipeDTO {
    private int rcp_seq;
    private int scrap;
    private int report;
    private int rcp_viewcnt;
    @NotBlank(message = "* レシピ 이름은 필수 입력 항목입니다.")
    @Size(max=16, message = "* 최대 16자까지 입력할 수 있습니다.")
    private String rcp_name;
    private String user_id = "abc";
    private String filename;
    private String filepath;
    @NotBlank(message = "* 소요時間은 필수 입력 항목입니다.")
    private String time;
    @NotBlank(message = "* 難易度는 필수 입력 항목입니다.")
    private String difficulty;
    @NotBlank(message = "* 양은 필수 입력 항목입니다.")
    private String amount;
    @NotBlank(message = "* レシピ 소개글은 필수 입력 항목입니다.")
    @Size(max=1000, message = "* 최대 1000자까지 작성할 수 있습니다.")
    private String summary;
    private String hash_tag;
    @NotBlank(message = "* 材料는 필수 입력 항목입니다.")
    @Size(max=1000, message = "* 최대 1000자까지 작성할 수 있습니다.")
    private String rcp_parts_dtls;
    private String rcp_date;

    // db에 없는 것
    private MultipartFile upload; // 첨부파일 처리
    private boolean scrapOrNot; // 保存 처리
    private boolean reportOrNot; // 신고 처리

    // 유효성 검사 테스트용
    private List<ManualDTO> manualDTOList;
}