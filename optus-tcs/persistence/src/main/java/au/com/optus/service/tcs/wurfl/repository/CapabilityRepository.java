package au.com.optus.service.tcs.wurfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.optus.service.tcs.wurfl.jpa.domain.Capability;

//@Transactional(propagation=Propagation.MANDATORY)
public interface CapabilityRepository extends JpaRepository<Capability, Long> {

}
