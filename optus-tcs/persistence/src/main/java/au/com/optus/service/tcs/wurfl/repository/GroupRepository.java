package au.com.optus.service.tcs.wurfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.optus.service.tcs.wurfl.jpa.domain.Group;

//@Transactional(propagation=Propagation.MANDATORY)
public interface GroupRepository extends JpaRepository<Group, Long>{

}
