package com.trainingappspringboot.demo.repositories;

import com.trainingappspringboot.demo.models.PostVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostVotesRepository extends JpaRepository<PostVote, Integer> {

    //    int totalPostVotes(Long id);
    PostVote save(PostVote postVote);

    void delete(PostVote postVote);
}
