package com.llajournade.myreddit.service;

import com.llajournade.myreddit.dto.CommentsDto;
import com.llajournade.myreddit.exception.PostNotFoundException;
import com.llajournade.myreddit.mapper.CommentMapper;
import com.llajournade.myreddit.model.Comment;
import com.llajournade.myreddit.model.NotificationEmail;
import com.llajournade.myreddit.model.Post;
import com.llajournade.myreddit.model.User;
import com.llajournade.myreddit.repository.CommentRepository;
import com.llajournade.myreddit.repository.PostRepository;
import com.llajournade.myreddit.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CommentService {
    private static final String POST_URL = "";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

    public void save(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
        commentRepository.save(comment);
        String message = mailContentBuilder.build(authService.getCurrentUser().getUsername() + " posted a comment on your post." + POST_URL);
        log.info("user:"+post.getUser());
        sendCommentNotification(message, post.getUser());
    }

    private void sendCommentNotification(String message, User user) {
        log.info("username:"+user.getUsername());
        log.info("email:"+user.getEmail());
        mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your post", user.getEmail(), message));
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentRepository.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto).collect(Collectors.toList());
    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentRepository.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
