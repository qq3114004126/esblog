package cn.lger.dao;

import cn.lger.domain.MemberGrade;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-06.
 */
public interface MemberGradeDao extends JpaRepository<MemberGrade, String> {

    MemberGrade findMemberGradeById(Integer id);

    List<MemberGrade> findMemberGradeByGradeName(String gradeName);

    @Override
    List<MemberGrade> findAll();

    @Override
    List<MemberGrade> findAll(Sort sort);

    @Override
    List<MemberGrade> findAllById(Iterable<String> iterable);

    @Override
    <S extends MemberGrade> List<S> saveAll(Iterable<S> iterable);

    @Override
    void flush();

    @Override
    <S extends MemberGrade> S saveAndFlush(S s);

    @Override
    void deleteInBatch(Iterable<MemberGrade> iterable);

    @Override
    void deleteAllInBatch();

    @Override
    MemberGrade getOne(String s);

    @Override
    <S extends MemberGrade> List<S> findAll(Example<S> example);

    @Override
    <S extends MemberGrade> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends MemberGrade> S save(S s);

    @Override
    Optional<MemberGrade> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    long count();

    @Override
    void deleteById(String s);

    @Override
    void delete(MemberGrade memberGrade);

    @Override
    void deleteAll(Iterable<? extends MemberGrade> iterable);

    @Override
    void deleteAll();

    @Override
    <S extends MemberGrade> Optional<S> findOne(Example<S> example);

    @Override
    <S extends MemberGrade> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends MemberGrade> long count(Example<S> example);

    @Override
    <S extends MemberGrade> boolean exists(Example<S> example);

    @Override
    Page<MemberGrade> findAll(Pageable pageable);

}
