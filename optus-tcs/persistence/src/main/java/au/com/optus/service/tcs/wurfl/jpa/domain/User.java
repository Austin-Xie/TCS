package au.com.optus.service.tcs.wurfl.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Wurfl_User")
public class User extends AbstractEntity{

	private String name, password;

}
