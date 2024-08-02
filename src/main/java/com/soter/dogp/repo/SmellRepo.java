package com.soter.dogp.repo;

import com.soter.dogp.objcts.Cheiro;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface SmellRepo extends JpaRepository<Cheiro, Integer> {
    @Query(value = "SELECT * FROM cheiro_table WHERE cheirador_id = :user_id", nativeQuery = true)
    List<Cheiro> getCheiradosBy(Integer user_id);

    @Query(value = "SELECT * FROM cheiro_table WHERE cheirado_id = :chid", nativeQuery = true)
    List<Integer> getAnyByCheirado(Integer chid);

    @Query(value = "SELECT * FROM cheiro_table WHERE cheirado_id = :cheirado AND cheirador_id = :cheirador;", nativeQuery = true)
    List<Cheiro> getAllByCoordinates(Integer cheirado, Integer cheirador);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cheiro_table SET is_hunted = :switcher WHERE cheirador_id = :user_id AND cheirado_id = :cheirado_id", nativeQuery = true)
    void activateHuntForThePiss(Integer user_id, Integer cheirado_id, boolean switcher);

    @Query(value = "SELECT is_hunted FROM cheiro_table WHERE cheirador_id = :user_id AND cheirado_id = :cheirado_id", nativeQuery = true)
    Boolean isItAlreadyPiss(Integer user_id, Integer cheirado_id );
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO cheiro_table(cheirador_id, cheirado_id) VALUES (:user_id, :cheirado_id);", nativeQuery = true)
    void registerSmell(Integer user_id, Integer cheirado_id);

    @Query(value = "SELECT cheirado_id FROM cheiro_table WHERE cheirador_id = :user_id and is_hunted = true", nativeQuery = true)
    List<Integer> listHuntedId(Integer user_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cheiro_table SET apelido = :apelido WHERE id = :id", nativeQuery = true)
    void changeApelido(Integer id, String apelido);

    @Query(value = "SELECT DISTINCT apelido FROM cheiro_table WHERE cheirado_id = :userid and cheirador_id = :session_user", nativeQuery = true)
    String findAppelidoByUserId(int userid, Integer session_user);
}
