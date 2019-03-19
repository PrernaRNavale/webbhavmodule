package com.bhavcopy.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "stock_price")
@EntityListeners(AuditingEntityListener.class)
public class StockPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	/*@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	*/
	@Column(name = "user_id")
	public Long StockId;
	
	@Column(name = "unique_identifier",length=255)
	private String uniqueIdentifier;
	
	@Column(name = "symbol",length=255)
	public String Symbol;
	
	@Column(name = "series",length=255)
	public String Series;
	
	@Column(name = "open",length=255)
	public String Open;
	
	@Column(name = "high",length=255)
	public String High;
	
	@Column(name = "low",length=255)
	public String Low;
	
	@Column(name = "close",length=255)
	public String Close;
	
	@Column(name = "last",length=255)
	public String Last;
	
	@Column(name = "prevclose",length=255)
	public String Prevclose;
	
	@Column(name = "tottrdqty",length=255)
	public String TOTTRDQTY;
	
	@Column(name = "tottrdval",length=255)
	public String TOTTRDVAL;
	
	@Column(name = "timestamp",length=255)
	public String TIMESTAMP;
	
	@Column(name = "totaltrades",length=255)
	public String TOTALTRADES;
	
	@Column(name = "isin",length=255)
	public String ISIN;


	public Long getStockId() {
		return StockId;
	}

	public void setStockId(Long stockId) {
		StockId = stockId;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public String getSeries() {
		return Series;
	}

	public void setSeries(String series) {
		Series = series;
	}

	public String getOpen() {
		return Open;
	}

	public void setOpen(String open) {
		Open = open;
	}

	public String getHigh() {
		return High;
	}

	public void setHigh(String high) {
		High = high;
	}

	public String getLow() {
		return Low;
	}

	public void setLow(String low) {
		Low = low;
	}

	public String getClose() {
		return Close;
	}

	public void setClose(String close) {
		Close = close;
	}

	public String getLast() {
		return Last;
	}

	public void setLast(String last) {
		Last = last;
	}

	public String getPrevclose() {
		return Prevclose;
	}

	public void setPrevclose(String prevclose) {
		Prevclose = prevclose;
	}

	public String getTOTTRDQTY() {
		return TOTTRDQTY;
	}

	public void setTOTTRDQTY(String tOTTRDQTY) {
		TOTTRDQTY = tOTTRDQTY;
	}

	public String getTOTTRDVAL() {
		return TOTTRDVAL;
	}

	public void setTOTTRDVAL(String tOTTRDVAL) {
		TOTTRDVAL = tOTTRDVAL;
	}

	public String getTIMESTAMP() {
		return TIMESTAMP;
	}

	public void setTIMESTAMP(String tIMESTAMP) {
		TIMESTAMP = tIMESTAMP;
	}

	public String getTOTALTRADES() {
		return TOTALTRADES;
	}

	public void setTOTALTRADES(String tOTALTRADES) {
		TOTALTRADES = tOTALTRADES;
	}

	public String getISIN() {
		return ISIN;
	}

	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}

	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}
	
	

	
}	