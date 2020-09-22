package mapper;

import com.llajournade.myreddit.dto.PostRequest;
import com.llajournade.myreddit.dto.PostResponse;
import com.llajournade.myreddit.model.*;
import com.llajournade.myreddit.repository.CommentRepository;
import com.llajournade.myreddit.repository.VoteRepository;
import com.llajournade.myreddit.service.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);

}
