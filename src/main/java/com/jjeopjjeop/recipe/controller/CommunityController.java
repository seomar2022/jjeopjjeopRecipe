package com.jjeopjjeop.recipe.controller;

import com.jjeopjjeop.recipe.config.MySecured;
import com.jjeopjjeop.recipe.dto.CommunityCommentDTO;
import com.jjeopjjeop.recipe.dto.CommunityDTO;
import com.jjeopjjeop.recipe.dto.RecipeDTO;
import com.jjeopjjeop.recipe.dto.UserDTO;
import com.jjeopjjeop.recipe.form.CommunitySearchForm;
import com.jjeopjjeop.recipe.pagenation.Pagenation;
import com.jjeopjjeop.recipe.service.CommunityService;
import com.jjeopjjeop.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;
    private final RecipeService recipeService;


    @GetMapping
    public String all(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page, Model model){
        Pagenation pagenation = new Pagenation(page,10,communityService.count());
        List<CommunityDTO> board = communityService.getBoard(pagenation);

        model.addAttribute("board",board);
        model.addAttribute("page",pagenation);

        return "community/index";
    }

    @GetMapping("/recipeReview")
    public String recipeReview(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page, Model model){
        Pagenation pagenation = new Pagenation(page,10,communityService.recipeReviewCount());
        List<CommunityDTO> board = communityService.getRecipeReviews(pagenation);

        model.addAttribute("board",board);
        model.addAttribute("page",pagenation);

        return "community/recipeReview";
    }

    @GetMapping("/freeForum")
    public String freeForum(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page, Model model){
        Pagenation pagenation = new Pagenation(page,10,communityService.freeForumCount());
        List<CommunityDTO> board = communityService.getFreeForums(pagenation);

        model.addAttribute("board",board);
        model.addAttribute("page",pagenation);
        return "community/freeForum";
    }

    @MySecured
    @GetMapping("/form")
    public String form(@ModelAttribute("community") CommunityDTO community, Model model){

        List<RecipeDTO> recipes = Collections.emptyList();
        model.addAttribute("recipes",recipes);
        return "community/form";
    }


    @MySecured
    @PostMapping("/form")
    public String forFormSubmit(@Validated @ModelAttribute("community") CommunityDTO community,
                                BindingResult bindingResult,
                                @RequestPart(value = "image",required=false) List<MultipartFile> image,
                                HttpSession session){
        if(bindingResult.hasErrors()){
            return "community/form";
        }
        //????????????
        String userId = getUserId(session);
        community.setUser_id(userId);

        communityService.save(community,image);

        return "redirect:/community/post?id="+community.getId();
    }

    private String getUserId(HttpSession session) {
        String userId = (String) session.getAttribute("user_id");
        return userId;
    }

    //ajax
    @MySecured
    @PostMapping("/form/searchRecipe")
    public String searchRecipeByKeyword(String searchKey, Model model){
        List<RecipeDTO> recipes = recipeService.searchListByKeyword(searchKey);
        model.addAttribute("recipes",recipes);
       return "community/form :: .recipe-box";
    }

    @MySecured
    @GetMapping("/post")
    public String post(Integer id, Model model, HttpSession session){

        String userId = getUserId(session);

        //???????????? ????????? ?????? ????????? ????????? ???????????? ?????????.
        CommunityDTO post = communityService.findPostWithLikeInfo(id,userId);

        //??????
        List<CommunityCommentDTO> comments = communityService.findComments(id);

        //?????? ????????? ??????????????? ????????? ????????? ?????????.
        String category = post.getCategory();
        if(category.equals("1")){
            if(post.getRcp_seq()==null){
                model.addAttribute("deletedRecipe", true);
            }else{
                Integer rep_scq = post.getRcp_seq();
                RecipeDTO recipeDTO = recipeService.contentProcess(rep_scq);
                model.addAttribute("recipe", recipeDTO);
            }
        }

        //?????????
        model.addAttribute("community",post);
        //??????
        model.addAttribute("comments",comments);

        return "community/post";
    }

    private UserDTO getUser(HttpSession session) {
        return (UserDTO) session.getAttribute("user");
    }


    @MySecured
    @GetMapping("/edit/{postId}")
    public String editPostById(@PathVariable Integer postId, Model model){
        CommunityDTO post = communityService.findPostById(postId);

        List<RecipeDTO> recipes = Collections.emptyList();
        model.addAttribute("community",post);
        model.addAttribute("recipes",recipes);

        return "community/edit";
    }

    @MySecured
    @PostMapping("/edit/{postId}")
    public String editPostByIdSubmit(@PathVariable Integer postId, CommunityDTO community, @RequestPart(value = "image",required=false) List<MultipartFile> image,HttpSession session){
        String user_id = getUser(session).getUser_id();
        //?????? ??? ??????????????? ??????????????? ??????
        if (user_id.equals(communityService.findPostById(postId).getUser_id()) || user_id.equals("admin")) {
            community.setId(postId);
            communityService.editPost(community, image);
        }
        return "redirect:/community/post?id="+postId;
    }

    @MySecured
    @GetMapping("/delete/{postId}")
    public String deletePostById(@PathVariable Integer postId, HttpSession session){
        String user_id = getUser(session).getUser_id();
        //?????? ??? ??????????????? ??????????????? ??????
        if (user_id.equals(communityService.findPostById(postId).getUser_id()) || user_id.equals("admin")){
            communityService.deletePost(postId);
        }
        return "redirect:/community";
    }

    @MySecured
    @GetMapping("/report/{postId}")
    public String reportPostById(@PathVariable Integer postId){
        communityService.reportPost(postId);
        return "redirect:/community/post?id="+postId;
    }

    //?????????
    //ajax
    @MySecured
    @ResponseBody
    @PostMapping("/like")
    public Integer updateLikeCnt(Integer postId, boolean add,HttpSession session){

        UserDTO user = getUser(session);
        String userId = user.getUser_id();

        CommunityDTO post;
        if(add==true){
            communityService.addLikeCnt(postId,userId);
            post = communityService.findPostWithLikeInfo(postId, userId);
            post.setLiked(true);
        }else{
            communityService.subtractLikeCnt(postId,userId);
            post = communityService.findPostWithLikeInfo(postId, userId);
        }
        return post.getLike_count();
    }

    //??????
    @MySecured
    @PostMapping("/post/comment")
    public String submitComment(CommunityCommentDTO communityCommentDTO,HttpSession session, HttpServletRequest request){
        UserDTO user = getUser(session);
        String userId = user.getUser_id();
        communityCommentDTO.setUser_id(userId);
        communityService.postComment(communityCommentDTO);

        String refererLink = request.getHeader("referer");

        return "redirect:"+refererLink;
    }

    //????????????
    //ajax
    @MySecured
    @ResponseBody
    @PostMapping("/post/comment/edit")
    public void editComment(Integer commentId, String content,HttpSession session){
        String user_id = getUser(session).getUser_id();
        if(user_id.equals(communityService.findCommentById(commentId).getUser_id()) || user_id.equals("admin")){
            communityService.editComment(Map.of("commentId",commentId,"content",content));
        }
    }

    @MySecured
    @GetMapping("/post/comment/delete")
    public String deleteComment(Integer commentId, HttpServletRequest request,HttpSession session){
        String user_id = getUser(session).getUser_id();
        if(user_id.equals(communityService.findCommentById(commentId).getUser_id()) || user_id.equals("admin")){
            communityService.deleteComment(commentId);
        }
        String refererLink = request.getHeader("referer");

        return "redirect:"+refererLink;
    }

    @MySecured
    @GetMapping("/post/comment/report")
    public String reportComment(Integer commentId, HttpServletRequest request){
        communityService.reportComment(commentId);
        String refererLink = request.getHeader("referer");

        return "redirect:"+refererLink;
    }


    //????????????
    int totalCnt;
    CommunitySearchForm form;
    @GetMapping("/search")
    public String detailSearch(@ModelAttribute("searchForm") CommunitySearchForm searchForm,
                               @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                               Model model, HttpServletRequest request){

        //????????? ????????? ??????????????? ?????? ??? ?????????. ????????? ?????????.
        if(isFromSearch(request)){
            Pagenation pagenation = new Pagenation(page,10,totalCnt);
            List<CommunityDTO> communityBySearch = communityService.findCommunityBySearch(form, pagenation);
            CommunitySearchForm communitySearchForm = form;

            model.addAttribute("board",communityBySearch);
            model.addAttribute("searchForm",communitySearchForm);
            model.addAttribute("page",pagenation);
        }

        return "community/detailSearch";
    }

    private boolean isFromSearch(HttpServletRequest request) {
        String[] referer = request.getHeader("referer").split("/");
        String lastUri = referer[referer.length - 1];
        return lastUri.contains("search");
    }
    
    @PostMapping("/search")
    public String detailSearchSubmit(CommunitySearchForm searchForm){
        form=searchForm;
        totalCnt = communityService.countCommunityBySearch(searchForm);
        return "redirect:/community/search";
    }



    //    @GetMapping("/search")
//    public String detailSearch(@ModelAttribute("searchForm") CommunitySearchForm searchForm,
//                               @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
//                               Model model){
//
//        //????????? ?????? form??? ???????????? ?????? ?????????
//        if(form!=null){
//            Pagenation pagenation = new Pagenation(page,10,totalCnt);
//            List<CommunityDTO> communityBySearch = communityService.findCommunityBySearch(form, pagenation);
//            CommunitySearchForm communitySearchForm = form;
//
//            model.addAttribute("board",communityBySearch);
//            model.addAttribute("searchForm",communitySearchForm);
//            model.addAttribute("page",pagenation);
//        }
//
//        return "community/detailSearch";
//    }



}
