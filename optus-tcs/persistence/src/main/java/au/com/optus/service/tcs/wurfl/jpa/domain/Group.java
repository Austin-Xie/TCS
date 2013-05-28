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

	@ManyToOne
	@JoinColumn(name="device_id")
	private Device device;

	@OneToMany
	@JoinColumn(name = "group_id")
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

}
