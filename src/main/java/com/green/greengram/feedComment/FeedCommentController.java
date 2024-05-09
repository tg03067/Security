package com.green.greengram.feedComment;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.feed.model.FeedGetRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.green.greengram.feedComment.model.*;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/feed/comment")
@Tag(name = "Feed 댓글", description = "댓글쓰기")
public class FeedCommentController {
    private final FeedCommentService service ;

    @PostMapping
    @Operation(summary = "댓글쓰기")
    public ResultDto<Long> postFeedComment(@RequestBody FeedCommentPostReq p){
        long feedCommentId = service.postFeedComment(p);

        return ResultDto.<Long>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(feedCommentId).
                build();
    }
    @DeleteMapping
    @Operation(summary = "댓글지우기")
    public ResultDto<Integer> deleteFeedComment(@ParameterObject @ModelAttribute FeedCommentDeleteReq p){
        int result = service.delFeedComment(p) ; //0은 삭제 실패, 1은 삭제 성공

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).
                build();
    }
}