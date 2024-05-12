package _2024.creativeproject.utils.Enum;

public enum CurrencyUnit {

	JPY("JPY(100)"),
	USD("USD"),
	AED("AED"),
	AUD("AUD"),
	BHD("BHD"),
	BND("BND"),
	CAD("CAD"),
	CHF("CHF"),
	CNH("CNH"),
	DKK("DKK"),
	EUR("EUR"),
	GBP("GBP"),
	HKD("HKD"),
	IDR("IDR(100)"),
	KRW("KRW"),
	KWD("KWD"),
	MYR("MYR"),
	NOK("NOK"),
	NZD("NZD"),
	SAR("SAR"),
	SEK("SEK"),
	SGD("SGD"),
	THB("THB");

	private final String unit;

	CurrencyUnit(String data){
		unit = data;
	}

	public String getValue() {
		return unit;
	}

}
