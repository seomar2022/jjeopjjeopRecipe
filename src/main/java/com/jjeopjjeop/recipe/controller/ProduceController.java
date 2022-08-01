
package com.jjeopjjeop.recipe.controller;

import com.jjeopjjeop.recipe.dto.ProduceDTO;
import com.jjeopjjeop.recipe.service.ProduceService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProduceController {
    private static final Logger log = LoggerFactory.getLogger(ProduceController.class);
    @Autowired
    private ProduceService service;

    public ProduceController() {
    }

    @GetMapping({"/produce/write"})
    public String produceWriteForm() {
        return "/produce/produceWrite";
    }

    @PostMapping({"/produce/write"})
    public String produceWrite(ProduceDTO dto) {
        log.info("dto={}", dto.getUser_id());
        log.info("dto={}", dto.getPrice());
        log.info("dto={}", dto.getProduce_description());
        this.service.writeProcess(dto);
        return "redirect:/produce/list";
    }

    @GetMapping({"/produce/list"})
    public ModelAndView produceList(ModelAndView mav) {
        List<ProduceDTO> list = this.service.produceListProcess();
        mav.addObject("list", list);
        mav.setViewName("/produce/produceList");
        return mav;
    }

    @GetMapping({"/produce/list/{type}"})
    public ModelAndView produceListType(@PathVariable("type") int type, ModelAndView mav) {
        List<ProduceDTO> list = this.service.produceListTypeProcess(type);
        mav.addObject("list", list);
        mav.setViewName("/produce/produceList");
        return mav;
    }

    @GetMapping({"/produce/delete/{produceNum}"})
    public String produceDelete(@PathVariable("produceNum") int produce_num) {
        this.service.produceDeleteProcess(produce_num);
        return "redirect:/produce/list";
    }

    @GetMapping({"/produce/view/{produceNum}"})
    public ModelAndView produceView(@PathVariable("produceNum") int produce_num, ModelAndView mav) {
        ProduceDTO dto = this.service.produceViewProcess(produce_num);
        mav.addObject("dto", dto);
        mav.setViewName("/produce/produceView");
        return mav;
    }

    @GetMapping({"/produce/update/{produceNum}"})
    public ModelAndView produceUpdateForm(@PathVariable("produceNum") int produce_num, ModelAndView mav) {
        ProduceDTO dto = this.service.produceViewProcess(produce_num);
        mav.addObject("dto", dto);
        mav.setViewName("produce/produceUpdateForm");
        return mav;
    }

    @PostMapping({"/produce/update/{produceNum}"})
    public String produceUpdate(@PathVariable("produceNum") int produce_num, ProduceDTO dto) {
        log.info("수정={}", dto.getProduce_name());
        this.service.produceUpdateProcess(dto);
        return "redirect:/produce/view/" + produce_num;
    }
}