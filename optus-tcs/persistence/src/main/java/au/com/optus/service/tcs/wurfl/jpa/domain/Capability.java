package au.com.optus.service.tcs.wurfl.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "Wurfl_Capability")
public class Capability extends AbstractEntity{

	private String name, value;

	@Column(name="extension_field1")
	private String extensionField1;

	@Column(name="extension_field2")
	private String extensionField2;

	//	@OneToOne(orphanRemoval=true)
	//	@JoinTable(name = "Wurfl_Group_Capability", joinColumns = @JoinColumn(name = "Wurfl_Capability_id", referencedColumnName="id"),
	//	inverseJoinColumns = @JoinColumn(name = "Wurfl_Group_id", referencedColumnName="id"))
	@ManyToOne
	@JoinColumn(name="group_id") //, insertable=false, updatable=false)
	private Group group;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_time")
	private Date lastUpdatedTime;

	//	@ElementCollection

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getExtensionField1() {
		return extensionField1;
	}

	public void setExtensionField1(String extensionField1) {
		this.extensionField1 = extensionField1;
	}

	public String getExtensionField2() {
		return extensionField2;
	}

	public void setExtensionField2(String extensionField2) {
		this.extensionField2 = extensionField2;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}


	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Capability other = (Capability) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
