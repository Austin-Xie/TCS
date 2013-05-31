package au.com.optus.service.tcs.wurfl.jpa.domain;


import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "Wurfl_Group")
public class Group extends AbstractEntity {

	@Column(name="group_id")
	private String groupId;

	private String digest;

	@Column(name="json_capabilities")
	@Basic(fetch=FetchType.LAZY)
	private String jsonCapabilities;

	@Column(name="extension_field1")
	private String extensionField1;

	@Column(name="extension_field2")
	private String extensionField2;

	@Column(name="last_updated_time")
	private Calendar lastUpdatedTime;


	//	@JoinTable(name = "Wurfl_Device_Group",
	//	joinColumns = @JoinColumn(name = "Wurfl_Group_id", referencedColumnName = "id"),
	//	inverseJoinColumns = @JoinColumn(name = "Wurfl_Device_id",  referencedColumnName="id"))
	@ManyToOne
	@JoinColumn(name="device_id")//, updatable=false, insertable=false)
	//	@NotAudited
	private Device device;

	@OneToMany(fetch=FetchType.EAGER, orphanRemoval=true)
	//	@JoinTable(name = "Wurfl_Group_Capability", joinColumns = @JoinColumn(name = "Wurfl_Group_id", referencedColumnName="id"),
	//	inverseJoinColumns = @JoinColumn(name = "Wurfl_Capability_id", referencedColumnName="id"))
	@JoinColumn(name="group_id")
	@Audited
	private final Set<Capability> capabilities = new HashSet<Capability> ();

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getJsonCapabilities() {
		return jsonCapabilities;
	}

	public void setJsonCapabilities(String jsonCapabilities) {
		this.jsonCapabilities = jsonCapabilities;
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

	public Calendar getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Calendar lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Set<Capability> getCapabilities() {
		return capabilities;
	}

	public Set<Capability> addCapability(Capability capability) {
		capability.setGroup(this);
		capabilities.add(capability);
		return capabilities;
	}

	public Set<Capability> removeCapability(Capability capability) {
		capabilities.remove(capability);
		return capabilities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
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
		Group other = (Group) obj;
		if (device == null) {
			if (other.device != null)
				return false;
		} else if (!device.equals(other.device))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		return true;
	}

}
