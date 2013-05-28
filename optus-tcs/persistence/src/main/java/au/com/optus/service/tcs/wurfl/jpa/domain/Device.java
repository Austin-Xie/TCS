package au.com.optus.service.tcs.wurfl.jpa.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Audited
@Table(name = "Wurfl_Device")
public class Device extends AbstractEntity {
	@Column(name="device_id")
	private String deviceId;

	@Column(name="user_agent")
	private String userAgent;

	@Column(name="fall_back")
	private String fallBack;

	@Column(name="actual_device_root")
	private String actualDeviceRoot;

	@Column(name="is_actual_device")
	private Boolean isAcutalDevice;

	@Column(name="is_patched")
	private Boolean isPatched;

	private String digest;

	@Column(name="extension_field1")
	private String extensionField1;

	@Column(name="extension_field2")
	private String extensionField2;

	@Column(name="last_updater")
	private String lastUpdater;

	@Column(name="last_updated_time")
	private Calendar lastUpdatedTime;

	@Column(name="last_update_source")
	private String lastUpdateSource;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="device_id")
	private final Set<Group> groups = new HashSet<Group> ();

	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name = "wurfl_source_id")
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private WurflSource wurflSource;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getFallBack() {
		return fallBack;
	}

	public void setFallBack(String fallBack) {
		this.fallBack = fallBack;
	}

	public String getActualDeviceRoot() {
		return actualDeviceRoot;
	}

	public void setActualDeviceRoot(String actualDeviceRoot) {
		this.actualDeviceRoot = actualDeviceRoot;
	}

	public Boolean getIsAcutalDevice() {
		return isAcutalDevice;
	}

	public void setIsAcutalDevice(Boolean isAcutalDevice) {
		this.isAcutalDevice = isAcutalDevice;
	}

	public Boolean getIsPatched() {
		return isPatched;
	}

	public void setIsPatched(Boolean isPatched) {
		this.isPatched = isPatched;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
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

	public String getLastUpdater() {
		return lastUpdater;
	}

	public void setLastUpdater(String lastUpdater) {
		this.lastUpdater = lastUpdater;
	}

	public Calendar getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Calendar lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getLastUpdateSource() {
		return lastUpdateSource;
	}

	public void setLastUpdateSource(String lastUpdateSource) {
		this.lastUpdateSource = lastUpdateSource;
	}

	public WurflSource getWurflSource() {
		return wurflSource;
	}

	public void setWurflSource(WurflSource wurflSource) {
		this.wurflSource = wurflSource;
	}

	public Set<Group> getGroups() {
		return groups;
	}

}
