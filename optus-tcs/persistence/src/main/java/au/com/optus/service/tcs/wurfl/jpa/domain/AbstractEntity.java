package au.com.optus.service.tcs.wurfl.jpa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class AbstractEntity {
	@Id
	@GeneratedValue
	private Long id;

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
