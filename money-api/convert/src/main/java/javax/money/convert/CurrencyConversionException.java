/**
 * CREDIT SUISSE IS WILLING TO LICENSE THIS SPECIFICATION TO YOU ONLY UPON THE CONDITION THAT YOU ACCEPT ALL OF THE TERMS CONTAINED IN THIS AGREEMENT. PLEASE READ THE TERMS AND CONDITIONS OF THIS AGREEMENT CAREFULLY. BY DOWNLOADING THIS SPECIFICATION, YOU ACCEPT THE TERMS AND CONDITIONS OF THE AGREEMENT. IF YOU ARE NOT WILLING TO BE BOUND BY IT, SELECT THE "DECLINE" BUTTON AT THE BOTTOM OF THIS PAGE.
 *
 * Specification:  JSR-354  Money and Currency API ("Specification")
 *
 * Copyright (c) 2012-2013, Credit Suisse
 * All rights reserved.
 */
package javax.money.convert;

import javax.money.CurrencyUnit;
import javax.money.MonetaryException;

/**
 * Exception thrown when a monetary conversion operation fails.
 * 
 * @author Werner Keil
 * @author Stephen Colebourne
 * @author Anatole Tresch
 */
public class CurrencyConversionException extends MonetaryException {

	/** Serialization lock. */
	private static final long serialVersionUID = -7743240650686883450L;

	/** Source currency. */
	private CurrencyUnit source;
	/** Target currency. */
	private CurrencyUnit target;

	/** The acquired target timestamp, may be null. */
	private Long timestamp;

	/**
	 * Constructs an <code>CurrencyConversionException</code> with the specified
	 * detail message, timestamp, source and target currency.
	 * 
	 * @param source
	 *            the source currency, may be null.
	 * 
	 * @param target
	 *            the target currency, may be null.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public CurrencyConversionException(CurrencyUnit source,
			CurrencyUnit target, Long timestamp, String message) {
		super("Cannot convert " + String.valueOf(source) + " into "
				+ String.valueOf(target) +": " + message);
		this.source = source;
		this.target = target;
		this.timestamp = timestamp;
	}

	/**
	 * Constructs an <code>CurrencyConversionException</code> with the specified
	 * source and target currency.
	 * 
	 * @param source
	 *            the source currency, may be null.
	 * 
	 * @param target
	 *            the target currency, may be null.
	 */
	public CurrencyConversionException(CurrencyUnit source,
			CurrencyUnit target, Long timestamp) {
		super("Cannot convert " + String.valueOf(source) + " into "
				+ String.valueOf(target));
		this.source = source;
		this.target = target;
		this.timestamp = timestamp;
	}

	/**
	 * Constructs a new exception with the specified source and target currency,
	 * detail message and cause.
	 * 
	 * <p>
	 * Note that the detail message associated with <code>cause</code> is
	 * <i>not</i> automatically incorporated in this exception's detail message.
	 * 
	 * @param source
	 *            the source currency, may be null.
	 * @param target
	 *            the target currency, may be null.
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *            {@link Throwable#getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link Throwable#getCause()} method). (A <tt>null</tt> value
	 *            is permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 */
	public CurrencyConversionException(CurrencyUnit source,
			CurrencyUnit target, Long timestamp, String message, Throwable cause) {
		super(message, cause);
		this.source = source;
		this.target = target;
		this.timestamp = timestamp;
	}

	/**
	 * Gets the first currency at fault.
	 * 
	 * @return the currency at fault, may be null
	 */
	public CurrencyUnit getBase() {
		return source;
	}

	/**
	 * Gets the second currency at fault.
	 * 
	 * @return the currency at fault, may be null
	 */
	public CurrencyUnit getTerm() {
		return target;
	}

	/**
	 * Gets the queried timestamp at fault.
	 * 
	 * @return the queried timestamp, or {@code null}.
	 */
	public Long getTimestamp() {
		return this.timestamp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrencyConversionException [source=" + source + ", target="
				+ target + ", timestamp=" + timestamp + "]: " + getMessage();
	}

}
