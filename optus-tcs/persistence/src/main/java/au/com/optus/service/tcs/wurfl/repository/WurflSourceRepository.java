package au.com.optus.service.tcs.wurfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.optus.service.tcs.wurfl.jpa.domain.WurflSource;

public interface WurflSourceRepository extends JpaRepository<WurflSource, Long> {


}
