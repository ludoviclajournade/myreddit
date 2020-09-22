package com.llajournade.myreddit.config;

import mapper.PostMapper;
import mapper.PostMapperImpl;
import mapper.SubredditMapper;
import mapper.SubredditMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingBeanConfiguration {

    @Bean
    public SubredditMapper subredditMapper() {
        SubredditMapper subredditMapper = new SubredditMapperImpl();
        return subredditMapper;
    }

    @Bean
    public PostMapper postMapper() {
        PostMapper postMapper = new PostMapperImpl();
        return postMapper;
    }
}
