package com.llajournade.myreddit.repository;

import com.llajournade.myreddit.model.Post;
import com.llajournade.myreddit.model.User;
import com.llajournade.myreddit.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
