package _2024.creativeproject.Enum;

public enum CurrencyUnit {

	JAPAN("JPY(100)"),
	USA("USD"),
	ARAB_EMIRATES("AED"),
	AUSTRALIA("AUD"),
	BAHRAIN("BHD"),
	BRUNEI("BND"),
	CANADA("CAD"),
	SWISS("CHF"),
	CHINA("CNH"),
	DENMARK("DKK"),
	EUROPE("EUR"),
	UK("GBP"),
	HONG_KONG("HKD"),
	INDONESIA("IDR(100)"),
	KOREA("KRW"),
	KUWAIT("KWD"),
	MALAYSIA("MYR"),
	NORWAY("NOK"),
	NEW_ZEALAND("NZD"),
	SAUDI("SAR"),
	SWEDEN("SEK"),
	SINGAPORE("SGD"),
	TAIWAN("THB");

	private final String unit;
	CurrencyUnit(String data){
		unit = data;
	}

	public String getValue() {
		return unit;
	}

}
