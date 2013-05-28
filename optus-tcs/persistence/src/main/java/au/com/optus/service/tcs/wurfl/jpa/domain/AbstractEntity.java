package au.com.optus.service.tcs.wurfl.jpa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;


@MappedSuperclass
public class AbstractEntity {
	@Id
	@SequenceGenerator(name = "TCS_WURFL_SEQ", sequenceName = "TCS_WURFL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TCS_WURFL_SEQ")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof Long))
			return false;

		if (this == obj || this.equals(obj))
			return true;

		return false;
	}

}
