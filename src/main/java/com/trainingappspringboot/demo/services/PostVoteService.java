package com.trainingappspringboot.demo.services;

import com.trainingappspringboot.demo.models.PostVote;
import com.trainingappspringboot.demo.repositories.PostVotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostVoteService {

    private PostVotesRepository postVotesDao;

    @Autowired
    public PostVoteService(PostVotesRepository postVotesDao) {
        this.postVotesDao = postVotesDao;
    }

    public void savePostVote(PostVote postVote) {
        postVotesDao.save(postVote);
    }

    public void deletePostVote(PostVote postVote) {
        postVotesDao.delete(postVote);
    }
}
