package enums;

public enum Mention {
	SS("SS"), MS("MS"), MM("MM"), MI("MI"), II("II"), SR("SR");

	public String mention;

	private Mention(String mention) {
		this.mention = mention;
	}
}
