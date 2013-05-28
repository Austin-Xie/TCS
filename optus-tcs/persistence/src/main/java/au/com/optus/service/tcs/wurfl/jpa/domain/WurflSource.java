package au.com.optus.service.tcs.wurfl.jpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Wurfl_Source")
public class WurflSource extends AbstractEntity {

	private String sourceName;

	private String memo;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "source_data")
	private byte[] sourceData;

	private String updater;

	@Column(name = "source_type")
	private String sourceType;

	@OneToMany
	@JoinColumn(name = "wurfl_source_id")
	private final Set<Device> devices = new HashSet<Device> ();

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public byte[] getSourceData() {
		return sourceData;
	}

	public void setSourceData(byte[] sourceData) {
		this.sourceData = sourceData;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public Set<Device> getDevices() {
		return devices;
	}

}
