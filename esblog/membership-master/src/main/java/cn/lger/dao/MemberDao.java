package cn.lger.dao;

import cn.lger.domain.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-06.
 */
public interface MemberDao extends JpaRepository<Member, String> {

    Member findMemberById(String id);

    @Override
    Page<Member> findAll(Pageable pageable);

    @Query("select m from Member m where m.memberName = ?1")
    Page<Member> findAllByMemberName(String memberName, Pageable pageable);

    @Query("select count(m.id) from  Member  m")
    int queryAllCount();

    List<Member> findByBirthday(LocalDate birthday);

    @Override
    List<Member> findAll();

    @Override
    List<Member> findAll(Sort sort);

    @Override
    List<Member> findAllById(Iterable<String> iterable);

    @Override
    <S extends Member> List<S> saveAll(Iterable<S> iterable);

    @Override
    void flush();

    @Override
    <S extends Member> S saveAndFlush(S s);

    @Override
    void deleteInBatch(Iterable<Member> iterable);

    @Override
    void deleteAllInBatch();

    @Override
    Member getOne(String s);

    @Override
    <S extends Member> List<S> findAll(Example<S> example);

    @Override
    <S extends Member> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Member> S save(S s);

    @Override
    Optional<Member> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    long count();

    @Override
    void deleteById(String s);

    @Override
    void delete(Member member);

    @Override
    void deleteAll(Iterable<? extends Member> iterable);

    @Override
    void deleteAll();

    @Override
    <S extends Member> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Member> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Member> long count(Example<S> example);

    @Override
    <S extends Member> boolean exists(Example<S> example);
}
