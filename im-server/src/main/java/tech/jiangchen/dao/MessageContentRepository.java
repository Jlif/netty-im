package tech.jiangchen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.jiangchen.entity.MessageContent;

@Repository
public interface MessageContentRepository extends JpaRepository<MessageContent, Long> {

}
