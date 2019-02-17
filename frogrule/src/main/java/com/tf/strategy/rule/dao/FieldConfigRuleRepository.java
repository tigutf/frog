package com.tf.strategy.rule.dao;

import com.tf.strategy.rule.domain.FieldConfigRule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface FieldConfigRuleRepository extends JpaRepository<FieldConfigRule, Long> {

    public FieldConfigRule findByFieldKey(String fieldKey);

    @Transactional(propagation = Propagation.NESTED)
    //TODO 重写分页sql，pageable的内部类型int最大值限制
    public Page<FieldConfigRule> findAll(Pageable pageable);

    @Query(value = "select * from field_config_rule u where 1 LIMIT ?1 , ?2", nativeQuery = true)
    public List<FieldConfigRule> queryFieldConfigRuleByPage(Long offset, Long limit);

    @Transactional(propagation = Propagation.REQUIRED)
    @Modifying
    @Query("update FieldConfigRule u set u.fieldKey = ?1 where u.id = ?2")
    public int updateFieldConfigRule(String fieldKey, Long id);

}
