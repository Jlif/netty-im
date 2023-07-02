package tech.jiangchen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.jiangchen.entity.ContactMultiKeys;
import tech.jiangchen.entity.MessageContact;

import java.util.List;

@Repository
public interface MessageContactRepository extends JpaRepository<MessageContact, ContactMultiKeys> {

    public List<MessageContact> findMessageContactsByOwnerUidOrderByMidDesc(Long ownerUid);
}
