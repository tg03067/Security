package com.green.greengram.feed;

import com.green.greengram.common.model.*;
import com.green.greengram.feed.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/feed")
@Slf4j
@Tag(name = "Feed 피드", description = "Feed CRUD")
public class FeedControllerImpl {
    private final FeedServiceImpl service;

    @PostMapping
    @Operation(summary = "Feed 등록", description = "")
    public MyResponse<FeedPostRes> postFeed(@RequestPart List<MultipartFile> pics,
                                            @RequestPart FeedPostReq p){
        FeedPostRes result = service.postFeed(pics, p);

        return MyResponse.<FeedPostRes>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }

    @GetMapping
    @Operation(summary = "Feed 리스트", description = "loginUserId는 로그인한 사용자의 PK")
    public MyResponse<List<FeedGetRes>> getFeed(@ParameterObject @ModelAttribute FeedGetReq p){
        List<FeedGetRes> list = service.getFeed(p);

        return MyResponse.<List<FeedGetRes>>builder().
                statusCode(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(list).
                build();
    }
}
